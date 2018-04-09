package sopt_android_20th.week6_pratice.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt_android_20th.week6_pratice.Network.NetworkService;
import sopt_android_20th.week6_pratice.R;
import sopt_android_20th.week6_pratice.application.ApplicationController;

public class DetailActivity extends AppCompatActivity {

    private TextView titleTextview;
    private TextView contentTextview;
    private TextView writerTextview;
    private ImageView imgView;
    private Button closeBtn;
    private String id;

    private NetworkService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ////////////////////////서비스 객체 초기화////////////////////////
        service = ApplicationController.getInstance().getNetworkService();


        ////////////////////////뷰 객체 초기화////////////////////////
        titleTextview = (TextView)findViewById(R.id.titleTextview);
        contentTextview = (TextView)findViewById(R.id.contentTextview);
        writerTextview = (TextView)findViewById(R.id.writerTextview);
        imgView = (ImageView)findViewById(R.id.imgView);
        closeBtn=(Button)findViewById(R.id.closeBtn);


        ////////////////////////아이디값 전달받기////////////////////////
        Intent intent = getIntent();
        id = intent.getExtras().getString("id");

        ////////////////////////네트워킹////////////////////////
        Networking();


        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void Networking(){
        /*
        통신부는 따로 정리해드리겠습니다 여기서는 간단하게
        메인부와 달리 getDetailResult(id)를 넘겨주어 해당 아이디를 서버가 확인하여
        정보를 넘겨줍니다
        */
        Call<DetailResult> requestDetail = service.getDetailResult(id);
        requestDetail.enqueue(new Callback<DetailResult>() {
            @Override
            public void onResponse(Call<DetailResult> call, Response<DetailResult> response) {
                if(response.isSuccessful()){
                    titleTextview.setText("제목 : "+response.body().result.title);
                    contentTextview.setText(response.body().result.content);
                    writerTextview.setText(("작성자 : "+response.body().result.username));

                    if(response.body().result.image != ""){
                        Glide.with(getApplicationContext())
                                .load(response.body().result.image)
                                .into(imgView);
                    }
                }
            }

            @Override
            public void onFailure(Call<DetailResult> call, Throwable t) {
                Log.i("err", t.getMessage());
            }
        });
    }
}
