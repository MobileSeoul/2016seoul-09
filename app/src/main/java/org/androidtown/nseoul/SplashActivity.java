package org.androidtown.nseoul;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {

    RelativeLayout splashPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashPage = (RelativeLayout) findViewById(R.id.splashPage);
        splashPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background1)));

        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(), 3000);
    }

    private class splashhandler implements Runnable{
        public void run(){
            startActivity(new Intent(getApplication(), MainActivity.class));
            SplashActivity.this.finish();
        }
    }

    public void onBackPressed(){}

    @Override

    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
