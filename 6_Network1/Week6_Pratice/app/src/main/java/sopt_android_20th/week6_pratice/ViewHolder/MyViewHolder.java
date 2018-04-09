package sopt_android_20th.week6_pratice.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import sopt_android_20th.week6_pratice.R;

/**
 * Created by pc on 2017-05-09.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView VH_main_writer;
    public TextView VH_main_title;
    public TextView VH_main_date;
    public TextView VH_main_count;

    public MyViewHolder(View itemView) {
        super(itemView);

        VH_main_writer = (TextView)itemView.findViewById(R.id.MainList_writer);
        VH_main_title = (TextView)itemView.findViewById(R.id.MainList_title);
        VH_main_count = (TextView)itemView.findViewById(R.id.MainList_count);
        VH_main_date = (TextView)itemView.findViewById(R.id.MainList_date);

    }


}

