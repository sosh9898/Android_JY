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

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button but1, but2, but3, add, sub, result;
    int currentnum1 =0, currentnum2=0, resultnum=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.edit);
        but1 = (Button)findViewById(R.id.but1);
        but2 = (Button)findViewById(R.id.but2);
        but3 = (Button)findViewById(R.id.but3);
        add = (Button)findViewById(R.id.add);
        sub = (Button)findViewById(R.id.sub);
        result = (Button)findViewById(R.id.result);



        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentnum2 = 1;
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentnum2 = 2;
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentnum2 = 3;
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentnum1 = Integer.parseInt(editText.getText().toString());
                resultnum = currentnum1 + currentnum2;
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentnum1 = Integer.parseInt(editText.getText().toString());
                resultnum = currentnum1 - currentnum2;
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("result", resultnum);
                startActivity(intent);
            }
        });


    }


}
