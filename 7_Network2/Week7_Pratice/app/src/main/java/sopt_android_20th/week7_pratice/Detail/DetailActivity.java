package sopt_android_20th.week7_pratice.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt_android_20th.week7_pratice.Network.NetworkService;
import sopt_android_20th.week7_pratice.R;
import sopt_android_20th.week7_pratice.application.ApplicationController;


public class DetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText commentwriter;
    private EditText commentcontent;
    private Button commentBtn;
    private TextView titleTextview;
    private TextView contentTextview;
    private TextView writerTextview;
    private ImageView imgView;
    private Button closeBtn;
    private String id;
    private ArrayList<DetailResult.CommentData> commentDatas;
    private LinearLayoutManager mLayoutManager;
    private Comment_RecyclerAdapter comment_recyclerAdapter;

    private NetworkService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ////////////////////////서비스 객체 초기화////////////////////////
        service = ApplicationController.getInstance().getNetworkService();


        ////////////////////////뷰 객체 초기화////////////////////////
        titleTextview = (TextView) findViewById(R.id.titleTextview);
        contentTextview = (TextView) findViewById(R.id.contentTextview);
        writerTextview = (TextView) findViewById(R.id.writerTextview);
        commentwriter = (EditText) findViewById(R.id.comment_writer_edit);
        commentcontent = (EditText) findViewById(R.id.comment_content_edit);
        imgView = (ImageView) findViewById(R.id.imgView);
        closeBtn = (Button) findViewById(R.id.closeBtn);
        commentBtn = (Button) findViewById(R.id.commentBtn);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_comment);

        ////////////////////////레이아웃 매니저 설정////////////////////////
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        ////////////////////////각 배열에 모델 개체를 가지는 ArrayList 초기화////////////////////////
        commentDatas = new ArrayList<DetailResult.CommentData>();

        ////////////////////////아이디값 전달받기////////////////////////
        Intent intent = getIntent();
        id = intent.getExtras().getString("id");

        ////////////////////////리사이클러 뷰와 어뎁터 연동////////////////////////
        ////////////////////////파라미터로 위의 ArrayList와 클릭이벤트////////////////////////
        comment_recyclerAdapter = new Comment_RecyclerAdapter(commentDatas);
        recyclerView.setAdapter(comment_recyclerAdapter);

        ////////////////////////네트워킹////////////////////////
        Networking();

        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommentInfo commentInfo = new CommentInfo();
                commentInfo.writer = commentwriter.getText().toString();
                commentInfo.content = commentcontent.getText().toString();
                if (commentInfo.writer.length() == 0 || commentInfo.content.length() == 0) {
                    Toast.makeText(getApplicationContext(), "댓글 작성자 혹은 내용을 입력해 주세요", Toast.LENGTH_SHORT).show();
                } else {
                    Call<CommentResult> commentResultCall = service.getCommentResult(id, commentInfo);
                    commentResultCall.enqueue(new Callback<CommentResult>() {
                        @Override
                        public void onResponse(Call<CommentResult> call, Response<CommentResult> response) {
                            if (response.isSuccessful()) {
                                if (response.body().message.equals("ok")) {
                                    Toast.makeText(getApplicationContext(), "댓글 등록 성공!!", Toast.LENGTH_SHORT).show();
                                    commentwriter.setText("");
                                    commentcontent.setText("");
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<CommentResult> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "댓글 등록 실패!! err message : " + t.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }

            }
        });
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void Networking() {
        /*
        통신부는 따로 정리해드리겠습니다 여기서는 간단하게
        메인부와 달리 getDetailResult(id)를 넘겨주어 해당 아이디를 서버가 확인하여
        정보를 넘겨줍니다
        */
        Call<DetailResult> requestDetail = service.getDetailResult(id);
        requestDetail.enqueue(new Callback<DetailResult>() {
            @Override
            public void onResponse(Call<DetailResult> call, Response<DetailResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().message.equals("ok")) {
                        titleTextview.setText("제목 : " + response.body().result.post.title);
                        contentTextview.setText(response.body().result.post.content);
                        writerTextview.setText(("작성자 : " + response.body().result.post.writer));
                        if (response.body().result.post.image_url != "") {
                            Glide.with(getApplicationContext())
                                    .load(response.body().result.post.image_url)
                                    .into(imgView);
                        }

                            commentDatas = response.body().result.comment;
                            comment_recyclerAdapter.setAdapter(commentDatas);


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
