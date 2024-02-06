package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/**
 * RecyclerViewAdapter는 RecyclerView에 데이터를 제공하는 어댑터입니다.
 * 이 클래스는 DataModel 객체의 ArrayList를 관리하며, 각 항목을 RecyclerView에 어떻게 표시할지 결정합니다.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    // Context 객체와 DataModel 객체의 리스트를 저장하는 멤버 변수
    Context context;
    ArrayList<DataModel> dataModels;

    /**
     * RecyclerViewAdapter의 생성자입니다.
     * @param context 현재 컨텍스트(액티비티)입니다.
     * @param dataModels 표시할 데이터 모델 객체의 리스트입니다.
     */
    public RecyclerViewAdapter(Context context, ArrayList<DataModel> dataModels){
        this.context = context;
        this.dataModels = dataModels;
    }

    /**
     * 새로운 뷰 홀더를 생성하는 메서드입니다. 이 메서드는 RecyclerView에 항목 뷰를 생성할 때 호출됩니다.
     * @param parent 항목 뷰의 부모 뷰그룹입니다.
     * @param viewType 뷰 타입입니다.
     * @return 생성된 뷰 홀더를 반환합니다.
     */
    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 레이아웃 인플레이터를 사용하여 rv_row.xml 레이아웃을 뷰로 변환합니다.
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_row, parent, false);

        // 생성된 뷰를 사용하여 MyViewHolder 객체를 생성하고 반환합니다.
        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    /**
     * 뷰 홀더의 내용을 데이터 모델 객체의 데이터로 채우는 메서드입니다.
     * @param holder 현재 항목의 뷰 홀더입니다.
     * @param position 현재 항목의 위치(인덱스)입니다.
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        // 현재 위치의 DataModel 객체를 가져와서, 텍스트와 이미지를 뷰 홀더의 뷰에 설정합니다.
        holder.tvRow.setText(dataModels.get(position).getText1());
        holder.ivRow.setImageResource(dataModels.get(position).getImage());
    }

    /**
     * RecyclerView의 전체 항목 수를 반환하는 메서드입니다.
     * @return 데이터 모델 리스트의 크기(항목 수)를 반환합니다.
     */
    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    /**
     * MyViewHolder는 RecyclerView의 각 항목을 위한 뷰 홀더입니다.
     * 이 내부 클래스는 항목 뷰의 구성 요소를 캐싱하여, 각 항목의 뷰를 빠르게 업데이트할 수 있도록 합니다.
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // 항목 뷰 내의 ImageView와 TextView에 대한 참조입니다.
        ImageView ivRow;
        TextView tvRow;

        /**
         * MyViewHolder의 생성자입니다.
         * @param itemView 현재 항목의 뷰입니다.
         */
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // itemView에서 ImageView와 TextView의 참조를 가져옵니다.
            ivRow = itemView.findViewById(R.id.ivRow);
            tvRow = itemView.findViewById(R.id.tvRow);
        }
    }
}
