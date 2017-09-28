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
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class HiddenActivity extends Activity {

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;

    //메뉴 페이지
    LinearLayout hiddenPage;

    public Button btnHome, btnmenu1, btnmenu2, btnmenu3, btnmenu4;
    public ImageButton btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidden);

        //백버튼
        backPressCloseHandler = new BackPressCloseHandler(this);

        //메뉴 페이지
        hiddenPage = (LinearLayout) findViewById(R.id.hiddenPage);
        hiddenPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background3)));

        btnHome = (Button) findViewById(R.id.btnHome);

        btnmenu1 = (Button) findViewById(R.id.btnmenu1);
        btnmenu1.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnscenery)));
        btnmenu2 = (Button) findViewById(R.id.btnmenu2);
        btnmenu2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btntypical)));
        btnmenu3 = (Button) findViewById(R.id.btnmenu3);
        btnmenu3.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnhidden2)));
        btnmenu4 = (Button) findViewById(R.id.btnmenu4);
        btnmenu4.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnpalace)));

        btn1 = (ImageButton) findViewById(R.id.btn1);
        btn1.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picchihyunjung)));
        btn2 = (ImageButton) findViewById(R.id.btn2);
        btn2.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picyongbongjung)));
        btn3 = (ImageButton) findViewById(R.id.btn3);
        btn3.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picbongeunsa)));
        btn4 = (ImageButton) findViewById(R.id.btn4);
        btn4.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picyeechon)));
        btn5 = (ImageButton) findViewById(R.id.btn5);
        btn5.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picgwangnaru)));
    }

    public void btnHomeClicked(View v) {
        Intent intent = (new Intent(HiddenActivity.this, MenuActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        HiddenActivity.this.finish();

        this.onDestroy();
    }

    //전경,대표,숨은,고궁 메뉴

    public void btnmenu1Clicked(View v) {
        Intent intent = (new Intent(HiddenActivity.this, SceneryActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        HiddenActivity.this.finish();

        this.onDestroy();
    }

    public void btnmenu2Clicked(View v) {
        Intent intent = (new Intent(HiddenActivity.this, TypicalActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        HiddenActivity.this.finish();

        this.onDestroy();
    }

    public void btnmenu4Clicked(View v) {
        Intent intent = (new Intent(HiddenActivity.this, PalaceActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        HiddenActivity.this.finish();

        this.onDestroy();
    }

    //장소 버튼

    public void btn1Clicked(View v) {
        Intent intent = (new Intent(HiddenActivity.this, InChihyunjung.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        HiddenActivity.this.finish();

        this.onDestroy();
    }

    public void btn2Clicked(View v) {
        Intent intent = (new Intent(HiddenActivity.this, InYongbongjung.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        HiddenActivity.this.finish();

        this.onDestroy();
    }

    public void btn3Clicked(View v) {
        Intent intent = (new Intent(HiddenActivity.this, InBongeunsa.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        HiddenActivity.this.finish();

        this.onDestroy();
    }

    public void btn4Clicked(View v) {
        Intent intent = (new Intent(HiddenActivity.this, InYeechon.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        HiddenActivity.this.finish();

        this.onDestroy();
    }

    public void btn5Clicked(View v) {
        Intent intent = (new Intent(HiddenActivity.this, InGwangnaru.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        HiddenActivity.this.finish();

        this.onDestroy();
    }

    //백버튼
    public void onBackPressed() {
        Intent intent = (new Intent(HiddenActivity.this, MenuActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        HiddenActivity.this.finish();

        this.onDestroy();
    }

    @Override

    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
