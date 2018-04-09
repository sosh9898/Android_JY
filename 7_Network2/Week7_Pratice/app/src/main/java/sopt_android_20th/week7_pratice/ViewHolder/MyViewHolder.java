package sopt_android_20th.week7_pratice.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import sopt_android_20th.week7_pratice.R;


/**
 * Created by pc on 2017-05-09.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView VH_main_writer;
    public TextView VH_main_title;
    public TextView VH_main_date;
    public TextView VH_main_count;
    //메인 리스트

    public TextView VH_comment_writer;
    public TextView VH_comment_content;
    public TextView VH_comment_data;
    //댓글 리스트

    public MyViewHolder(View itemView) {
        super(itemView);

        VH_main_writer = (TextView)itemView.findViewById(R.id.MainList_writer);
        VH_main_title = (TextView)itemView.findViewById(R.id.MainList_title);
        VH_main_count = (TextView)itemView.findViewById(R.id.MainList_count);
        VH_main_date = (TextView)itemView.findViewById(R.id.MainList_date);
        //메인 리스트

        VH_comment_writer = (TextView)itemView.findViewById(R.id.Comment_writer);
        VH_comment_content = (TextView)itemView.findViewById(R.id.Comment_content);
        VH_comment_data = (TextView)itemView.findViewById(R.id.Comment_written_time);
        //댓글 리스트

    }


}

