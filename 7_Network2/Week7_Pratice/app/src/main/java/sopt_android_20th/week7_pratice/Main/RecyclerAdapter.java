package sopt_android_20th.week7_pratice.Main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sopt_android_20th.week7_pratice.R;
import sopt_android_20th.week7_pratice.ViewHolder.MyViewHolder;


/**
 * Created by pc on 2017-05-09.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<MainListData> mainListDatas;
    private View.OnClickListener onClickListener;

    public RecyclerAdapter(ArrayList<MainListData> mainListDatas, View.OnClickListener onClickListener) {
        this.mainListDatas = mainListDatas;
        this.onClickListener = onClickListener;
    }

    public void setAdapter(ArrayList<MainListData> mainListDatas) {
        this.mainListDatas = mainListDatas;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainlistcontent, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        view.setOnClickListener(onClickListener);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.VH_main_title.setText(mainListDatas.get(position).title);
        holder.VH_main_writer.setText(mainListDatas.get(position).writer);
        holder.VH_main_date.setText(mainListDatas.get(position).written_time);
        holder.VH_main_count.setText(mainListDatas.get(position).view_number + "");
    }

    @Override
    public int getItemCount() {
        return mainListDatas != null ? mainListDatas.size() : 0;
    }
}
