package sopt_android_20th.week4_pratice.Fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sopt_android_20th.week4_pratice.R;

/**
 * Created by pc on 2017-04-27.
 */

public class ThirdFragment extends Fragment{
    TextView textView;

    public ThirdFragment() {                    //프레그먼트가 복원될 때 빈생성자 호출 반드시 필요
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_content, container, false);
        textView = (TextView)view.findViewById(R.id.text3);
        textView.setText(getArguments().getString("title")+" Fragment");

        return view;
    }
}
