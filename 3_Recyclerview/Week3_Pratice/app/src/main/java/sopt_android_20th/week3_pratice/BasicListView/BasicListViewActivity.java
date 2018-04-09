package sopt_android_20th.week3_pratice.BasicListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import sopt_android_20th.week3_pratice.R;

public class BasicListViewActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> itemdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list_view);

        listView = (ListView)findViewById(R.id.listview);
        itemdata = new ArrayList<String>();                 //기본 리스트로 단순한 텍스트만을 출력하기 위한 arraylist

        itemdata.add("list_data_1");
        itemdata.add("list_data_2");
        itemdata.add("list_data_3");
        itemdata.add("list_data_4");
        itemdata.add("list_data_5");
        itemdata.add("list_data_6");
        itemdata.add("list_data_7");
        itemdata.add("list_data_8");
        itemdata.add("list_data_9");
        itemdata.add("list_data_10");
        itemdata.add("list_data_11");
        itemdata.add("list_data_12");
        itemdata.add("list_data_13");
        itemdata.add("list_data_14");

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, itemdata);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), (position+1)+"번 리스트 클릭!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
