package org.androidtown.nseoul;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class SceneryActivity extends Activity {

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;

    //메뉴 페이지
    LinearLayout sceneryPage;

    public Button btnHome, btnmenu1, btnmenu2, btnmenu3, btnmenu4;
    public ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenery);

        //백버튼
        backPressCloseHandler = new BackPressCloseHandler(this);

        //메뉴 페이지
        sceneryPage = (LinearLayout) findViewById(R.id.sceneryPage);
        sceneryPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background3)));

        btnHome = (Button) findViewById(R.id.btnHome);

        btnmenu1 = (Button) findViewById(R.id.btnmenu1);
        btnmenu1.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnscenery2)));
        btnmenu2 = (Button) findViewById(R.id.btnmenu2);
        btnmenu2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btntypical)));
        btnmenu3 = (Button) findViewById(R.id.btnmenu3);
        btnmenu3.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnhidden)));
        btnmenu4 = (Button) findViewById(R.id.btnmenu4);
        btnmenu4.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.btnpalace)));

        btn1 = (ImageButton) findViewById(R.id.btn1);
        btn1.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picnamhansan)));
        btn2 = (ImageButton) findViewById(R.id.btn2);
        btn2.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picnamsan)));
        btn3 = (ImageButton) findViewById(R.id.btn3);
        btn3.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picnaksan)));
        btn4 = (ImageButton) findViewById(R.id.btn4);
        btn4.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picskypark)));
        btn5 = (ImageButton) findViewById(R.id.btn5);
        btn5.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.piceungbong)));
        btn6 = (ImageButton) findViewById(R.id.btn6);
        btn6.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.pictechnomart)));
        btn7 = (ImageButton) findViewById(R.id.btn7);
        btn7.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picmaebong)));
        btn8 = (ImageButton) findViewById(R.id.btn8);
        btn8.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.picseoulforest)));
    }

    public void btnHomeClicked(View v) {
        Intent intent = (new Intent(SceneryActivity.this, MenuActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        SceneryActivity.this.finish();

        this.onDestroy();
    }

    //전경,대표,숨은,고궁 메뉴

    public void btnmenu2Clicked(View v) {
        Intent intent = (new Intent(SceneryActivity.this, TypicalActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        SceneryActivity.this.finish();

        this.onDestroy();
    }

    public void btnmenu3Clicked(View v) {
        Intent intent = (new Intent(SceneryActivity.this, HiddenActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        SceneryActivity.this.finish();

        this.onDestroy();
    }

    public void btnmenu4Clicked(View v) {
        Intent intent = (new Intent(SceneryActivity.this, PalaceActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        SceneryActivity.this.finish();

        this.onDestroy();
    }

    //장소 버튼
    public void btn1Clicked(View v) {
        Intent intent = (new Intent(SceneryActivity.this, InNamhansan.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        SceneryActivity.this.finish();

        this.onDestroy();
    }

    public void btn2Clicked(View v) {
        Intent intent = (new Intent(SceneryActivity.this, InNamsan.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        SceneryActivity.this.finish();

        this.onDestroy();
    }

    public void btn3Clicked(View v) {
        Intent intent = (new Intent(SceneryActivity.this, InNaksan.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        SceneryActivity.this.finish();

        this.onDestroy();
    }

    public void btn4Clicked(View v) {
        Intent intent = (new Intent(SceneryActivity.this, InSkypark.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        SceneryActivity.this.finish();

        this.onDestroy();
    }

    public void btn5Clicked(View v) {
        Intent intent = (new Intent(SceneryActivity.this, InEungbong.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        SceneryActivity.this.finish();

        this.onDestroy();
    }

    public void btn6Clicked(View v) {
        Intent intent = (new Intent(SceneryActivity.this, InTechnomart.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        SceneryActivity.this.finish();

        this.onDestroy();
    }

    public void btn7Clicked(View v) {
        Intent intent = (new Intent(SceneryActivity.this, InMaebong.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_left, R.anim.hold);
        SceneryActivity.this.finish();

        this.onDestroy();
    }

    public void btn8Clicked(View v) {
        Intent intent = (new Intent(SceneryActivity.this, InSeoulforest.class));
        intent.putExtra("type", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.hold);
        SceneryActivity.this.finish();

        this.onDestroy();
    }

    //백버튼
    public void onBackPressed() {
        Intent intent = (new Intent(SceneryActivity.this, MenuActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.fade, R.anim.hold);
        SceneryActivity.this.finish();

        this.onDestroy();
    }

    @Override

    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
