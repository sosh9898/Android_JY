package sopt_android_20th.week7_pratice.Network;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import sopt_android_20th.week7_pratice.Detail.CommentInfo;
import sopt_android_20th.week7_pratice.Detail.CommentResult;
import sopt_android_20th.week7_pratice.Detail.DetailResult;
import sopt_android_20th.week7_pratice.Main.MainResult;
import sopt_android_20th.week7_pratice.Register.RegisterResult;


/**
 * Created by pc on 2017-05-14.
 */

public interface NetworkService  {

    @GET("/lists")
    Call<MainResult> getMainResult();

    @GET("/lists/{id}")
    Call<DetailResult> getDetailResult(@Path("id") String id);

    @POST("/lists/{id}")
    Call<CommentResult> getCommentResult(@Path("id") String id, @Body CommentInfo commentInfo);

    @Multipart
    @POST("/lists")
    Call<RegisterResult> registerImgNotice(@Part MultipartBody.Part file,
                                           @Part("writer") RequestBody writer,
                                           @Part("title") RequestBody title,
                                           @Part("content") RequestBody contents);


}
