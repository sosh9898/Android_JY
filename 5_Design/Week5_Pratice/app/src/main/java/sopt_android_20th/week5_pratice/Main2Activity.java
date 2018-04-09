package sopt_android_20th.week5_pratice;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends MainActivity {       //baseActivity 인 MainActivity 를 상속 받아 attachbasecontext를 오버라이드 하지 않아도 폰트 적용 가능!
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView)findViewById(R.id.test_text2);

    }
}
