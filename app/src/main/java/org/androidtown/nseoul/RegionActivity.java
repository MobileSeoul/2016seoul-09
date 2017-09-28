package org.androidtown.nseoul;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class RegionActivity extends Activity {

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;

    //지역 페이지
    LinearLayout regionPage;

    public Button btnHome, btnRegion01, btnRegion02, btnRegion03, btnRegion04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);

        //백버튼
        backPressCloseHandler = new BackPressCloseHandler(this);

        //지역 페이지
        regionPage = (LinearLayout) findViewById(R.id.regionPage);
        regionPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background6)));

        btnHome = (Button) findViewById(R.id.btnHome);
        btnRegion01 = (Button) findViewById(R.id.btnRegion01);
        btnRegion01.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.region1)));
        btnRegion02 = (Button) findViewById(R.id.btnRegion02);
        btnRegion02.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.region2)));
        btnRegion03 = (Button) findViewById(R.id.btnRegion03);
        btnRegion03.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.region3)));
        btnRegion04 = (Button) findViewById(R.id.btnRegion04);
        btnRegion04.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.region4)));
    }

    //백버튼
    public void onBackPressed() {
        Intent intent = (new Intent(RegionActivity.this, MenuActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        RegionActivity.this.finish();

        this.onDestroy();
    }

    public void btnHomeClicked(View v) {
        Intent intent = (new Intent(RegionActivity.this, MenuActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        RegionActivity.this.finish();

        this.onDestroy();
    }

    public void btnRegion01Clicked(View v){
        Intent intent = (new Intent(RegionActivity.this, MenueastActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        RegionActivity.this.finish();

        this.onDestroy();
    }

    public void btnRegion02Clicked(View v){
        Intent intent = (new Intent(RegionActivity.this, MenuwestActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        RegionActivity.this.finish();

        this.onDestroy();
    }

    public void btnRegion03Clicked(View v){
        Intent intent = (new Intent(RegionActivity.this, MenusouthActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        RegionActivity.this.finish();

        this.onDestroy();
    }

    public void btnRegion04Clicked(View v){
        Intent intent = (new Intent(RegionActivity.this, MenunorthActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        RegionActivity.this.finish();

        this.onDestroy();
    }

    @Override

    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
