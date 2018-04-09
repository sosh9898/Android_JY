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

public class SecondPage extends android.support.v4.app.Fragment {
    TextView textView;

    public SecondPage() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_content, container, false);
        textView = (TextView)view.findViewById(R.id.text2);
        textView.setText("2번 Page");

        return view;
    }
}