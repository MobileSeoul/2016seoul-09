package org.androidtown.nseoul;

import android.Manifest.permission;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class InDdp extends Activity {

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;

    //소개 페이지
    LinearLayout ddpPage;

    public Button btnBack, btnBus, btn01, btn02, btn03, btn04, btnweather, btnmap, btnkor, btneng;
    public ImageView imageview, imageview2, imageview3, imageview4;
    public TextView txtType;

    //위치 권한 퍼미션
    private static final int REQUEST_CODE_LOCATION = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inddp);

        //메뉴 데이터 값
        Intent i = getIntent();
        String gettype;
        gettype = i.getStringExtra("type");

        txtType = (TextView)findViewById(R.id.txtType);
        txtType.setText(gettype);

        //백버튼
        backPressCloseHandler = new BackPressCloseHandler(this);

        //소개 페이지
        ddpPage = (LinearLayout) findViewById(R.id.ddpPage);
        ddpPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background4)));

        btnBack = (Button) findViewById(R.id.btnBack);

        btnBus = (Button) findViewById(R.id.btnBus);
        btnBus.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.citytour3)));

        imageview = (ImageView) findViewById(R.id.imageview);
        imageview.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddp1)));
        imageview2 = (ImageView) findViewById(R.id.imageview2);
        imageview2.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddpname)));
        imageview3 = (ImageView) findViewById(R.id.imageview3);
        imageview3.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddpinfo)));
        imageview4 = (ImageView) findViewById(R.id.imageview4);
        imageview4.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddpsub)));

        btn01 = (Button) findViewById(R.id.btn01);
        btn01.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddp1)));
        btn02 = (Button) findViewById(R.id.btn02);
        btn02.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddp2)));
        btn03 = (Button) findViewById(R.id.btn03);
        btn03.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddp3)));
        btn04 = (Button) findViewById(R.id.btn04);
        btn04.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddp4)));

        btnweather = (Button) findViewById(R.id.btnweather);
        btnweather.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.weather)));
        btnmap = (Button) findViewById(R.id.btnmap);
        btnmap.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.map)));
        btnkor = (Button) findViewById(R.id.btnkor);
        btnkor.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.flagkorea)));
        btneng = (Button) findViewById(R.id.btneng);
        btneng.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.flagusa)));
    }

    //버스시티투어
    public void btnBusClicked(View v) {
        String text = txtType.getText().toString().trim();

        String text5 = "5";

        if(text.compareTo(text5) == 0)
        {
            Intent intent = (new Intent(InDdp.this, Citytour3.class));
            intent.putExtra("type", "5");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InDdp.this.finish();
        }
        else{
            Intent intent = (new Intent(InDdp.this, Citytour3.class));
            intent.putExtra("type", "5");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InDdp.this.finish();
        }

        this.onDestroy();
    }

    //백버튼
    public void onBackPressed() {
        this.Back();
    }

    public void btnBackClicked(View v) {
        this.Back();
    }

    public void Back(){
        String text = txtType.getText().toString().trim();

        String text1 = "1";
        String text2 = "2";
        String text5 = "5";

        if(text.compareTo(text1) == 0)
        {
            Intent intent = (new Intent(InDdp.this, TypicalActivity.class));
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.out_to_right);
            InDdp.this.finish();
        }
        else if(text.compareTo(text2) == 0)
        {
            Intent intent = (new Intent(InDdp.this, MenueastActivity.class));
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.out_to_left);
            InDdp.this.finish();
        }
        else if(text.compareTo(text5) == 0)
        {
            Intent intent = (new Intent(InDdp.this, Citytour3.class));
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.out_to_left);
            InDdp.this.finish();
        }
        else{
            Toast.makeText(this, "이전화면 돌아가기 ERROR", Toast.LENGTH_SHORT).show();
            Intent intent = (new Intent(InDdp.this, MenuActivity.class));
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InDdp.this.finish();
        }

        this.onDestroy();
    }

    public void btn01Clicked(View v) {
        imageview.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddp1)));
    }

    public void btn02Clicked(View v) {
        imageview.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddp2)));
    }

    public void btn03Clicked(View v) {
        imageview.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddp3)));
    }

    public void btn04Clicked(View v) {
        imageview.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddp4)));
    }

    public void btnweatherClicked(View v) {
        //네트워크 연결 true
        if (isNetWork() == true) {
            String text = txtType.getText().toString().trim();

            String text1 = "1";
            String text2 = "2";
            String text5 = "5";

            if(text.compareTo(text1) == 0)
            {
                Intent intent = (new Intent(InDdp.this, InDdpnal.class));
                intent.putExtra("type", "1");
                startActivity(intent);
                overridePendingTransition(R.anim.fade, R.anim.hold);
                InDdp.this.finish();
            }
            else if(text.compareTo(text2) == 0)
            {
                Intent intent = (new Intent(InDdp.this, InDdpnal.class));
                intent.putExtra("type", "2");
                startActivity(intent);
                overridePendingTransition(R.anim.fade, R.anim.hold);
                InDdp.this.finish();
            }
            else if(text.compareTo(text5) == 0)
            {
                Intent intent = (new Intent(InDdp.this, InDdpnal.class));
                intent.putExtra("type", "5");
                startActivity(intent);
                overridePendingTransition(R.anim.fade, R.anim.hold);
                InDdp.this.finish();
            }

            this.onDestroy();
        }
        //네트워크 연결 false
        else {
            Toast.makeText(this, R.string.wifi_error, Toast.LENGTH_SHORT).show();
        }
    }

    public void btnmapClicked(View v) {
        //네트워크 연결 true
        if (isNetWork() == true) {
            //안드로이드 6.0 이상 권한체크 확인
            if(Build.VERSION.SDK_INT >=23) {
                checkPermission();
            } //6.0 이하는 맵 액티비티
            else {
                OpenMap();
            }
        }
        //네트워크 연결 false
        else {
            Toast.makeText(this, R.string.wifi_error, Toast.LENGTH_SHORT).show();
        }
    }

    //네트워크 연결 여부
    private Boolean isNetWork(){
        ConnectivityManager manager = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);
        boolean isMobileAvailable = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isAvailable();
        boolean isMobileConnect = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
        boolean isWifiAvailable = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isAvailable();
        boolean isWifiConnect = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();

        if ((isWifiAvailable && isWifiConnect) || (isMobileAvailable && isMobileConnect)){
            return true;
        }else{
            return false;
        }
    }

    /*-----------------------------------------------------------------------------------------------*/
    /*---------------------------- 안드로이드 6.0 마시멜로 이상 버젼 권한 기능 ----------------------------*/
    /*-----------------------------------------------------------------------------------------------*/
    private void checkPermission(){
        //권한이 없는 경우
        if(ActivityCompat.checkSelfPermission(this, permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            //최초 거부를 선택하면 두번째부터 이벤트 발생 & 권한 획득이 필요한 이유를 설명
            if (shouldShowRequestPermissionRationale(permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(this, R.string.location1, Toast.LENGTH_SHORT).show();
            }

            //요청 팝업 팝업 선택시 onRequestPermissionsResult 이동
            requestPermissions(new String[]{permission.ACCESS_FINE_LOCATION},
                    REQUEST_CODE_LOCATION);
        }
        //권한이 있는 경우 맵 액티비티
        else{
            OpenMap();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_LOCATION:
                //권한이 있는 경우 맵 액티비티
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    OpenMap();
                }
                //권한이 없는 경우 토스트
                else {
                    Toast.makeText(this, R.string.location2, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------*/

    public void OpenMap(){
        String text = txtType.getText().toString().trim();

        String text1 = "1";
        String text2 = "2";
        String text5 = "5";

        if(text.compareTo(text1) == 0)
        {
            Intent intent = (new Intent(InDdp.this, InDdpmap.class));
            intent.putExtra("type", "1");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InDdp.this.finish();
        }
        else if(text.compareTo(text2) == 0)
        {
            Intent intent = (new Intent(InDdp.this, InDdpmap.class));
            intent.putExtra("type", "2");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InDdp.this.finish();
        }
        else if(text.compareTo(text5) == 0)
        {
            Intent intent = (new Intent(InDdp.this, InDdpmap.class));
            intent.putExtra("type", "5");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InDdp.this.finish();
        }

        this.onDestroy();
    }

    public void btnkorClicked(View v) {
        imageview3.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddpinfo)));
        imageview4.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddpsub)));
    }

    public void btnengClicked(View v) {
        imageview3.setImageDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddpinfo2)));
        imageview4.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.ddpsub2)));
    }

    @Override
    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
