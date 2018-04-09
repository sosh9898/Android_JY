package sopt_android_20th.week4_pratice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import sopt_android_20th.week4_pratice.ViewPager.ViewPagerActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button fragment_btn, viewpager_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment_btn = (Button)findViewById(R.id.fragment_btn);
        viewpager_btn = (Button)findViewById(R.id.viewpager_btn);

        fragment_btn.setOnClickListener(this);
        viewpager_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.fragment_btn:
                Intent fragment = new Intent(getApplicationContext(), sopt_android_20th.week4_pratice.Fragment.FragmentActivity.class);
                startActivity(fragment);
                break;
            case R.id.viewpager_btn:
                Intent viewpager = new Intent(getApplicationContext(), ViewPagerActivity.class);
                startActivity(viewpager);
                break;

        }
    }
}
