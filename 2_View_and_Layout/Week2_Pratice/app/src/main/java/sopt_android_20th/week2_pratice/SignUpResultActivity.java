package sopt_android_20th.week2_pratice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUpResultActivity extends AppCompatActivity {
    private ImageView result_img;
    private TextView result_text;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_result);

        result_img = (ImageView)findViewById(R.id.result_img);
        result_text = (TextView)findViewById(R.id.result_text);


        Intent getdata = getIntent();
        count = getdata.getExtras().getInt("selected img");
        Log.i("count", String.valueOf(count));
        switch (count){
            case 0:
                result_img.setImageResource(R.drawable.redtree);
                break;
            case 1:
                result_img.setImageResource(R.drawable.bluetree);
                break;
            case 2:
                result_img.setImageResource(R.drawable.greentree);
                break;
        }

        result_text.setText("아이디 :"+getdata.getExtras().getString("id")+"\n"+"비밀번호 :"+getdata.getExtras().getString("pwd")+"\n"+"이름 :"+getdata.getExtras().getString("name")+"\n"+
                "전공 :"+getdata.getExtras().getString("major")+"\n"+"파트 :"+getdata.getExtras().getString("part")+"\n"+"성별 :"+getdata.getExtras().getString("jender"));

    }
}
