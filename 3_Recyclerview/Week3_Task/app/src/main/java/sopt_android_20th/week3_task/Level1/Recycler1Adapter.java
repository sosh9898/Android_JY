package sopt_android_20th.week3_task.Level1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sopt_android_20th.week3_task.Itemdata;
import sopt_android_20th.week3_task.MyViewHolder;
import sopt_android_20th.week3_task.R;

/**
 * Created by pc on 2017-03-24.
 */

public class Recycler1Adapter extends RecyclerView.Adapter<MyViewHolder>{
    ArrayList<Itemdata> itemdatas;
    View.OnClickListener clickListener;

    public Recycler1Adapter(ArrayList<Itemdata> itemdatas, View.OnClickListener clickListener) {
        this.itemdatas = itemdatas;
        this.clickListener = clickListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list_item,parent,false);  //어떠한 xml을 객체화하여 view 로 뿌려줄지 정합니다.
        MyViewHolder viewHolder = new MyViewHolder(view);
        view.setOnClickListener(clickListener);                                                                        //setAdapter 시에 넘어온 clickevent를 view에 달아줍니다.

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {                                                  // item 항목을 viewholder에 바인딩 해줍니다.
        holder.item_text.setText(itemdatas.get(position).item_text);
    }

    @Override
    public int getItemCount() {
        return itemdatas != null ? itemdatas.size() : 0;
    }
}
