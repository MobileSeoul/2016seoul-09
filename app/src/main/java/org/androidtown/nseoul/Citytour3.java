package org.androidtown.nseoul;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Citytour3 extends Activity {

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;

    //메뉴 페이지
    LinearLayout citytour3Page;

    public Button btnBack, btnmenu1, btnmenu2, btnmenu3;
    public Button btn1, btn2, btn3;

    public ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citytour3);

        //메뉴 페이지
        citytour3Page = (LinearLayout) findViewById(R.id.citytour3Page);
        citytour3Page.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background5)));

        //노선
        imageview = (ImageView) findViewById(R.id.imageview);
        imageview.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.citycourse3)));

        //백버튼
        backPressCloseHandler = new BackPressCloseHandler(this);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnmenu1 = (Button) findViewById(R.id.btnmenu1);
        btnmenu1.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.citytour10)));
        btnmenu2 = (Button) findViewById(R.id.btnmenu2);
        btnmenu2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.citytour20)));
        btnmenu3 = (Button) findViewById(R.id.btnmenu3);
        btnmenu3.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.citytour31)));

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
    }

    //백버튼
    public void onBackPressed() {
        Intent intent = (new Intent(Citytour3.this, MenuActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        Citytour3.this.finish();

        this.onDestroy();
    }

    public void btnBackClicked(View v) {
        Intent intent = (new Intent(Citytour3.this, MenuActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        Citytour3.this.finish();

        this.onDestroy();
    }

    //시티투어버스 메뉴

    public void btnmenu1Clicked(View v) {
        Intent intent = (new Intent(Citytour3.this, Citytour1.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        Citytour3.this.finish();

        this.onDestroy();
    }

    public void btnmenu2Clicked(View v) {
        Intent intent = (new Intent(Citytour3.this, Citytour2.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        Citytour3.this.finish();

        this.onDestroy();
    }

    //장소 버튼

    public void btn1Clicked(View v) {
        Intent intent = (new Intent(Citytour3.this, InDdp.class));
        intent.putExtra("type", "5");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        Citytour3.this.finish();

        this.onDestroy();
    }

    public void btn2Clicked(View v) {
        Intent intent = (new Intent(Citytour3.this, InGwanghwamun.class));
        intent.putExtra("type", "5");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        Citytour3.this.finish();

        this.onDestroy();
    }

    public void btn3Clicked(View v) {
        Intent intent = (new Intent(Citytour3.this, InSungnyemun.class));
        intent.putExtra("type", "5");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        Citytour3.this.finish();

        this.onDestroy();
    }

    @Override

    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
