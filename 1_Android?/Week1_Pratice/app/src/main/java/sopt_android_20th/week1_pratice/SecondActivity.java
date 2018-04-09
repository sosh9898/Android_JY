package sopt_android_20th.week1_pratice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    TextView text2;
    Button finish, return_result;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text2 = (TextView)findViewById(R.id.text2);
        finish = (Button)findViewById(R.id.finish);
        return_result = (Button)findViewById(R.id.return_result);

        Intent intent3 = getIntent();
        text = intent3.getExtras().getString("text");
        text2.setText(text);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        return_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent();
                intent4.putExtra("result text", "값 주고 받기 성공!!");
                setResult(RESULT_OK, intent4);
                finish();

            }
        });



    }
}
