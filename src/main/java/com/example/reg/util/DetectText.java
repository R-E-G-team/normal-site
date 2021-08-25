package com.example.reg.util;

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class DetectText {
    private List<String> text;
    private List<String> coordinate;

    public DetectText() {
        text = new ArrayList<>();
        coordinate = new ArrayList<>();
    }

    public static Map<String, int[]> detectText() throws IOException {
        String filePath = "/Users/oueya/Downloads/test.png";
        return detectText(filePath);
    }

    public static Map<String, int[]> detectText(String filePath) throws IOException {
        List<AnnotateImageRequest> requests = new ArrayList<>();
        Map<String, int[]> map = new LinkedHashMap<>();
        int count = 0;
        int width = 0;
        int height = 0;
        int initialX = 0;
        int initialY = 0;

        ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
                    return null;
                }

                for (EntityAnnotation annotation : res.getTextAnnotationsList()) {

                    if(count == 0) {
                        initialX = annotation.getBoundingPoly().getVerticesList().get(0).getX();
                        initialY = annotation.getBoundingPoly().getVerticesList().get(0).getY();
                        width = annotation.getBoundingPoly().getVerticesList().get(1).getX()
                                - annotation.getBoundingPoly().getVerticesList().get(0).getX();
                        height = annotation.getBoundingPoly().getVerticesList().get(2).getY()
                                - annotation.getBoundingPoly().getVerticesList().get(1).getY();
                        count++;
                    }

                    int [] coordinate = new int[3];
                    coordinate[0] = (annotation.getBoundingPoly().getVerticesList().get(0).getX() - initialX) * 100 / width;
                    coordinate[1] = (annotation.getBoundingPoly().getVerticesList().get(0).getY() - initialY) * 100 / height;
                    coordinate[2] = annotation.getBoundingPoly().getVerticesList().get(3).getY()
                            - annotation.getBoundingPoly().getVerticesList().get(0).getY();

                    map.put(Braille.makeBraille(annotation.getDescription()), coordinate);
                }
            }
        }

        return map;
    }
}