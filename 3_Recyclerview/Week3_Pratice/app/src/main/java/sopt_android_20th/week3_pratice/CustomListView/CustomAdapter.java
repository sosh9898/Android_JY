package sopt_android_20th.week3_pratice.CustomListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sopt_android_20th.week3_pratice.R;

/**
 * Created by pc on 2017-03-23.
 */

public class CustomAdapter extends BaseAdapter {

    private ArrayList<Itemdata> itemdata;
    private Context context;

    public CustomAdapter(ArrayList<Itemdata> itemdata, Context context) {        //생성자 정의
        this.itemdata = itemdata;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemdata != null ? itemdata.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);         //xml에 정의된 내용이 객체와 되는 것!!!
            view = inflater.inflate(R.layout.custom_listview_item, parent, false);                                      //어떠한 xml을 객체화 할지를 정해줍니다!!
        }

        ImageView item_img = (ImageView)view.findViewById(R.id.custom_item_img);
        TextView item_title = (TextView)view.findViewById(R.id.custom_item_title);
        TextView item_content = (TextView)view.findViewById(R.id.custom_item_content);

        item_img.setImageResource(itemdata.get(position).img);
        item_title.setText(itemdata.get(position).title);
        item_content.setText(itemdata.get(position).content);

        return view;
    }

//    @Override
//    public View getView(int position, View view, ViewGroup parent) {
//        ViewHolder viewHolder = new ViewHolder();
//        if (view == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(R.layout.custom_listview_item, parent, false);
//
//            viewHolder.VH_img = (ImageView) view.findViewById(R.id.custom_item_img);
//            viewHolder.VH_title = (TextView) view.findViewById(R.id.custom_item_title);
//            viewHolder.VH_content = (TextView) view.findViewById(R.id.custom_item_content);
//
//            view.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) view.getTag();
//        }
//        Itemdata itemdata_temp = itemdata.get(position);
//
//        viewHolder.VH_img.setImageResource(itemdata_temp.img);
//        viewHolder.VH_title.setText(itemdata_temp.title);
//        viewHolder.VH_content.setText(itemdata_temp.content);
//
//
//        return view;
//    }
//
//    public class ViewHolder {
//        ImageView VH_img;
//        TextView VH_title;
//        TextView VH_content;
//    }
}
