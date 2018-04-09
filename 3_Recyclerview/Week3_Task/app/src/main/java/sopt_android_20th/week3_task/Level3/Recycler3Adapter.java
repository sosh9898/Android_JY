package sopt_android_20th.week3_task.Level3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sopt_android_20th.week3_task.Itemdata3;
import sopt_android_20th.week3_task.MyViewHolder;
import sopt_android_20th.week3_task.R;

/**
 * Created by pc on 2017-03-30.
 */

public class Recycler3Adapter extends RecyclerView.Adapter<MyViewHolder> {
    ArrayList<Itemdata3> itemdata3s;
    ArrayList<Itemdata3> filterdata3s;
    View.OnClickListener clickListener;

    public Recycler3Adapter(ArrayList<Itemdata3> itemdata3s, View.OnClickListener clickListener) {
        this.itemdata3s = itemdata3s;
        this.clickListener = clickListener;
        this.filterdata3s = new ArrayList<Itemdata3>();
        this.filterdata3s.addAll(itemdata3s);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview3_list_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        view.setOnClickListener(clickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.item_img3.setImageResource(itemdata3s.get(position).item_img3);
        holder.item_text3.setText(itemdata3s.get(position).item_text3);
    }

    @Override
    public int getItemCount() {
        return itemdata3s != null ? itemdata3s.size() : 0;
    }

    public void filter(String text) {
        text = text.toLowerCase();
        itemdata3s.clear();
        if (text.length() == 0) {
            itemdata3s.addAll(filterdata3s);
        } else {
            for (Itemdata3 item : filterdata3s) {
                if (item.getItem_text3().toLowerCase().contains(text)) {
                    itemdata3s.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
