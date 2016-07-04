package com.recipe.newcle.sidedish;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hoyun on 2016-03-28.
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(), 2000); // 2초 후에 hd Handler 실행
    }

    private class splashhandler implements Runnable {
        public void run() {
            startActivity(new Intent(getApplicationContext(), MainActivity.class)); // 로딩이 끝난후 이동할 Activity
            SplashActivity.this.finish(); // 로딩페이지 Activity Stack에서 제거
        }
    }
}
