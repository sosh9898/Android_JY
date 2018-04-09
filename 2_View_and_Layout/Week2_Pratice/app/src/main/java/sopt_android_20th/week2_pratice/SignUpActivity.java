package sopt_android_20th.week2_pratice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText id_edit, pwd_edit, name_edit, major_edit;
    private RadioGroup part_Radio, jender_Radio;
    private Button submit_btn, reset_btn;
    private RadioButton temppart, tempjender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        id_edit = (EditText) findViewById(R.id.id_edit);
        pwd_edit = (EditText) findViewById(R.id.pwd_edit);
        name_edit = (EditText) findViewById(R.id.name_edit);
        major_edit = (EditText) findViewById(R.id.major_edit);

        part_Radio = (RadioGroup) findViewById(R.id.part_Radio);
        jender_Radio = (RadioGroup) findViewById(R.id.jender_Radio);

        submit_btn = (Button) findViewById(R.id.submit_btn);
        reset_btn = (Button) findViewById(R.id.reset_btn);

        submit_btn.setOnClickListener(this);
        reset_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit_btn:
                 temppart = (RadioButton) findViewById(part_Radio.getCheckedRadioButtonId());      //getCheckedRadioButtonId() 메소드를 통해 선택된 버튼의 아이디값을 얻어낸다
                 tempjender = (RadioButton) findViewById(jender_Radio.getCheckedRadioButtonId());

                //유효성 검사 ( 엽력정보 공백 여부 파악)

                if (id_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Id을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    id_edit.requestFocus();                 // requestFocus() id_edittext로 focus 이동
                    return;
                }
                if (pwd_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "pwd을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    pwd_edit.requestFocus();
                    return;
                }
                if (name_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    name_edit.requestFocus();
                    return;
                }
                if (major_edit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "전공을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    major_edit.requestFocus();
                    return;
                }
                if (temppart == null){
                    Toast.makeText(getApplicationContext(), "파트를 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (tempjender == null){
                    Toast.makeText(getApplicationContext(), "성별을 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent intent = new Intent(getApplicationContext(), ImgSelectActivity.class);
                intent.putExtra("id", String.valueOf(id_edit.getText()));
                intent.putExtra("pwd", String.valueOf(pwd_edit.getText()));
                intent.putExtra("name", String.valueOf(name_edit.getText()));
                intent.putExtra("major", String.valueOf(major_edit.getText()));
                intent.putExtra("part", String.valueOf(temppart.getText()));
                intent.putExtra("jender", String.valueOf(tempjender.getText()));
                startActivity(intent);
                finish();
                break;

            case R.id.reset_btn:
                id_edit.setText("");
                pwd_edit.setText("");
                name_edit.setText("");
                major_edit.setText("");
                part_Radio.clearCheck();
                jender_Radio.clearCheck();
                break;
        }
    }
}
