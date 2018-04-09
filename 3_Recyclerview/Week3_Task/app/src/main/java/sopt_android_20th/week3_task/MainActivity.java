package sopt_android_20th.week3_task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import sopt_android_20th.week3_task.Level1.RecyclerView1Activity;
import sopt_android_20th.week3_task.Level2.RecyclerView2Activity;
import sopt_android_20th.week3_task.Level3.RecyclerView3Activity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button level1, level2, level3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        level1 = (Button)findViewById(R.id.level1_btn);
        level2 = (Button)findViewById(R.id.level2_btn);
        level3 = (Button)findViewById(R.id.level3_btn);

        level1.setOnClickListener(this);
        level2.setOnClickListener(this);
        level3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.level1_btn:
                Intent level1 = new Intent(getApplicationContext(), RecyclerView1Activity.class);
                startActivity(level1);
                break;
            case R.id.level2_btn:
                Intent level2 = new Intent(getApplicationContext(), RecyclerView2Activity.class);
                startActivity(level2);
                break;
            case R.id.level3_btn:
                Intent level3 = new Intent(getApplicationContext(), RecyclerView3Activity.class);
                startActivity(level3);
                break;
        }
    }
}
