package sopt_android_20th.week3_pratice.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sopt_android_20th.week3_pratice.R;

/**
 * Created by pc on 2017-03-23.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
    ArrayList<Itemdata_recyclerview> itemdatas;
    View.OnClickListener clickListener;

    public RecyclerAdapter(ArrayList<Itemdata_recyclerview> itemdatas, View.OnClickListener clickListener) {
        this.itemdatas = itemdatas;
        this.clickListener = clickListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {                // 뷰홀더 생성!!
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recyclerview_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);             //커스텀 뷰홀더 객체 생성
        view.setOnClickListener(clickListener);                     // 정의된 클릭이벤트를 달아준다
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {                       // 뷰홀더에 메모리상에 보유할 항목을 뷰홀더에 바인딩 해주는 함수!!
        holder.custom_item_img.setImageResource(itemdatas.get(position).img);             //이미지
        holder.custom_item_title.setText(itemdatas.get(position).title);                  //제목
        holder.custom_item_content.setText(itemdatas.get(position).content);             //내용
    }

    @Override
    public int getItemCount() {
        return itemdatas != null ? itemdatas.size() : 0;
    }
}
