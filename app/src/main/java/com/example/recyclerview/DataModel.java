package com.example.recyclerview;
// 모델 클래스
// 항목 중 하나를 나타내는 모든 데이터를 보유
// RecyclerView에 표시될 각 항목의 데이터 구조를 정의 : text1 과 image
public class DataModel {
    String text1;
    int image;

    // 생성자 메서드: 객체를 생성할 때 텍스트와 이미지 리소스 ID를 초기화합니다.
    public DataModel(String text1, int image) {
        this.text1 = text1;
        this.image = image;
    }
    // 텍스트 리소스 ID를 반환하는 getter 메서드입니다.
    public String getText1() {
        return text1;
    }
    // 이미지 리소스 ID를 반환하는 getter 메서드입니다.
    public int getImage() {
        return image;
    }

}
