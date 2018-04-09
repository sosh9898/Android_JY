package sopt_android_20th.week2_pratice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImgSelectActivity extends AppCompatActivity {
    private Button previous_btn, next_btn;
    private ImageView selected_img;
    private Button register_btn;
    private int count =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_select);

        previous_btn = (Button)findViewById(R.id.previous_btn);
        next_btn = (Button)findViewById(R.id.next_btn);
        register_btn = (Button)findViewById(R.id.register_btn);

        selected_img = (ImageView)findViewById(R.id.selected_img);

        previous_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 0)             //count 가 계속 감소하는 것을 방지
                    count--;
                selectimg(count);
            }
        });
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count < 2)               //count 가 계속 증가하는 것을 방지
                    count++;
                selectimg(count);
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert_confirm = new AlertDialog.Builder(ImgSelectActivity.this);
                //기본 알림창 속성 설정

                alert_confirm.setMessage("회원가입을 하시겠습니까?")     //메세지 설정
                        .setCancelable(true)                          // 취소키 활성화 여부
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {  //확인 클릭시 이벤트

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent getdata = getIntent();
                                Intent intent = new Intent(getApplicationContext(), SignUpResultActivity.class);
                                intent.putExtra("id", getdata.getExtras().getString("id"));
                                intent.putExtra("pwd", getdata.getExtras().getString("pwd"));
                                intent.putExtra("name", getdata.getExtras().getString("name"));
                                intent.putExtra("major", getdata.getExtras().getString("major"));
                                intent.putExtra("part", getdata.getExtras().getString("part"));
                                intent.putExtra("jender", getdata.getExtras().getString("jender"));
                                intent.putExtra("selected img", count);
                                Log.i("count", String.valueOf(count));
                                startActivity(intent);
                                finish();
                            }
                        }).setNegativeButton("취소", new DialogInterface.OnClickListener() { //취소 버튼 클릭시 설정
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        });
                AlertDialog alert = alert_confirm.create();      // 기본 알림창 객체 생성
                alert.show();                                    // 알림창 띄우기
            }
        });
    }

    public void selectimg(int count){           //이미지 선택 메소드
        switch (count){
            case 0:
                selected_img.setImageResource(R.drawable.redtree);
                break;
            case 1:
                selected_img.setImageResource(R.drawable.bluetree);
                break;
            case 2:
                selected_img.setImageResource(R.drawable.greentree);
                break;
        }
    }
}
