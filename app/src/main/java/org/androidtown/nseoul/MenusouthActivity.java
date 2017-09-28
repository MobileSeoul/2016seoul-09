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

public class MenusouthActivity extends Activity {

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;

    //메뉴 페이지
    LinearLayout southPage;

    public Button btnBack, btnmenu1, btnmenu2, btnmenu3, btnmenu4;
    public ImageButton btn1, btn2, btn3, btn4, btn5, btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south);

        //메뉴 페이지
        southPage = (LinearLayout) findViewById(R.id.southPage);
        southPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
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
                (getResources(), R.drawable.btnsouth2)));
        btnmenu4 = (Button) findViewById(R.id.btnmenu4);
        btnmenu4.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnnorth)));

        btn1 = (ImageButton) findViewById(R.id.btn1);
        btn1.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picnamhansan)));
        btn2 = (ImageButton) findViewById(R.id.btn2);
        btn2.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picseokchonlake)));
        btn3 = (ImageButton) findViewById(R.id.btn3);
        btn3.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picpeacegate)));
        btn4 = (ImageButton) findViewById(R.id.btn4);
        btn4.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picbanpo)));
        btn5 = (ImageButton) findViewById(R.id.btn5);
        btn5.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picyongbongjung)));
        btn6 = (ImageButton) findViewById(R.id.btn6);
        btn6.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picbongeunsa)));
    }

    //백버튼
    public void onBackPressed() {
        Intent intent = (new Intent(MenusouthActivity.this, RegionActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenusouthActivity.this.finish();

        this.onDestroy();
    }

    public void btnBackClicked(View v) {
        Intent intent = (new Intent(MenusouthActivity.this, RegionActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenusouthActivity.this.finish();

        this.onDestroy();
    }

    //강동,강서,강남,강북 메뉴

    public void btnmenu1Clicked(View v) {
        Intent intent = (new Intent(MenusouthActivity.this, MenueastActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenusouthActivity.this.finish();

        this.onDestroy();
    }

    public void btnmenu2Clicked(View v) {
        Intent intent = (new Intent(MenusouthActivity.this, MenuwestActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenusouthActivity.this.finish();

        this.onDestroy();
    }

    public void btnmenu4Clicked(View v) {
        Intent intent = (new Intent(MenusouthActivity.this, MenunorthActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenusouthActivity.this.finish();

        this.onDestroy();
    }

    //장소 버튼

    public void btn1Clicked(View v) {
        Intent intent = (new Intent(MenusouthActivity.this, InNamhansan.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        MenusouthActivity.this.finish();

        this.onDestroy();
    }

    public void btn2Clicked(View v) {
        Intent intent = (new Intent(MenusouthActivity.this, InSeokchonlake.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        MenusouthActivity.this.finish();

        this.onDestroy();
    }

    public void btn3Clicked(View v) {
        Intent intent = (new Intent(MenusouthActivity.this, InPeacegate.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        MenusouthActivity.this.finish();

        this.onDestroy();
    }

    public void btn4Clicked(View v) {
        Intent intent = (new Intent(MenusouthActivity.this, InBanpo.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        MenusouthActivity.this.finish();

        this.onDestroy();
    }

    public void btn5Clicked(View v) {
        Intent intent = (new Intent(MenusouthActivity.this, InYongbongjung.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        MenusouthActivity.this.finish();

        this.onDestroy();
    }

    public void btn6Clicked(View v) {
        Intent intent = (new Intent(MenusouthActivity.this, InBongeunsa.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        MenusouthActivity.this.finish();

        this.onDestroy();
    }

    @Override

    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
