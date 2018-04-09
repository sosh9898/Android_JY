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

public class FirstFragment extends Fragment {
    TextView textView;

    public FirstFragment() {         //프레그먼트가 복원될 때 빈생성자 호출 반드시 필요
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_content, container, false);       // inflate 다들 기억하시죠?? xml을 객체화!!
        textView = (TextView) view.findViewById(R.id.text1);                          // 앞에 view 가 있는 이유!! 아시죠? 액티비티와 다르게 setcontentview가 없어 어떠한 뷰에서 findviewbyid 를 할지!!
        if(getArguments() !=null) {           //bundle 객체로 전달받은 값이 있다면 텍스트 뷰에 추가
            textView.setText(getArguments().getString("title") + " Fragment");
        }

        return view;
    }
}
