package sopt_android_20th.week7_pratice.Detail;

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

public class Comment_RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<DetailResult.CommentData> commentDatas;

    public Comment_RecyclerAdapter(ArrayList<DetailResult.CommentData> commentDatas) {
        this.commentDatas = commentDatas;
    }

    public void setAdapter(ArrayList<DetailResult.CommentData> commentDatas) {
        this.commentDatas = commentDatas;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.commentcontent, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.VH_comment_writer.setText(commentDatas.get(position).writer);
        holder.VH_comment_content.setText(commentDatas.get(position).content);
        holder.VH_comment_data.setText(commentDatas.get(position).written_time);
    }

    @Override
    public int getItemCount() {
        return commentDatas != null ? commentDatas.size() : 0;
    }
}
