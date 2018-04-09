package sopt_android_20th.week3_pratice.CustomListView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import sopt_android_20th.week3_pratice.R;

public class CustomListViewActivity extends AppCompatActivity {
    private ListView customlistview;
    private ArrayList<Itemdata> itemdata;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        customlistview = (ListView) findViewById(R.id.customlistview);
        itemdata = new ArrayList<Itemdata>();
        for (int i = 1; i < 7; i++) {
            Itemdata itemdata_temp = new Itemdata();
            if (i % 3 == 0)
                itemdata_temp.img = R.drawable.redtree;
            else if (i % 3 == 1)
                itemdata_temp.img = R.drawable.bluetree;
            else if (i % 3 == 2)
                itemdata_temp.img = R.drawable.greentree;

            itemdata_temp.title = i + "번 제목";
            itemdata_temp.content = i + "번 내용";
            itemdata.add(itemdata_temp);
        }


        customAdapter = new CustomAdapter(itemdata, this);                //사용자 정의 데이터, context
        customlistview.setAdapter(customAdapter);                         //정의된 어뎁터를 리스트와 연결

        customlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), (position+1)+"번 리스트 클릭!", Toast.LENGTH_SHORT).show();
            }
        });
    }




}
