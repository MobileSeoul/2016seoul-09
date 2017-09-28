package org.androidtown.nseoul;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private BackPressCloseHandler backPressCloseHandler;

    //메인 페이지
    LinearLayout layoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //메뉴 페이지
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);
        layoutMain.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background2)));

        //Back 버튼 누를시 toast 보이기 선언
        backPressCloseHandler = new BackPressCloseHandler(this);

        //텍스트 애니메이션 효과
        TextView txtstart = (TextView)findViewById(R.id.txtStart);

        AnimationSet set = new AnimationSet(true);
        set.setInterpolator(new AccelerateInterpolator());
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(2000);
        set.addAnimation(animation);

        txtstart.setAnimation(animation);

        //화면 터치 시 화면 전환
        LinearLayout main = (LinearLayout) findViewById(R.id.layoutMain);
        main.setOnClickListener(new LinearLayout.OnClickListener(){
            public void onClick(View v){
                Intent intent = (new Intent(MainActivity.this, MenuActivity.class));
                startActivity(intent);
                overridePendingTransition(R.anim.fade, R.anim.hold);
                MainActivity.this.finish();
            }
        });
    }

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
