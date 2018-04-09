package sopt_android_20th.week3_task.Level2;

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

public class Recycler2Adapter extends RecyclerView.Adapter<MyViewHolder>{
    ArrayList<Itemdata> itemdatas;
    ArrayList<Itemdata> filterdatas;

    public Recycler2Adapter(ArrayList<Itemdata> itemdatas) {
        this.itemdatas = itemdatas;
        this.filterdatas = new ArrayList<Itemdata>();
        this.filterdatas.addAll(itemdatas);
        //itemdatas 의 내용을 전부 가지고 있는 filterdatas 생성!! 복사본 역할을 하며 아래 검색함수에서 사용
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.item_text.setText(itemdatas.get(position).item_text);
    }

    @Override
    public int getItemCount() {
        return itemdatas != null ? itemdatas.size() : 0;
    }

    /*
    검색 함수 입니다
    넘어 온 text를 전부 소문자로 변경한 후
    itemdatas 출력부를 전부 지워줍니다
    filterdatas의 아이템들중 넘어 온 text를 포함하는 항복을 itemdatas에 추가하여 뿌려줍니다.
    검색 결과를 지우고 길이가 0이 될 경우
    복사본 역할을 수행하던 filterdatas에 데이터를 추가해서
    원본의 데이터를 출력해줍니다.
     */

    public void filter(String text) {
        text = text.toLowerCase();
        itemdatas.clear();
        if (text.length() == 0) {
            itemdatas.addAll(filterdatas);
        } else {
            for (Itemdata item : filterdatas) {
                if (item.getItem_text().toLowerCase().contains(text)) {
                    itemdatas.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}

