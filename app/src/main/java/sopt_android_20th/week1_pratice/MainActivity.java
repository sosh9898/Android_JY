package sopt_android_20th.week1_pratice;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    TextView text1;
    Button intent1, intent2;
    static final int REQUEST_CODE = 1001;
    String text_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.text1);
        intent1 = (Button)findViewById(R.id.intent1);
        intent2 = (Button)findViewById(R.id.intent2);
        intent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), SecondActivity.class);
                intent1.putExtra("text", text1.getText().toString());
                startActivity(intent1);
            }
        });
        intent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), SecondActivity.class);
                intent2.putExtra("text", text1.getText().toString());
                startActivityForResult(intent2, REQUEST_CODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE){
                text_result = data.getStringExtra("result text");
                text1.setText(text_result);
                Toast.makeText(getApplicationContext(), "resultmsg :"+text_result, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
