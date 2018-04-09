package sopt_android_20th.week7_pratice.Register;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt_android_20th.week7_pratice.Network.NetworkService;
import sopt_android_20th.week7_pratice.R;
import sopt_android_20th.week7_pratice.application.ApplicationController;


public class RegisterActivity extends AppCompatActivity {

    private Button addImgBtn;
    private TextView imgNameTextView;
    private EditText inputTitleEdit;
    private EditText inputContentEdit;
    private EditText inputWriterEdit;
    private Button completeBtn;
    private TextView text_length;

    final int REQ_CODE_SELECT_IMAGE = 100;
    String imgUrl = "";
    Uri data;
    NetworkService service;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ////////////////////////서비스 객체 초기화////////////////////////
        service = ApplicationController.getInstance().getNetworkService();

        ////////////////////////뷰 객체 초기화////////////////////////
        addImgBtn = (Button) findViewById(R.id.getImageBtn);
        imgNameTextView = (TextView) findViewById(R.id.addImageName);
        inputTitleEdit = (EditText) findViewById(R.id.inputTitleEdit);
        inputContentEdit = (EditText) findViewById(R.id.inputContentEdit);
        inputWriterEdit = (EditText) findViewById(R.id.inputWriterEdit);
        completeBtn = (Button) findViewById(R.id.completeBtn);
        text_length = (TextView) findViewById(R.id.text_length);

        ////////////////////////프로그래스 다이얼로그 입니다////////////////////////
        mProgressDialog = new ProgressDialog(RegisterActivity.this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("등록 중...");
        mProgressDialog.setIndeterminate(true);


        ////////////////////////갤러리를 호출합니다////////////////////////
        addImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);
            }
        });

        ////////////////////////text 필드의 텍스트 길이를 출력!!////////////////////////
        inputContentEdit.addTextChangedListener(new TextWatcher() {
            String strCur;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                strCur = s.toString();

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text_length.setText(String.valueOf(s.length()) + "/500");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ////////////////////////Edit Text 길이제한!!////////////////////////
        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(500);
        inputContentEdit.setFilters(FilterArray);


        ////////////////////////완료버튼!!////////////////////////
        completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputTitleEdit.length() == 0 || inputContentEdit.length() == 0) {
                    Toast.makeText(getApplicationContext(), "제목 및 내용을 확인해주세요.", Toast.LENGTH_SHORT).show();
                } else {

                    mProgressDialog.show();

                   /*
                   RequestBody 객체에 edittext값들을 저장합니다.
                    */

                    RequestBody title = RequestBody.create(MediaType.parse("multipart/form-data"), inputTitleEdit.getText().toString());
                    RequestBody content = RequestBody.create(MediaType.parse("multipart/form-data"), inputContentEdit.getText().toString());
                    RequestBody writer = RequestBody.create(MediaType.parse("multipart/form-data"), inputWriterEdit.getText().toString());

                    MultipartBody.Part body;

                    if (imgUrl == "") {
                        body = null;
                    } else {

                        /**
                         * 비트맵 관련한 자료는 아래의 링크에서 참고
                         * http://mainia.tistory.com/468
                         */

                    /*
                    이미지를 리사이징하는 부분입니다.
                    리사이징하는 이유!! 안드로이드는 메모리에 민감하다고 세미나에서 말씀드렸습니다~
                    구글에서는 최소 16MByte로 정하고 있으나, 제조사 별로 또 디바이스별로 메모리의 크기는 다릅니다.
                    또한, 이미지를 서버에 업로드할 때 이미지의 크기가 크다면 시간이 오래 걸리고 데이터 소모가 큽니다!!
                     */
                        BitmapFactory.Options options = new BitmapFactory.Options();
//                       options.inSampleSize = 4; //얼마나 줄일지 설정하는 옵션 4--> 1/4로 줄이겠다

                        InputStream in = null; // here, you need to get your context.
                        try {
                            in = getContentResolver().openInputStream(data);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        /*inputstream 형태로 받은 이미지로 부터 비트맵을 만들어 바이트 단위로 압축
                        그이우 스트림 배열에 담아서 전송합니다.
                         */

                        Bitmap bitmap = BitmapFactory.decodeStream(in, null, options); // InputStream 으로부터 Bitmap 을 만들어 준다.
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos);
                        // 압축 옵션( JPEG, PNG ) , 품질 설정 ( 0 - 100까지의 int형 ), 압축된 바이트 배열을 담을 스트림
                        RequestBody photoBody = RequestBody.create(MediaType.parse("image/jpg"), baos.toByteArray());

                        File photo = new File(imgUrl); // 가져온 파일의 이름을 알아내려고 사용합니다

                        // MultipartBody.Part 실제 파일의 이름을 보내기 위해 사용!!
                        body = MultipartBody.Part.createFormData("image", photo.getName(), photoBody);


                    }

                    /*
                    통신부는 따로 정리해드리겠습니다.
                    이번에는 post 메소드 입니다. body(이미지),writer,title,content 를 넘깁니다.
                     파일과 텍스트를 함께 넘길 때는 multipart를 사용합니다.
                     */
                    Call<RegisterResult> requestImgNotice = service.registerImgNotice(body, writer, title, content);
                    requestImgNotice.enqueue(new Callback<RegisterResult>() {
                        @Override
                        public void onResponse(Call<RegisterResult> call, Response<RegisterResult> response) {
                            if (response.isSuccessful()) {
                                if (response.body().message.equals("ok")) {
                                    finish();
                                    mProgressDialog.dismiss();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                                mProgressDialog.dismiss();
                            }
                        }

                        @Override
                        public void onFailure(Call<RegisterResult> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                            Log.i("myTag", t.toString());
                            mProgressDialog.dismiss();
                        }
                    });
                }
            }
        });
    }

    // 선택된 이미지 가져오기
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQ_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    //Uri에서 이미지 이름을 얻어온다.
                    String name_Str = getImageNameToUri(data.getData());
                    imgNameTextView.setText(name_Str);
                    this.data = data.getData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                imgUrl = "";
                imgNameTextView.setText("");
            }
        }
    }

    // 선택된 이미지 파일명 가져오기
    public String getImageNameToUri(Uri data) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(data, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        String imgPath = cursor.getString(column_index);
        String imgName = imgPath.substring(imgPath.lastIndexOf("/") + 1);

        imgUrl = imgPath;
        return imgName;
    }

}
