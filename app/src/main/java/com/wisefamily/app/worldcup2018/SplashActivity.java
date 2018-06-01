package com.wisefamily.app.worldcup2018;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.wisefamily.app.worldcup2018.data.WCData;
import com.wisefamily.app.worldcup2018.model.Groups;
import com.wisefamily.app.worldcup2018.net.WCApi;

import java.util.Locale;


public class SplashActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 1000;
//    private DBHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        MobileAds.initialize(this, getString(R.string.admob_id));
        Locale locale = getCurrentLocale(this);
        WCData.getInstance().setCurrentLocale(locale);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* 메뉴액티비티를 실행하고 로딩화면을 죽인다.*/ // TODO - load sqlite data
                requestInitDatas();

            }
        }, SPLASH_DISPLAY_LENGTH);

    }

    private void requestInitDatas() {
        String url = String.format("%s", WCApi.PATH_API_ROUND);

        WCApi.exec(this, url, null, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Groups groups = new Gson().fromJson(response, Groups.class);
                WCData.getInstance().setGroups(groups);
                WCData.getInstance().setRemoteGroups(groups);
//                LottoInitData.getInstance().setRecentInfo(init, dbHelper);
//                dbHelper.insertDataFromList(LottoInitData.getInstance().getLottoList());

                /* 메뉴액티비티를 실행하고 로딩화면을 죽인다.*/
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                /* 메뉴액티비티를 실행하고 로딩화면을 죽인다.*/
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
    }

    private Locale getCurrentLocale(Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return context.getResources().getConfiguration().getLocales().get(0);
        } else{
            //noinspection deprecation
            return context.getResources().getConfiguration().locale;
        }
    }

}
