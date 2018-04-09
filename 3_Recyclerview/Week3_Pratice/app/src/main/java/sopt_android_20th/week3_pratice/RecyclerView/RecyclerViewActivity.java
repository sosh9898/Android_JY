package sopt_android_20th.week3_pratice.RecyclerView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import sopt_android_20th.week3_pratice.R;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Itemdata_recyclerview> itemdata;
    private RecyclerAdapter recyclerAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);                     //사이즈를 고정

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);             //리니어레이아웃의 형태이면 방향은 수직
        recyclerView.setLayoutManager(layoutManager);                           //리사이클러뷰에 레이아웃매니저를 달아준다

        itemdata = new ArrayList<Itemdata_recyclerview>();                         //사용자 정의 데이터를 갖는 arraylist
        itemdata.add(new Itemdata_recyclerview(R.drawable.redtree, "1번", "내용"));
        itemdata.add(new Itemdata_recyclerview(R.drawable.bluetree, "2번", "내용"));
        itemdata.add(new Itemdata_recyclerview(R.drawable.greentree, "3번", "내용"));
        itemdata.add(new Itemdata_recyclerview(R.drawable.redtree, "4번", "내용"));
        itemdata.add(new Itemdata_recyclerview(R.drawable.bluetree, "5번", "내용"));
        itemdata.add(new Itemdata_recyclerview(R.drawable.greentree, "6번", "내용"));
        recyclerAdapter = new RecyclerAdapter(itemdata,clickEvent);
        recyclerView.setAdapter(recyclerAdapter);

    }
    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            final int itemPosition = recyclerView.getChildPosition(v);           //position 을 지원하지 않는다 따라서 직접 얻어와야함
            Toast.makeText(getApplicationContext(),itemPosition+"번 리스트 클릭!!",Toast.LENGTH_SHORT).show();

        }
    };
}
