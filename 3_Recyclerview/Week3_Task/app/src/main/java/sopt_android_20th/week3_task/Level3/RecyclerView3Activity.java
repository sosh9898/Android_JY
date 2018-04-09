package sopt_android_20th.week3_task.Level3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sopt_android_20th.week3_task.Itemdata3;
import sopt_android_20th.week3_task.R;


public class RecyclerView3Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Recycler3Adapter recycler3Adapter;
    private LinearLayoutManager linearLayoutManager;
    private Button addbtn, previous_btn, next_btn;
    private TextView select_img_txt;
    private EditText addedit, searchedit;
    ArrayList<Itemdata3> itemdata3s;
    int count = 1;
    int imgid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview3);

        select_img_txt = (TextView)findViewById(R.id.select_img_txt);

        addbtn = (Button)findViewById(R.id.level3_add_btn);
        addedit = (EditText)findViewById(R.id.level3_add_edit);

        searchedit = (EditText)findViewById(R.id.level3_search_edit);

        previous_btn = (Button)findViewById(R.id.previous_btn);
        next_btn = (Button)findViewById(R.id.next_btn);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_level_3);
        recyclerView.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        itemdata3s = new ArrayList<Itemdata3>();
        itemdata3s.add(new Itemdata3(R.drawable.redtree, "테스트1"));
        itemdata3s.add(new Itemdata3(R.drawable.bluetree, "테스트2"));
        itemdata3s.add(new Itemdata3(R.drawable.greentree, "테스트3"));

        recycler3Adapter = new Recycler3Adapter(itemdata3s, clickEvent);
        recyclerView.setAdapter(recycler3Adapter);

        previous_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 0)             //count 가 계속 감소하는 것을 방지
                    count--;
                    select_img_txt.setText(count+"");
                selectimg(count);
            }
        });
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count < 2)               //count 가 계속 증가하는 것을 방지
                    count++;
                select_img_txt.setText(count+"");
                selectimg(count);
            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(addedit.getText().length() == 0){
                    Toast.makeText(getApplicationContext(), "추가할 내용을 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    itemdata3s.add(new Itemdata3(imgid, addedit.getText().toString()));
                    addedit.setText("");
                    Update();
                }
            }
        });

            searchedit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = searchedit.getText().toString().toLowerCase();
                recycler3Adapter.filter(text);
            }
        });
    }
    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            final int itemPosition = recyclerView.getChildPosition(v);
            AlertDialog.Builder delete_confirm = new AlertDialog.Builder(RecyclerView3Activity.this);
            delete_confirm.setMessage("해당 항목을 삭제 하시겠습니까?").setCancelable(false).setPositiveButton("확인",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            itemdata3s.remove(itemPosition);
                            Update();
                        }
                    }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }
            });
            AlertDialog alertDialog = delete_confirm.create();
            alertDialog.show();
        }
    };

    public void selectimg(int count){           //이미지 선택 메소드
        switch (count){
            case 0:
                imgid = R.drawable.redtree;
                break;
            case 1:
                imgid = R.drawable.bluetree;
                break;
            case 2:
                imgid = R.drawable.greentree;
                break;
        }
    }

    private void Update(){                                                                   //다른 부분은 level1,level2 에서 설명드린거와 동일합니다
        recycler3Adapter = new Recycler3Adapter(itemdata3s, clickEvent);                //추가, 검색 이벤트 처리 후에 어뎁터를 새로 생성하는 이유는
        recyclerView.setAdapter(recycler3Adapter);                                        //onCreate 에서 선언된 어뎁터 객체에 인자로 전달된 itemdata가 항목이 추가 후 갱신된
        recycler3Adapter.notifyDataSetChanged();                                            //itemdata가 아니라 초기의 itemdata 이기 때문입니다.
    }
}
