package sopt_android_20th.week3_pratice.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import sopt_android_20th.week3_pratice.R;

/**
 * Created by pc on 2017-03-23.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView custom_item_img;               //서브뷰에 담아야할 객체들 선언 및 생성
    TextView custom_item_title;
    TextView custom_item_content;

    public MyViewHolder(View itemView) {
        super(itemView);

        custom_item_img = (ImageView)itemView.findViewById(R.id.custom_recycler_item_img);
        custom_item_title = (TextView)itemView.findViewById(R.id.custom_recycler_item_title);
        custom_item_content = (TextView)itemView.findViewById(R.id.custom_recycler_item_content);

    }
}
