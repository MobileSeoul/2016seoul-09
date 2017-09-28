package org.androidtown.nseoul;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.LinearLayout;

public class Citytour1 extends Activity {

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;

    //메뉴 페이지
    LinearLayout citytour1Page;

    public Button btnBack, btnmenu1, btnmenu2, btnmenu3;
    public Button btn1, btn2, btn3, btn4, btn5, btn6;

    public ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citytour1);

        //메뉴 페이지
        citytour1Page = (LinearLayout) findViewById(R.id.citytour1Page);
        citytour1Page.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background5)));

        //노선
        imageview = (ImageView) findViewById(R.id.imageview);
        imageview.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.citycourse1)));

        //백버튼
        backPressCloseHandler = new BackPressCloseHandler(this);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnmenu1 = (Button) findViewById(R.id.btnmenu1);
        btnmenu1.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.citytour11)));
        btnmenu2 = (Button) findViewById(R.id.btnmenu2);
        btnmenu2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.citytour20)));
        btnmenu3 = (Button) findViewById(R.id.btnmenu3);
        btnmenu3.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.citytour30)));

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
    }

    //백버튼
    public void onBackPressed() {
        Intent intent = (new Intent(Citytour1.this, MenuActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        Citytour1.this.finish();

        this.onDestroy();
    }

    public void btnBackClicked(View v) {
        Intent intent = (new Intent(Citytour1.this, MenuActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        Citytour1.this.finish();

        this.onDestroy();
    }

    //시티투어버스 메뉴

    public void btnmenu2Clicked(View v) {
        Intent intent = (new Intent(Citytour1.this, Citytour2.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        Citytour1.this.finish();

        this.onDestroy();
    }

    public void btnmenu3Clicked(View v) {
        Intent intent = (new Intent(Citytour1.this, Citytour3.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        Citytour1.this.finish();

        this.onDestroy();
    }

    //장소 버튼

    public void btn1Clicked(View v) {
        Intent intent = (new Intent(Citytour1.this, InGwanghwamun.class));
        intent.putExtra("type", "3");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        Citytour1.this.finish();

        this.onDestroy();
    }

    public void btn2Clicked(View v) {
        Intent intent = (new Intent(Citytour1.this, InYeoui.class));
        intent.putExtra("type", "3");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        Citytour1.this.finish();

        this.onDestroy();
    }

    public void btn3Clicked(View v) {
        Intent intent = (new Intent(Citytour1.this, InYeechon.class));
        intent.putExtra("type", "3");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        Citytour1.this.finish();

        this.onDestroy();
    }

    public void btn4Clicked(View v) {
        Intent intent = (new Intent(Citytour1.this, InNamsan.class));
        intent.putExtra("type", "3");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        Citytour1.this.finish();

        this.onDestroy();
    }

    public void btn5Clicked(View v) {
        Intent intent = (new Intent(Citytour1.this, InSungnyemun.class));
        intent.putExtra("type", "3");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        Citytour1.this.finish();

        this.onDestroy();
    }

    public void btn6Clicked(View v) {
        Intent intent = (new Intent(Citytour1.this, InCheonggyecheon.class));
        intent.putExtra("type", "3");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        Citytour1.this.finish();

        this.onDestroy();
    }

    @Override

    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
