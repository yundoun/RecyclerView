package com.example.recyclerview;

// 필요한 클래스들을 임포트합니다.
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

// 'AppCompatActivity'를 상속받아 MainActivity 클래스를 정의합니다. 이 클래스는 앱의 메인 활동을 처리합니다.
public class MainActivity extends AppCompatActivity {

    // 데이터 모델 객체들을 저장할 ArrayList를 생성합니다. DataModel 타입의 객체들을 저장하기 위한 용도입니다.
    ArrayList<DataModel> dataModels = new ArrayList<>();

    // 이미지 리소스 ID를 저장하는 정수 배열입니다. 각 항목에 해당하는 이미지를 포함합니다.
    int[] images = {
            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,
            R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h,
            R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l,
            R.drawable.m, R.drawable.n, R.drawable.o
    };

    // 액티비티가 생성될 때 호출되는 메서드입니다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_main.xml 레이아웃을 현재 액티비티의 뷰로 설정합니다.
        setContentView(R.layout.activity_main);

        // 데이터 모델을 설정하는 메서드를 호출합니다.
        setDataModel();

        // RecyclerView를 XML에서 찾아와 변수에 할당합니다.
        RecyclerView recyclerView = findViewById(R.id.rv);
        // RecyclerView의 레이아웃 매니저를 설정합니다. 여기서는 선형 레이아웃 매니저를 사용합니다.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // RecyclerView에 사용할 어댑터를 생성하고 설정합니다. 생성자에 현재 컨텍스트와 데이터 모델 리스트를 전달합니다.
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dataModels);
        // 생성한 어댑터를 RecyclerView에 설정합니다.
        recyclerView.setAdapter(adapter);
    }

    // 데이터 모델 객체들을 초기화하고 ArrayList에 추가하는 메서드입니다.
    private void setDataModel() {
        // strings.xml 파일에 정의된 items 배열을 가져옵니다. 이 배열은 각 항목의 이름을 포함합니다.
        String[] items = getResources().getStringArray(R.array.items);
        // 모든 항목에 대해 반복하면서 각 항목의 이름과 이미지 리소스 ID를 이용하여 DataModel 객체를 생성하고 리스트에 추가합니다.
        for (int i = 0; i < items.length; i++) {
            dataModels.add(new DataModel(items[i], images[i]));
        }
    }
}
