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

public class MenueastActivity extends Activity {

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;

    //메뉴 페이지
    LinearLayout eastPage;

    public Button btnBack, btnmenu1, btnmenu2, btnmenu3, btnmenu4;
    public ImageButton btn1, btn2, btn3, btn4, btn5, btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_east);

        //메뉴 페이지
        eastPage = (LinearLayout) findViewById(R.id.eastPage);
        eastPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background6)));

        //백버튼
        backPressCloseHandler = new BackPressCloseHandler(this);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnmenu1 = (Button) findViewById(R.id.btnmenu1);
        btnmenu1.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btneast2)));
        btnmenu2 = (Button) findViewById(R.id.btnmenu2);
        btnmenu2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnwest)));
        btnmenu3 = (Button) findViewById(R.id.btnmenu3);
        btnmenu3.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnsouth)));
        btnmenu4 = (Button) findViewById(R.id.btnmenu4);
        btnmenu4.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnnorth)));

        btn1 = (ImageButton) findViewById(R.id.btn1);
        btn1.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.piceungbong)));
        btn2 = (ImageButton) findViewById(R.id.btn2);
        btn2.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.pictechnomart)));
        btn3 = (ImageButton) findViewById(R.id.btn3);
        btn3.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picddp)));
        btn4 = (ImageButton) findViewById(R.id.btn4);
        btn4.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picseoulforest)));
        btn5 = (ImageButton) findViewById(R.id.btn5);
        btn5.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picttukseom)));
        btn6 = (ImageButton) findViewById(R.id.btn6);
        btn6.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picgwangnaru)));
    }

    //백버튼
    public void onBackPressed() {
        Intent intent = (new Intent(MenueastActivity.this, RegionActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenueastActivity.this.finish();

        this.onDestroy();
    }

    public void btnBackClicked(View v) {
        Intent intent = (new Intent(MenueastActivity.this, RegionActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenueastActivity.this.finish();

        this.onDestroy();
    }

    //강동,강서,강남,강북 메뉴

    public void btnmenu2Clicked(View v) {
        Intent intent = (new Intent(MenueastActivity.this, MenuwestActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenueastActivity.this.finish();

        this.onDestroy();
    }

    public void btnmenu3Clicked(View v) {
        Intent intent = (new Intent(MenueastActivity.this, MenusouthActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenueastActivity.this.finish();

        this.onDestroy();
    }

    public void btnmenu4Clicked(View v) {
        Intent intent = (new Intent(MenueastActivity.this, MenunorthActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        MenueastActivity.this.finish();

        this.onDestroy();
    }

    //장소 버튼

    public void btn1Clicked(View v) {
        Intent intent = (new Intent(MenueastActivity.this, InEungbong.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        MenueastActivity.this.finish();

        this.onDestroy();
    }

    public void btn2Clicked(View v) {
        Intent intent = (new Intent(MenueastActivity.this, InTechnomart.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        MenueastActivity.this.finish();

        this.onDestroy();
    }

    public void btn3Clicked(View v) {
        Intent intent = (new Intent(MenueastActivity.this, InDdp.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        MenueastActivity.this.finish();

        this.onDestroy();
    }

    public void btn4Clicked(View v) {
        Intent intent = (new Intent(MenueastActivity.this, InSeoulforest.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        MenueastActivity.this.finish();

        this.onDestroy();
    }

    public void btn5Clicked(View v) {
        Intent intent = (new Intent(MenueastActivity.this, InTtukseom.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        MenueastActivity.this.finish();

        this.onDestroy();
    }

    public void btn6Clicked(View v) {
        Intent intent = (new Intent(MenueastActivity.this, InGwangnaru.class));
        intent.putExtra("type", "2");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        MenueastActivity.this.finish();

        this.onDestroy();
    }

    @Override

    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
