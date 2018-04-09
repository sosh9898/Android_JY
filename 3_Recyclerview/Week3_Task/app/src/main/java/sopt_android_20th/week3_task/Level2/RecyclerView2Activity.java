package sopt_android_20th.week3_task.Level2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

import sopt_android_20th.week3_task.Itemdata;
import sopt_android_20th.week3_task.R;

public class RecyclerView2Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Recycler2Adapter recycler2Adapter;
    private LinearLayoutManager linearLayoutManager;
    private EditText searchedit;
    ArrayList<Itemdata> itemdatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview2);

        searchedit = (EditText)findViewById(R.id.search_edit);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_level_2);
        recyclerView.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        itemdatas = new ArrayList<Itemdata>();
        itemdatas.add(new Itemdata("ㄱ 검색"));
        itemdatas.add(new Itemdata("ㄴ 검색"));
        itemdatas.add(new Itemdata("ㄷ 검색"));
        itemdatas.add(new Itemdata("ㄹ 검색"));
        itemdatas.add(new Itemdata("ㅁ 검색"));
        itemdatas.add(new Itemdata("ㅂ 검색"));
        itemdatas.add(new Itemdata("ㅅ 검색"));

        recycler2Adapter = new Recycler2Adapter(itemdatas);
        recyclerView.setAdapter(recycler2Adapter);

        searchedit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //변경 전 텍스트 처리를 담당
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //변경되는 순간의 처리를 담당
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //입력이 끝난 후 처리를 담당
                String text = searchedit.getText().toString().toLowerCase();
                recycler2Adapter.filter(text);
            }
        });
    }

}
