package com.example.recyclerview;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// recyclerviewadpater 클래스의 이름을 전달
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

        Context context;
        ArrayList<DataModel> dataModels;
    public RecyclerViewAdapter(Context context, ArrayList<DataModel> dataModels){
        this.context = context;
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_row, parent, false );


        return new RecyclerViewAdapter.MyViewHolder(view);
    } // 레이아웃 확장 및 각 행에 모양을 제공

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.tvRow.setText(dataModels.get(position).getText1());
        holder.ivRow.setImageResource(dataModels.get(position).getImage());
    }// 바인딩 프로세스가 있음 화면으로 돌아올때 행에 값 을 부여
    // 데이터를 뷰 홀더의 뷰에 바인딩

    @Override
    public int getItemCount() {
        return dataModels.size();
    } // 총 항목수

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView ivRow;
        TextView tvRow;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivRow = itemView.findViewById(R.id.ivRow);
            tvRow = itemView.findViewById(R.id.tvRow);
        }
    } // == onCreate와 유사
}
