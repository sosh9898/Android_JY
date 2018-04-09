package sopt_android_20th.week4_pratice.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import sopt_android_20th.week4_pratice.R;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener{
    FrameLayout fragment_content;
    Button first_btn, second_btn, third_btn, tag_btn;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        fragment_content = (FrameLayout) findViewById(R.id.fragment_content);
        first_btn = (Button) findViewById(R.id.first_fragment_btn);
        second_btn = (Button) findViewById(R.id.second_fragment_btn);
        third_btn = (Button) findViewById(R.id.third_fragment_btn);
        tag_btn = (Button) findViewById(R.id.tag_btn);
        editText = (EditText) findViewById(R.id.edit);

        first_btn.setOnClickListener(this);
        second_btn.setOnClickListener(this);
        third_btn.setOnClickListener(this);
        tag_btn.setOnClickListener(this);

        if (savedInstanceState == null) {                   //savedInstanceState 동일한 액티비티가 재실행 될 때 저장된 값이 있는지 판단!
                                                            //물론 이 예제에서 다루지 않을것이지만 다룬다 하여도 최초실행시에는 저장된 것이 없겠죠??
            Bundle bundle = new Bundle();
            bundle.putString("title", first_btn.getText().toString());
            AddFragment(new FirstFragment(), bundle, "first");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.first_fragment_btn:
                Bundle bundle = new Bundle();
                bundle.putString("title", first_btn.getText().toString());
                AddFragment(new FirstFragment(), bundle, "first", getSupportFragmentManager().findFragmentById(R.id.fragment_content));
                break;
            case R.id.second_fragment_btn:
                Bundle bundle2 = new Bundle();
                bundle2.putString("title", second_btn.getText().toString());
                AddFragment(new SecondFragment(), bundle2, "second", getSupportFragmentManager().findFragmentById(R.id.fragment_content));
                break;
            case R.id.third_fragment_btn:
                Bundle bundle3 = new Bundle();
                bundle3.putString("title", third_btn.getText().toString());
                AddFragment(new ThirdFragment(), bundle3, "third",  getSupportFragmentManager().findFragmentById(R.id.fragment_content));
                break;
            case R.id.tag_btn:
                TagFragment(editText.getText().toString());

        }
    }


    public void AddFragment(Fragment fragment,Bundle bundle, String tag, Fragment fragment2){
        FragmentManager fm = getSupportFragmentManager();               // 프레그먼트 매니져 객체를 생성
        FragmentTransaction transaction = fm.beginTransaction();        // 트랜젝션 객체를 생성 프레그먼트 매니져 클래스를 통해 해당 트랙젝션을 수행하겠다는 의미
        transaction.remove(fragment2);                                  // 기존 프레그먼트 제거
        fragment.setArguments(bundle);                                  // bundle 객체를 넘겨준다
        transaction.add(R.id.fragment_content, fragment, tag);         // 새로운 프레그먼트 추가!!
        //transaction.addToBackStack(null);                             // 백스텍에 저장!!
        transaction.commit();
    }

    public void AddFragment(Fragment fragment,Bundle bundle, String tag){            //오버라이딩하여 최초에 추가될 프레그먼트 생성함수
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        fragment.setArguments(bundle);
        transaction.add(R.id.fragment_content, fragment, tag);
        //transaction.addToBackStack(null);
        transaction.commit();
    }
    public void TagFragment(String tag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        transaction.attach(fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }

    public void ReplaceFragment(Fragment fragment, Bundle bundle, String tag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        fragment.setArguments(bundle);
        transaction.replace(R.id.fragment_content, fragment, tag);
        //transaction.addToBackStack(null);
        transaction.commit();
    }
}
