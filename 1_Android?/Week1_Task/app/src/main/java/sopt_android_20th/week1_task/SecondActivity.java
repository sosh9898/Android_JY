package sopt_android_20th.week1_task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
    TextView textView;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView)findViewById(R.id.text1);

        Intent intent = getIntent();
        result = intent.getExtras().getInt("result");                // getExtras().getInt(태그명) 으로 값을 받아서
        textView.setText(String.valueOf(result));                    // 텍스트에 뿌려줍니다!!

    }
}
