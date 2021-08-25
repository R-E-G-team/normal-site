package com.example.reg.util;

public class Braille {
    final static char[] etc = {'가', '나', '다', '마', '바', '사', '자', '카', '타', '파', '하', '억', '언', '얼', '연', '열', '영', '옥', '온', '옹', '운', '울', '은', '을', '인', '것'};
    final static String[] etcBraille = {"⠫", "⠉", "⠊", "⠑", "⠘", "⠇", "⠣", "⠨", "⠋", "⠓", "⠙", "⠚", "⠹", "⠾", "⠞", "⠡", "⠳", "⠻", "⠭", "⠷", "⠿", "⠛", "⠯", "⠵", "⠮", "⠟", "⠸⠎"};
    final static String[] ChoSung = {"⠈", "⠠⠈", "⠉", "⠊", "⠠⠊", "⠐", "⠑", "⠘", "⠠⠘", "⠠", "⠠⠠", "", "⠨", "⠠⠨", "⠰", "⠋", "⠓", "⠙", "⠚"};
    final static String[] JwungSung = {"⠣", "⠗", "⠜", "⠜⠗", "⠎", "⠝", "⠱", "⠌", "⠥", "⠧", "⠧⠗", "⠽", "⠬", "⠍", "⠏", "⠏⠗", "⠍⠗", "⠩", "⠪", "⠺", "⠕"};
    final static String[] JongSung = {"", "⠁", "⠁⠁", "⠁⠄", "⠒", "⠒⠅", "⠒⠴", "⠔", "⠂", "⠂⠁", "⠂⠢", "⠂⠃", "⠂⠄", "⠂⠦", "⠂⠲", "⠂⠴", "⠢", "⠃", "⠃⠄", "⠄", "⠌", "⠶", "⠅", "⠆", "⠖", "⠦", "⠲", "⠴"};

    public static String makeBraille(String s) { // 유니코드 한글 문자열을 입력 받음
        int a, b, c; // 자소 버퍼: 초성/중성/종성 순
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            for (int j = 0; j < etc.length; j++) {
                if (etc[i] == ch) {
                    return etcBraille[i];
                }
            }
            if (ch >= 0xAC00 && ch <= 0xD7A3) { // "AC00:가" ~ "D7A3:힣" 에 속한 글자면 분해
                c = ch - 0xAC00;
                a = c / (21 * 28);
                c = c % (21 * 28);
                b = c / 28;
                c = c % 28;
                result = result + ChoSung[a] + JwungSung[b];
                if (c != 0) result = result + JongSung[c]; // c가 0이 아니면, 즉 받침이 있으면
            } else {
                result = result + ch;
            }
        }
        return result;
    }
}