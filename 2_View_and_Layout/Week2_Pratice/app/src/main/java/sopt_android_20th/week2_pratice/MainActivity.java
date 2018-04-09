package sopt_android_20th.week2_pratice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button signup_btn, login_btn;
    private EditText login_id_edit, login_pwd_edit;
    private String id = "neosopt";
    private String pwd = "202017";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_id_edit = (EditText)findViewById(R.id.login_id_edit);
        login_pwd_edit = (EditText)findViewById(R.id.login_pwd_edit);

        login_btn = (Button)findViewById(R.id.login_btn);
        signup_btn = (Button)findViewById(R.id.signup_btn);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(login_id_edit.length() == 0){
                    Toast.makeText(getApplicationContext(), "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(login_pwd_edit.length() == 0){
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                String inputid = login_id_edit.getText().toString();
                String inputpwd = login_pwd_edit.getText().toString();

                if(inputid.equals(id) && inputpwd.equals(pwd)){
                    Toast.makeText(getApplicationContext(), "로그인 성공!!", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getApplicationContext(), "로그인 실패!!", Toast.LENGTH_SHORT).show();
            }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                finish(); // 현재 Activity 종료
            }
        });
    }
}
