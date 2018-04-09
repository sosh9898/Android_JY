package sopt_android_20th.week3_task.Level1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import sopt_android_20th.week3_task.Itemdata;
import sopt_android_20th.week3_task.R;

public class RecyclerView1Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Recycler1Adapter recycler1Adapter;
    private LinearLayoutManager linearLayoutManager;
    private Button addbtn;
    private EditText addedit;
    ArrayList<Itemdata> itemdatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview1);

        addbtn = (Button)findViewById(R.id.add_btn);
        addedit = (EditText)findViewById(R.id.add_edit);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_level_1);
        recyclerView.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        itemdatas = new ArrayList<Itemdata>();

        recycler1Adapter = new Recycler1Adapter(itemdatas, clickEvent);
        recyclerView.setAdapter(recycler1Adapter);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(addedit.getText().length() == 0){                                                                    //내용을 입력하지 않을시에 Toast 메시지 출력!!
                    Toast.makeText(getApplicationContext(), "추가할 내용을 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    itemdatas.add(new Itemdata(addedit.getText().toString()));                                    //edittext에 입력된 내용을 ArrayList에 추가해줍니다
                    recycler1Adapter.notifyDataSetChanged();                                                      //notifyDataSetChanged() 함수는 리스트 내용에 변경이 있을 시 갱신해주는 함수입니다.
                    addedit.setText("");
                }
            }
        });
    }
    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            final int itemPosition = recyclerView.getChildPosition(v);                               //리사이클러뷰에서는 포지션값을 따로 지정해주어야 한다는거 다들 기억하시죠??
            AlertDialog.Builder delete_confirm = new AlertDialog.Builder(RecyclerView1Activity.this);  //다이얼로그 생성부분입니다~
            delete_confirm.setMessage("해당 항목을 삭제 하시겠습니까?").setCancelable(false).setPositiveButton("확인",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            itemdatas.remove(itemPosition);
                            recycler1Adapter.notifyDataSetChanged();
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


}
