package org.androidtown.nseoul;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MenunorthActivity extends Activity {

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;

    //메뉴 페이지
    LinearLayout northPage;

    public Button btnBack, btnmenu1, btnmenu2, btnmenu3, btnmenu4;
    public ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north);

        //메뉴 페이지
        northPage = (LinearLayout) findViewById(R.id.northPage);
        northPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background6)));

        //백버튼
        backPressCloseHandler = new BackPressCloseHandler(this);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnmenu1 = (Button) findViewById(R.id.btnmenu1);
        btnmenu1.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btneast)));
        btnmenu2 = (Button) findViewById(R.id.btnmenu2);
        btnmenu2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnwest)));
        btnmenu3 = (Button) findViewById(R.id.btnmenu3);
        btnmenu3.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnsouth)));
        btnmenu4 = (Button) findViewById(R.id.btnmenu4);
        btnmenu4.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnnorth2)));

        btn1 = (ImageButton) findViewById(R.id.btn1);
        btn1.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picnamsan)));
        btn2 = (ImageButton) findViewById(R.id.btn2);
        btn2.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picnaksan)));
        btn3 = (ImageButton) findViewById(R.id.btn3);
        btn3.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picmaebong)));
        btn4 = (ImageButton) findViewById(R.id.btn4);
        btn4.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picgwanghwamun)));
        btn5 = (ImageButton) findViewById(R.id.btn5);
        btn5.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picsungnyemun)));
        btn6 = (ImageButton) findViewById(R.id.btn6);
        btn6.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picyeechon)));
        btn7 = (ImageButton) findViewById(R.id.btn7);
        btn7.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picgyeongbokgung)));
        btn8 = (ImageButton) findViewById(R.id.btn8);
        btn8.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picchangdeokgung)));
        btn9 = (ImageButton) findViewById(R.id.btn9);
        btn9.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picchanggyeonggung)));
        btn10 = (ImageButton) findViewById(R.id.btn10);
        btn10.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picdeoksugung)));
        btn11 = (ImageButton) findViewById(R.id.btn11);
        btn11.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picgyeonghuigung)));
        btn12 = (ImageButton) findViewById(R.id.btn12);
        btn12.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.piccheonggyecheon)));
    }

    //백버튼
    public void onBackPressed() {
        Intent intent = (new Intent(MenunorthActivity.this, RegionActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btnBackClicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, RegionActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    //강동,강서,강남,강북 메뉴

    public void btnmenu1Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, MenueastActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btnmenu2Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, MenuwestActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btnmenu3Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, MenusouthActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    //장소 버튼
    public void btn1Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, InNamsan.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btn2Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, InNaksan.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btn3Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, InMaebong.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btn4Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, InGwanghwamun.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btn5Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, InSungnyemun.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btn6Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, InYeechon.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btn7Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, InGyeongbokgung.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btn8Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, InChangdeokgung.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btn9Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, InChanggyeonggung.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btn10Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, InDeoksugung.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btn11Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, InGyeonghuigung.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    public void btn12Clicked(View v) {
        Intent intent = (new Intent(MenunorthActivity.this, InCheonggyecheon.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        MenunorthActivity.this.finish();

        this.onDestroy();
    }

    @Override

    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
