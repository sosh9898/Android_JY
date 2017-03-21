package sopt_android_20th.week1_pratice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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
        result = intent.getExtras().getInt("result");
        textView.setText(String.valueOf(result));

    }
}
