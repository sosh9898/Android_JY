package sopt_android_20th.week4_pratice.ViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by pc on 2017-04-28.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    int tabcount;

    public PageAdapter(FragmentManager fm) {          //tab 사용 시 int tabcount 추가
        super(fm);
        //this.tabcount = tabcount;          //tab 사용시 tabcount도 객체 생성시 받아와야 합니다

    }

    @Override
    public Fragment getItem(int position) {      //각 페이지의 포지션마다 어떠한 프레그먼트를 보여줄 것 인지
        switch (position){
            case 0:
                return new FirstPage();
            case 1:
                return new SecondPage();
            case 2:
                return new ThirdPage();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }           //보여질 페이지의 수 tab사용시 tabcount 리턴
}
