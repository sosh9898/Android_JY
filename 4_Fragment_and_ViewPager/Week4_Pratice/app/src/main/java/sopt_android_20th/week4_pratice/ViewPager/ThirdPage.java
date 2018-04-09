package sopt_android_20th.week4_pratice.ViewPager;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sopt_android_20th.week4_pratice.R;

/**
 * Created by pc on 2017-04-27.
 */

public class ThirdPage extends android.support.v4.app.Fragment{
    TextView textView;

    public ThirdPage() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_content, container, false);
        textView = (TextView)view.findViewById(R.id.text3);
        textView.setText("3번 Page");

        return view;
    }
}
