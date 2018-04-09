package sopt_android_20th.week2_example;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    RadioGroup jenderGroup;
    Button dialog_btn;
    RadioButton selectRadio;
    ArrayAdapter<CharSequence> yearAdapter;
    Spinner year_spinner;
    String year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jenderGroup = (RadioGroup) findViewById(R.id.jender_Radio);
        dialog_btn = (Button) findViewById(R.id.dialog_btn);
        year_spinner = (Spinner) findViewById(R.id.year_spinner);


        yearAdapter = ArrayAdapter.createFromResource(this,                                                     // 기본 문자배열 어뎁터인데 3차에 어뎁터에 대해 다루겠습니다 지금은 데이터와 스피너를 연결해준다고 생각하세요!!
                R.array.arr_year, android.R.layout.simple_spinner_item);                                      // 각각 ( context , 자신이 만든 배열!! res/values/array.xml 확인해주세요~(올려드린 프로젝트에서요!) , 기본으로 제공되는 스피너 형태입니다 )
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);                 // 이것도 기본으로 제공됩니다 스피너 클릭 시 DropDown~


        year_spinner.setAdapter(yearAdapter);


        year_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {                          // spinner 아이템 선택 리스너를 달아서
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {                // 선택된 아이템을 year 변수에 저장합니다!!
                year = year_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dialog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                                             // 버튼 클릭 이벤트!!
                selectRadio = (RadioButton) findViewById(jenderGroup.getCheckedRadioButtonId());          //  체크된 라디오 버튼의 아이디값을 받아와 객체 초기화~~ 계산기 과제와 유사하게 oncreate에 선언하면 오류가 납니다~~ oncreate시에 체크가 안되어있기 때문!!

                AlertDialog.Builder alert_confirm = new AlertDialog.Builder(MainActivity.this);             // 다이얼로그는 스택에 쌓이지 않습니다. 최상위 뷰는 아직 mainactivity 이기 때문에 mainactivity 의 context를 얻어옵니다!!
                //기본 알림창 속성 설정

                alert_confirm.setMessage("정보를 전송하시겠습니까?")     //메세지 설정
                        .setCancelable(true)                          // 취소키 활성화 여부
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {  //확인 클릭시 이벤트

                            @Override
                            public void onClick(DialogInterface dialog, int which) {                               //확인 버튼 클릭 시 intent~~
                                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                                intent.putExtra("radio_result", selectRadio.getText().toString());
                                intent.putExtra("spinner_result", year);
                                startActivity(intent);
                                finish();
                            }
                        }).setNegativeButton("취소", new DialogInterface.OnClickListener() { //취소 버튼 클릭시 설정
                    @Override
                    public void onClick(DialogInterface dialog, int which) {                                         // 취소 버튼 클릭 시 다이얼로그 dismiss~~
                        return;
                    }
                });
                AlertDialog alert = alert_confirm.create();      // 기본 알림창 객체 생성
                alert.show();                                    // 알림창 띄우기
            }
        });
    }
}
