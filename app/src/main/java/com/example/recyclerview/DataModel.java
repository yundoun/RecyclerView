package com.example.recyclerview;
// 모델 클래스
// 항목 중 하나를 나타내는 모든 데이터를 보유
public class DataModel {
    String text1;
    int image;

    public DataModel(String text1, int image) {
        this.text1 = text1;
        this.image = image;
    }

    public String getText1() {
        return text1;
    }

    public int getImage() {
        return image;
    }

}
