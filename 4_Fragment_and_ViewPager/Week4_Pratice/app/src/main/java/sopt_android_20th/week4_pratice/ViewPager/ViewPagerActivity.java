package sopt_android_20th.week4_pratice.ViewPager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import sopt_android_20th.week4_pratice.R;

public class ViewPagerActivity extends AppCompatActivity implements View.OnClickListener{
    ViewPager viewPager;
    Button first_btn, second_btn, third_btn;
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

       // tabLayout = (TabLayout) findViewById(R.id.tablayout);       //tab 사용시
//        tabLayout.addTab(tabLayout.newTab().setText("1번"));
//        tabLayout.addTab(tabLayout.newTab().setText("2번"));
//        tabLayout.addTab(tabLayout.newTab().setText("3번"));
        viewPager = (ViewPager)findViewById(R.id.viewpager_content);
        first_btn = (Button) findViewById(R.id.first_pager_btn);
        second_btn = (Button) findViewById(R.id.second_pager_btn);
        third_btn = (Button) findViewById(R.id.third_pager_btn);

        first_btn.setOnClickListener(this);
        second_btn.setOnClickListener(this);
        third_btn.setOnClickListener(this);

        pagerAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);          //최초실행시 보여질 페이지의 포지션 값 설정
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));     //탭과 페이지를 서로 연동!!
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {                     //탭 클릭 시에 이벤트 부여
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {                                           //해당 탭 선택
//                viewPager.setCurrentItem(tab.getPosition());                                         //탭 선택 시에 뷰페이저에 탭카운트에 해당하는 포지션의 프레그먼트 호출
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {                                         //비선택
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {                                         //재선택
//
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.first_pager_btn:
                viewPager.setCurrentItem(0);
                break;
            case R.id.second_pager_btn:
                viewPager.setCurrentItem(1);
                break;
            case R.id.third_pager_btn:
                viewPager.setCurrentItem(2);
                break;
        }

    }
}
