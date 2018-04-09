package sopt_android_20th.week1_task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editText;
    Button but1, but2, but3, add, sub, result;
    int currentnum1 =0, currentnum2=0, resultnum=0;                    // 각각 EditText, 숫자 버튼 선택, 연산 결과 값을 저장하게 될 변수!!!
    boolean flag1, flag2 = false;                                        // 버튼을 클릭하였는지를 확인하기 위한 변수로 true, false 값을 가지며 초기값을 false로 주었습니다.
    String opretor;                                                         // 연산자를 담을 String 변수!!


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.edit);
        but1 = (Button)findViewById(R.id.but1);
        but2 = (Button)findViewById(R.id.but2);
        but3 = (Button)findViewById(R.id.but3);
        add = (Button)findViewById(R.id.add);
        sub = (Button)findViewById(R.id.sub);
        result = (Button)findViewById(R.id.result);


        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        result.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.but1:                                             //1번 버튼 클릭 시 currentnum2 에 '1' 저장
                currentnum2 = 1;                                          //false로 초기화 되어있던 flag1을 true로 바꿔줌

            //    currentnum2 = Integer.parseInt(((Button)view).getText().toString());                      버튼의 텍스트 값을 가지고 올 수 도 있습니다.
                flag1 = true;
                break;
            case R.id.but2:                                              //2번 버튼 클릭 시 currentnum2 에 '2' 저장
                currentnum2 = 2;                                     //false로 초기화 되어있던 flag1을 true로 바꿔줌

            //    currentnum2 = Integer.parseInt(((Button)view).getText().toString());                      버튼의 텍스트 값을 가지고 올 수 도 있습니다.
                flag1 = true;
                break;
            case R.id.but3:                                         //3번 버튼 클릭 시 currentnum2 에 '3' 저장
                currentnum2 = 3;                                     //false로 초기화 되어있던 flag1을 true로 바꿔줌

             //   currentnum2 = Integer.parseInt(((Button)view).getText().toString());                      버튼의 텍스트 값을 가지고 올 수 도 있습니다.
                flag1 = true;
                break;

            case R.id.add:                                                          // +  버튼 클릭 시 currentnum1 에 EditText 값을 저장합니다 onCreate시에 바로 저장하게되면
                                                                                  // 생명주기 다들 기억하시죠?? 사용자 인터페이스를 초기화하는 과정에 EditText 값을 저장하게 되면
                opretor = "add";                                                // 아직 값을 입력하지 않아서 null 값이 들어가 오류가 발생하게 됩니다!!!
                flag2 = true;                                                   // false로 초기화 되어있던 flag2을 true로 바꿔줌
                break;                                                          // 연산자 변수에 'add' 저장


            case R.id.sub:                                                        // + 버튼 클릭 시와 동일하게 작동하며 다른 점은 - 연산을 한다는 것!!!
                opretor = "sub";                                                 // 연산자 변수에 'sub' 저장
                flag2 = true;
                break;


            case R.id.result:
                if(editText.length()!=0) {                                                                                                  // EditText에 값이 있는지 없는지를 판별!!! 길이가 0이라면 당연히 입력하지 않은거겠죠?

                    if (!Pattern.matches("^[0-9]+$", editText.getText().toString())) {                                                     // EditText에 입력한 값이 숫자가 맞는지를 확인하는 가장 쉬운 방법입니다~ 앞쪽에 패턴비교 뒤쪽에 비교대상인
                        Toast.makeText(getApplicationContext(), "입력 헝태는 숫자여야 합니다.", Toast.LENGTH_SHORT).show();             // EditText 값이 들어갑니다
                        editText.requestFocus();                                                                                            // focus 를 EditText로 이동시킵니다
                        editText.setText("");                                                                                               // 문자는 다시 지워줍시다 숫자를 입력해야지요
                        return;
                    }


                }else {                                                                                   // 입력 값이 문자열일 경우 else 구문으로 이동하여 Toast 메시지 출력과 동시에 EditText 로 focus를 이동시킵니다.
                    Toast.makeText(getApplicationContext(), "숫자를 입력해 주세요", Toast.LENGTH_SHORT).show();
                    editText.requestFocus();
                    return;
                }


                if(flag1 == false) {                                                                    // 숫자를 선택하였는지에 대한 확인!!
                    Toast.makeText(getApplicationContext(), "숫자를 선택해 주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(flag2 == false) {                                                                    // 연산자를 선택하였는지에 대한 확인!!
                    Toast.makeText(getApplicationContext(), "연산자를 선택해 주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(opretor == "add"){                                                                   // opretor 변수에 저장된 값에 따라 어떠한 연산을 할지 결정!!
                    currentnum1 = Integer.parseInt(editText.getText().toString());
                    resultnum = currentnum1 + currentnum2;
                }else if(opretor == "sub"){
                    currentnum1 = Integer.parseInt(editText.getText().toString());
                    resultnum = currentnum1 - currentnum2;
                }

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);              // 인텐트 구문입니다~ 다들 아시죠?
                intent.putExtra("result", resultnum);                                                  // 태그명 result에 resultnum 결과값을 담아 전달~
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onPause() {                                                   //back 키로 다시 뒤로 돌아왔을경우!! 값을 초기화!!
        super.onPause();
        editText.setText("");
        flag1 = false;
        flag2 = false;
    }
}
