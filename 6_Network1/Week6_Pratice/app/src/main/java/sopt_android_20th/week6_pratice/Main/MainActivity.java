package sopt_android_20th.week6_pratice.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt_android_20th.week6_pratice.Detail.DetailActivity;
import sopt_android_20th.week6_pratice.Network.NetworkService;
import sopt_android_20th.week6_pratice.R;
import sopt_android_20th.week6_pratice.Register.RegisterActivity;
import sopt_android_20th.week6_pratice.application.ApplicationController;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView recyclerView;
    private ArrayList<MainListData> mDatas;
    private LinearLayoutManager mLayoutManager;
    private RecyclerAdapter adapter;
    private ImageView addBtn;
    private SwipeRefreshLayout refreshLayout;
    private MainListData data;
    NetworkService service;


    //Back 키 두번 클릭 여부 확인
    private final long FINSH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Tag", "메인");
        ////////////////////////서비스 객체 초기화////////////////////////
        service = ApplicationController.getInstance().getNetworkService();

        ////////////////////////뷰 객체 초기화////////////////////////
        addBtn = (ImageView) findViewById(R.id.addBtn);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.RefreshLayout);
        recyclerView.setHasFixedSize(true);
        refreshLayout.setOnRefreshListener(this);

        ////////////////////////레이아웃 매니저 설정////////////////////////
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        ////////////////////////각 배열에 모델 개체를 가지는 ArrayList 초기화////////////////////////
        mDatas = new ArrayList<MainListData>();

        ////////////////////////리사이클러 뷰와 어뎁터 연동////////////////////////
        ////////////////////////파라미터로 위의 ArrayList와 클릭이벤트////////////////////////
        adapter = new RecyclerAdapter(mDatas, clickEvent);
        recyclerView.setAdapter(adapter);


        ////////////////////////리스트 목록 추가 버튼에 리스너 설정////////////////////////
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        /*
          OnCreate()- 생명주기 내의 통신
         액티비티가 지워지고 재생성 되지않는 이상 한 번만 실행됩니다.
         이러한 이유로 아래 쪽에 OnRestart()를 오버라이드 하여 메인액티비티가 재실행되는 경우
          리스트를 갱신합니다 아래에 있어요!!

          통신부는 따로 정리해서 올려드리겠습니다!!
         */
        Call<MainResult> requestMainData = service.getMainResult();
        requestMainData.enqueue(new Callback<MainResult>() {
            @Override
            public void onResponse(Call<MainResult> call, Response<MainResult> response) {
                if (response.isSuccessful()) {
                    Log.i("myTag", String.valueOf(response.body().results.size()));
                    mDatas = response.body().results;
                    adapter.setAdapter(mDatas);
                }
            }
            @Override
            public void onFailure(Call<MainResult> call, Throwable t) {
                Log.i("fail", t.getMessage());
            }
        });
    }

    /*
    onRestart()를 오버라이드하여 onPause -> onRestart 시
    리스트를 갱신하는 ListReload 메소드를 실행!!
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        ListReload();
    }

    /*
    리스트를 당기면 갱신되는 메소드입니다 사용하기 위해서
    implements SwipeRefreshLayout.OnRefreshListener 와
     xml에서 리스트를 감싸는 SwipeRefreshLayout 가 필요합니다!!
     */
    @Override
    public void onRefresh() {
        ListReload();
        refreshLayout.setRefreshing(false);
        Toast.makeText(getApplicationContext(), "페이지 리로드", Toast.LENGTH_SHORT).show();
    }

    /*
    리스트를 갱신하는 메소드입니다.
     */
    public void ListReload() {
        Call<MainResult> requestMainData = service.getMainResult();
        requestMainData.enqueue(new Callback<MainResult>() {
            @Override
            public void onResponse(Call<MainResult> call, Response<MainResult> response) {

                if (response.isSuccessful()) {

                    Log.i("myTag", String.valueOf(response.body().results.size()));
                    mDatas = response.body().results;
                    adapter.setAdapter(mDatas);

                }
            }

            @Override
            public void onFailure(Call<MainResult> call, Throwable t) {

            }
        });
    }

    ////////////////////////클릭 이벤트 정의////////////////////////
    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            int itemPosition = recyclerView.getChildPosition(v);
            int tempId = mDatas.get(itemPosition).id;
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra("id", String.valueOf(tempId));
            startActivity(intent);
        }
    };

    ////////////////////////취소 버튼을 오버라이드////////////////////////
    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        /**
         * Back키 두번 연속 클릭 시 앱 종료
         */
        if (0 <= intervalTime && FINSH_INTERVAL_TIME >= intervalTime) {
            super.onBackPressed();
        } else {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "뒤로 가기 키을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }

    }
}

