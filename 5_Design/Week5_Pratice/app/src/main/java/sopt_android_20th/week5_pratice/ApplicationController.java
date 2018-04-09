package sopt_android_20th.week5_pratice;

import android.app.Application;

import com.tsengvn.typekit.Typekit;

/**
 * Created by pc on 2017-05-04.
 */

public class ApplicationController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "NanumBarunGothicBold.ttf"))
                .addBold(Typekit.createFromAsset(this, "NanumBarunGothic.ttf"))
                .addCustom1(Typekit.createFromAsset(this, "NanumBarunGothicLight.ttf"))
                .addCustom2(Typekit.createFromAsset(this, "NanumBarunGothicUltraLight.ttf"))
                .addCustom3(Typekit.createFromAsset(this, "NanumMyeongjo.ttc"))
                .addCustom4(Typekit.createFromAsset(this, "NanumMyeongjoExtraBold.ttf"));
    }
}
