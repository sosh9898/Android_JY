package sopt_android_20th.week6_pratice.Network;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import sopt_android_20th.week6_pratice.Detail.DetailResult;
import sopt_android_20th.week6_pratice.Main.MainResult;
import sopt_android_20th.week6_pratice.Register.RegisterResult;

/**
 * Created by pc on 2017-05-14.
 */

public interface NetworkService  {

    @GET("/")
    Call<MainResult> getMainResult();

    @GET("/{id}")
    Call<DetailResult> getDetailResult(@Path("id") String id);

    @Multipart
    @POST("/")
    Call<RegisterResult> registerImgNotice(@Part MultipartBody.Part file,
                                           @Part("username") RequestBody writer,
                                           @Part("title") RequestBody title,
                                           @Part("content") RequestBody contents);


}
