<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        img {
            width: 250px
        }
    </style>
</head>
<body>
<script src="/static/js/jquery-3.3.1.min.js"></script>
<script>
    $(function() {
        $(document).on("click", ".img", function(event) { //버튼을 클릭 했을시 popupOpen 함수 출력
            console.log('click');
            let filePath = $(this).attr('src');
            $.ajax({
                url: "/text_to_speech",
                data: {"filePath" : filePath},
                type: "get",
                success: function (result) {
                    window.speechSynthesis.cancel();
                    var voices = [];
                    function setVoiceList() {
                        voices = window.speechSynthesis.getVoices();
                    }
                    setVoiceList();
                    if (window.speechSynthesis.onvoiceschanged !== undefined) {
                        window.speechSynthesis.onvoiceschanged = setVoiceList;
                    }
                    console.log(result);
                    const speechMsg = new SpeechSynthesisUtterance()
                    speechMsg.rate = 0.7 // 속도: 0.1 ~ 10
                    speechMsg.pitch = 1 // 음높이: 0 ~ 2
                    speechMsg.lang = "ko-KR"
                    speechMsg.text = result
                    window.speechSynthesis.speak(speechMsg);
                }
            });
        });
    });
    $(function() {
        $(document).on("click", ".img2", function(event) { //버튼을 클릭 했을시 popupOpen 함수 출력
            console.log('click');
            let filePath = $(this).attr('src');
            $.ajax({
                url: "/component_to_speech",
                data: {"filePath" : filePath},
                type: "get",
                success: function (result) {
                    window.speechSynthesis.cancel();
                    var voices = [];
                    function setVoiceList() {
                        voices = window.speechSynthesis.getVoices();
                    }
                    setVoiceList();
                    if (window.speechSynthesis.onvoiceschanged !== undefined) {
                        window.speechSynthesis.onvoiceschanged = setVoiceList;
                    }
                    let component = "";
                    result.forEach(function (item, index) {
                        component = component + item + ",";
                    });
                    console.log(component);
                    const speechMsg = new SpeechSynthesisUtterance()
                    speechMsg.rate = 0.7 // 속도: 0.1 ~ 10
                    speechMsg.pitch = 1 // 음높이: 0 ~ 2
                    speechMsg.lang = "en"
                    speechMsg.text = component
                    window.speechSynthesis.speak(speechMsg);
                }
            });
        });
    });
    $(function() {
        $(document).on("click", ".img3", function(event) { //버튼을 클릭 했을시 popupOpen 함수 출력
            let path = "/text_to_braille?filePath=" + $(this).attr('src');
            let win = window.open(path, "PopupWin", "width=500,height=500");
        });
    });
</script>

<h1>정보가 있는 이미지를 음성으로 변환하기</h1>
<table>
    <tr>
        <td><img class="img" src="/static/1.png"></td>
        <td><img class="img" src="/static/2.png"></td>
        <td><img class="img" src="/static/3.png"></td>
    </tr>
</table>
<h1>정보가 없는 이미지를 음성으로 변환하기</h1>
<table>
    <tr>
        <td><img class="img2" src="/static/4.png"></td>
        <td><img class="img2" src="/static/5.png"></td>
        <td><img class="img2" src="/static/6.png"></td>
    </tr>
</table>
<h1>간단한 글 이미지 점자로 변환하기</h1>
<table>
    <tr>
        <td><img class="img3" src="/static/7.png"></td>
        <td><img class="img3" src="/static/8.png"></td>
    </tr>
</table>
</body>
</html>