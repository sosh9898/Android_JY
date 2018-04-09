package sopt_android_20th.week3_pratice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import sopt_android_20th.week3_pratice.BasicListView.BasicListViewActivity;
import sopt_android_20th.week3_pratice.CustomListView.CustomListViewActivity;
import sopt_android_20th.week3_pratice.RecyclerView.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button basic, custom, recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basic = (Button)findViewById(R.id.basic_list);
        custom = (Button)findViewById(R.id.custom_list);
        recycler = (Button)findViewById(R.id.custom_recycler);

        basic.setOnClickListener(this);
        custom.setOnClickListener(this);
        recycler.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.basic_list:
                Intent intent1 = new Intent(getApplicationContext(), BasicListViewActivity.class);
                startActivity(intent1);
                break;
            case R.id.custom_list:
                Intent intent2 = new Intent(getApplicationContext(), CustomListViewActivity.class);
                startActivity(intent2);
                break;
            case R.id.custom_recycler:
                Intent intent3 = new Intent(getApplicationContext(), RecyclerViewActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
