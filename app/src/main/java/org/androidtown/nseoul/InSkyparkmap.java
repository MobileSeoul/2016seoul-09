package org.androidtown.nseoul;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.daum.mf.map.api.MapView;
import net.daum.mf.map.api.MapView.POIItemEventListener;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.CameraUpdateFactory;

public class InSkyparkmap extends Activity {

    //다음 지도 API
    private static String API_KEY = "발급받은 API 키 입력";
    //다음 지도 마커
    private static final MapPoint MARKER_POINT  = MapPoint.mapPointWithGeoCoord(37.565358, 126.886764);
    private static final MapPoint MARKER_POINT2 = MapPoint.mapPointWithGeoCoord(37.568313, 126.898931);

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;
    public Button btnBack;

    public TextView txtType;

    //소개 페이지
    LinearLayout skyparkmapPage;
    LinearLayout map_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inskyparkmap);

        //메뉴 데이터 값
        Intent i = getIntent();
        String gettype;
        gettype = i.getStringExtra("type");

        txtType = (TextView)findViewById(R.id.txtType);
        txtType.setText(gettype);

        //백버튼
        backPressCloseHandler = new BackPressCloseHandler(this);
        btnBack = (Button) findViewById(R.id.btnBack);

        //소개 페이지
        skyparkmapPage = (LinearLayout) findViewById(R.id.skyparkmapPage);
        skyparkmapPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background4)));

        try{
            this.Viewer();
        }
        catch(Exception e) {
            Toast.makeText(this, R.string.map_error, Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
    }

    public void Viewer(){
        //다음 지도 구문
        MapView mapView = new MapView(this);
        mapView.setDaumMapApiKey(API_KEY);
        LinearLayout mapViewContainer = (LinearLayout) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        //다음 지도 중심점 변경
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.566689, 126.892966), 3, true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);

        //다음 지도 마커(명소)
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("하늘공원(Sky Park)");
        marker.setTag(1);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker.setCustomImageResourceId(R.drawable.marker1);
        marker.setCustomImageAutoscale(false);
        marker.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker);

        //다음 지도 마커(지하철)
        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("월드컵공원역(Worldcup Stadium Station)");
        marker2.setTag(1);
        marker2.setMapPoint(MARKER_POINT2);
        marker2.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker2.setCustomImageResourceId(R.drawable.marker2);
        marker2.setCustomImageAutoscale(false);
        marker2.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker2);

        //다음 지도 길안내
        MapPolyline polyline = new MapPolyline();
        polyline.setTag(1000);
        polyline.setLineColor(Color.argb(128, 255, 0, 0)); // Polyline 컬러 지정.

        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.568313, 126.898931)); //1번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.568082, 126.898914)); //2번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.567699, 126.898785)); //3번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.567245, 126.898380)); //4번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.567094, 126.897875)); //5번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566787, 126.897538)); //6번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566497, 126.897432)); //7번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566978, 126.895354)); //8번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566666, 126.895102)); //9번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566689, 126.895006)); //10번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566586, 126.894939)); //11번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566368, 126.893384)); //12번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566017, 126.893092)); //13번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566244, 126.892626)); //14번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.565447, 126.891913)); //15번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.565732, 126.891413)); //16번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.565959, 126.891082)); //17번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.565865, 126.890846)); //18번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566079, 126.890930)); //19번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566003, 126.890706)); //20번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566144, 126.890762)); //21번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566046, 126.890582)); //22번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566241, 126.890608)); //23번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566145, 126.890386)); //24번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566315, 126.890357)); //25번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566194, 126.890159)); //26번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566313, 126.890159)); //27번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566334, 126.890075)); //28번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566451, 126.890089)); //29번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.567144, 126.889582)); //30번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.568066, 126.888777)); //31번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.568464, 126.888458)); //32번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.568183, 126.888445)); //33번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.568853, 126.888005)); //34번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.569102, 126.887654)); //35번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.569174, 126.887136)); //36번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.567048, 126.888352)); //37번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.566825, 126.888340)); //38번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.565448, 126.886968)); //39번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.565358, 126.886764)); //40번

        mapView.addPolyline(polyline);
        MapPointBounds mapPointBounds = new MapPointBounds(polyline.getMapPoints());
        int padding = 100; // px
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

        if(text.compareTo(text1) == 0)
        {
            Intent intent = (new Intent(InSkyparkmap.this, InSkypark.class));
            intent.putExtra("type", "1");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InSkyparkmap.this.finish();
        }
        else if(text.compareTo(text2) == 0)
        {
            Intent intent = (new Intent(InSkyparkmap.this, InSkypark.class));
            intent.putExtra("type", "2");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InSkyparkmap.this.finish();
        }

        this.onDestroy();
    }

    @Override
    public void onDestroy() {
        RecycleUtils.recursiveRecycle(getWindow().getDecorView());
        System.gc();

        super.onDestroy();
    }
}
