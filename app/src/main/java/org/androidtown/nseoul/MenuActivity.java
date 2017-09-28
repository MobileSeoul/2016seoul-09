package org.androidtown.nseoul;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.navdrawer.SimpleSideDrawer;

public class MenuActivity extends Activity {

    SimpleSideDrawer slide_menu;

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;

    //메뉴 페이지
    LinearLayout menuPage;

    public Button btnLogo, btnMenu01, btnMenu02, btnMenu03, btnMenu04, btnMenu05, btnMenu06;
    public Button btnSlide01, btnSlide02, btnSlide03, btnSlide04, btnSlide05, btnSlide06;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        slide_menu = new SimpleSideDrawer(this);
        slide_menu.setLeftBehindContentView(R.layout.activity_setting);

        //백버튼
        backPressCloseHandler = new BackPressCloseHandler(this);

        //메뉴 페이지
        menuPage = (LinearLayout) findViewById(R.id.menuPage);
        menuPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background3)));

        btnLogo = (Button) findViewById(R.id.btnLogo);
        btnMenu01 = (Button) findViewById(R.id.btnMenu01);
        btnMenu02 = (Button) findViewById(R.id.btnMenu02);
        btnMenu03 = (Button) findViewById(R.id.btnMenu03);
        btnMenu04 = (Button) findViewById(R.id.btnMenu04);
        btnMenu05 = (Button) findViewById(R.id.btnMenu05);
        btnMenu06 = (Button) findViewById(R.id.btnMenu06);

        btnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                slide_menu.toggleLeftDrawer();

                btnSlide01 = (Button) findViewById(R.id.btnSlide01);
                btnSlide02 = (Button) findViewById(R.id.btnSlide02);
                btnSlide03 = (Button) findViewById(R.id.btnSlide03);
                btnSlide04 = (Button) findViewById(R.id.btnSlide04);
                btnSlide05 = (Button) findViewById(R.id.btnSlide05);
                btnSlide06 = (Button) findViewById(R.id.btnSlide06);

                btnSlide01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        Intent intent = (new Intent(MenuActivity.this, SceneryActivity.class));
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade, R.anim.hold);
                        MenuActivity.this.finish();

                        MenuActivity.this.onDestroy();
                    }
                });

                btnSlide02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        Intent intent = (new Intent(MenuActivity.this, TypicalActivity.class));
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade, R.anim.hold);
                        MenuActivity.this.finish();

                        MenuActivity.this.onDestroy();
                    }
                });

                btnSlide03.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        Intent intent = (new Intent(MenuActivity.this, HiddenActivity.class));
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade, R.anim.hold);
                        MenuActivity.this.finish();

                        MenuActivity.this.onDestroy();
                    }
                });

                btnSlide04.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        Intent intent = (new Intent(MenuActivity.this, PalaceActivity.class));
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade, R.anim.hold);
                        MenuActivity.this.finish();

                        MenuActivity.this.onDestroy();
                    }
                });

                btnSlide05.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        Intent intent = (new Intent(MenuActivity.this, RegionActivity.class));
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade, R.anim.hold);
                        MenuActivity.this.finish();

                        MenuActivity.this.onDestroy();
                    }
                });

                btnSlide06.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        Intent intent = (new Intent(MenuActivity.this, Citytour1.class));
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade, R.anim.hold);
                        MenuActivity.this.finish();

                        MenuActivity.this.onDestroy();
                    }
                });
            }
        });
    }

    public void btnMenu01Clicked(View v){
        Intent intent = (new Intent(MenuActivity.this, SceneryActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenuActivity.this.finish();

        this.onDestroy();
    }

    public void btnMenu02Clicked(View v){
        Intent intent = (new Intent(MenuActivity.this, TypicalActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenuActivity.this.finish();

        this.onDestroy();
    }

    public void btnMenu03Clicked(View v){
        Intent intent = (new Intent(MenuActivity.this, HiddenActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenuActivity.this.finish();

        this.onDestroy();
    }

    public void btnMenu04Clicked(View v){
        Intent intent = (new Intent(MenuActivity.this, PalaceActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenuActivity.this.finish();

        this.onDestroy();
    }

    public void btnMenu05Clicked(View v){
        Intent intent = (new Intent(MenuActivity.this, RegionActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenuActivity.this.finish();

        this.onDestroy();
    }

    public void btnMenu06Clicked(View v){
        Intent intent = (new Intent(MenuActivity.this, AboutActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenuActivity.this.finish();

        this.onDestroy();
    }

    //백버튼
    public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }

    @Override

    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
