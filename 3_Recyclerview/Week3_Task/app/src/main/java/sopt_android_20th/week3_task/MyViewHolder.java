package sopt_android_20th.week3_task;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pc on 2017-03-24.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView item_text;
    public TextView item_text3;
    public ImageView item_img3;

    public MyViewHolder(View itemView) {
        super(itemView);
            item_text = (TextView)itemView.findViewById(R.id.item_text);
            //level1 , level2

            item_text3 = (TextView)itemView.findViewById(R.id.item_text3);
            item_img3 = (ImageView)itemView.findViewById(R.id.item_img3);
            //level3
    }
}
