package sopt_android_20th.week2_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView radiotxt;
    TextView spinnertxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        radiotxt = (TextView)findViewById(R.id.radio_result_txt);
        spinnertxt = (TextView)findViewById(R.id.spinner_result_txt);

        Intent getdata = getIntent();                                                     //전달된 값 받아서 뿌려줍니다~
        radiotxt.setText(getdata.getStringExtra("radio_result"));
        spinnertxt.setText(getdata.getStringExtra("spinner_result"));
    }
}
