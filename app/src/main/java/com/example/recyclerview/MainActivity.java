package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

// 모델을 생성하고 이를 arrayList 내에 저장함

    // 새 배열 목록과 동일하게 호출하여 이 목록에 모든 항목이 저장
    ArrayList<DataModel> dataModels = new ArrayList<>();

    int[] images = {
            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,
            R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h,
            R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l
            , R.drawable.m, R.drawable.n, R.drawable.o
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDataModel();

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dataModels); // 'dataModels'는 DataModel 객체의 리스트입니다.
        recyclerView.setAdapter(adapter);

    }

    private void setDataModel() {
        // 각 항목에 대한 모델 클래스 생성
        String[] items = getResources().getStringArray(R.array.items);
        for (int i = 0; i < items.length; i++) {
            dataModels.add(new DataModel(items[i], images[i]));
        }
    }
}