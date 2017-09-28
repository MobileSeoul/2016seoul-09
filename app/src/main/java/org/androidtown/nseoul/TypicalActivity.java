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

public class TypicalActivity extends Activity {

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;

    //메뉴 페이지
    LinearLayout typicalPage;

    public Button btnHome, btnmenu1, btnmenu2, btnmenu3, btnmenu4;
    public ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typical);

        //백버튼
        backPressCloseHandler = new BackPressCloseHandler(this);

        //메뉴 페이지
        typicalPage = (LinearLayout) findViewById(R.id.typicalPage);
        typicalPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background3)));

        btnHome = (Button) findViewById(R.id.btnHome);

        btnmenu1 = (Button) findViewById(R.id.btnmenu1);
        btnmenu1.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnscenery)));
        btnmenu2 = (Button) findViewById(R.id.btnmenu2);
        btnmenu2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btntypical2)));
        btnmenu3 = (Button) findViewById(R.id.btnmenu3);
        btnmenu3.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnhidden)));
        btnmenu4 = (Button) findViewById(R.id.btnmenu4);
        btnmenu4.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnpalace)));

        btn1 = (ImageButton) findViewById(R.id.btn1);
        btn1.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picgwanghwamun)));
        btn2 = (ImageButton) findViewById(R.id.btn2);
        btn2.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picsungnyemun)));
        btn3 = (ImageButton) findViewById(R.id.btn3);
        btn3.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picseokchonlake)));
        btn4 = (ImageButton) findViewById(R.id.btn4);
        btn4.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picpeacegate)));
        btn5 = (ImageButton) findViewById(R.id.btn5);
        btn5.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picseongsan)));
        btn6 = (ImageButton) findViewById(R.id.btn6);
        btn6.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picbanghwa)));
        btn7 = (ImageButton) findViewById(R.id.btn7);
        btn7.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picbanpo)));
        btn8 = (ImageButton) findViewById(R.id.btn8);
        btn8.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picyeoui)));
        btn9 = (ImageButton) findViewById(R.id.btn9);
        btn9.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.piccheonggyecheon)));
        btn10 = (ImageButton) findViewById(R.id.btn10);
        btn10.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picddp)));
        btn11 = (ImageButton) findViewById(R.id.btn11);
        btn11.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picseonyudo)));
        btn12 = (ImageButton) findViewById(R.id.btn12);
        btn12.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picttukseom)));
}

    public void btnHomeClicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, MenuActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    //전경,대표,숨은,고궁 메뉴

    public void btnmenu1Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, SceneryActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    public void btnmenu3Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, HiddenActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    public void btnmenu4Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, PalaceActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    //장소 버튼

    public void btn1Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, InGwanghwamun.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    public void btn2Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, InSungnyemun.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    public void btn3Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, InSeokchonlake.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    public void btn4Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, InPeacegate.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    public void btn5Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, InSeongsan.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    public void btn6Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, InBanghwa.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    public void btn7Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, InBanpo.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    public void btn8Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, InYeoui.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    public void btn9Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, InCheonggyecheon.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    public void btn10Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, InDdp.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    public void btn11Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, InSeonyudo.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    public void btn12Clicked(View v) {
        Intent intent = (new Intent(TypicalActivity.this, InTtukseom.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    //백버튼
    public void onBackPressed() {
        Intent intent = (new Intent(TypicalActivity.this, MenuActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        TypicalActivity.this.finish();

        this.onDestroy();
    }

    @Override

    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
