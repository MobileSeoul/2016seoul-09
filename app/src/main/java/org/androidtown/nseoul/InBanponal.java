package org.androidtown.nseoul;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InBanponal extends Activity {

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;
    public Button btnBack;

    public TextView txtType;

    //소개 페이지
    LinearLayout banponalPage;

    public WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbanponal);

        //백버튼
        backPressCloseHandler = new BackPressCloseHandler(this);
        btnBack = (Button) findViewById(R.id.btnBack);

        //메뉴 데이터 값
        Intent i = getIntent();
        String gettype;
        gettype = i.getStringExtra("type");

        txtType = (TextView)findViewById(R.id.txtType);
        txtType.setText(gettype);

        //소개 페이지
        banponalPage = (LinearLayout) findViewById(R.id.banponalPage);
        banponalPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background4)));

        //웹뷰
        webview = (WebView)findViewById(R.id.webview);
        webview.setWebViewClient(new WebClient()); // 응용프로그램에서 직접 url 처리
        WebSettings set = webview.getSettings();
        set.setJavaScriptEnabled(true);
        set.setBuiltInZoomControls(true);
        webview.loadUrl("https://www.google.com/#q=seoul+banpo+dong+weather");
    }

    //백버튼
    public void onBackPressed() {
        this.Back();
    }

    public void btnBackClicked(View v) {
        this.Back();
    }


    public void Back() {
        String text = txtType.getText().toString().trim();

        String text1 = "1";
        String text2 = "2";
        String text4 = "4";

        if(text.compareTo(text1) == 0)
        {
            Intent intent = (new Intent(InBanponal.this, InBanpo.class));
            intent.putExtra("type", "1");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InBanponal.this.finish();
        }
        else if(text.compareTo(text2) == 0)
        {
            Intent intent = (new Intent(InBanponal.this, InBanpo.class));
            intent.putExtra("type", "2");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InBanponal.this.finish();
        }
        else if(text.compareTo(text4) == 0)
        {
            Intent intent = (new Intent(InBanponal.this, InBanpo.class));
            intent.putExtra("type", "4");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InBanponal.this.finish();
        }

        this.onDestroy();
    }

    class WebClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
