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

public class InGwangnarumap extends Activity {

    //다음 지도 API
    private static String API_KEY = "발급받은 API 키 입력";
    //다음 지도 마커
    private static final MapPoint MARKER_POINT  = MapPoint.mapPointWithGeoCoord(37.529621, 127.107355);
    private static final MapPoint MARKER_POINT2 = MapPoint.mapPointWithGeoCoord(37.521123, 127.103751);

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;
    public Button btnBack;

    public TextView txtType;

    //소개 페이지
    LinearLayout gwangnarumapPage;
    LinearLayout map_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingwangnarumap);

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
        gwangnarumapPage = (LinearLayout) findViewById(R.id.gwangnarumapPage);
        gwangnarumapPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
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
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.525749, 127.104866), 3, true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);

        //다음 지도 마커(명소)
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("광나루한강공원(Gwangnaru Hangang Park)");
        marker.setTag(1);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker.setCustomImageResourceId(R.drawable.marker1);
        marker.setCustomImageAutoscale(false);
        marker.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker);

        //다음 지도 마커(지하철)
        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("잠실나루역(Jamsilnaru Station)");
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

        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.521123, 127.103751)); //1번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.521491, 127.103793)); //2번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.521613, 127.103793)); //3번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.521771, 127.103774)); //4번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.521901, 127.103700)); //5번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.522066, 127.104215)); //6번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.523007, 127.104155)); //7번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.523176, 127.104328)); //8번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.523208, 127.104734)); //9번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.523475, 127.104784)); //10번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.523532, 127.103987)); //11번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.524225, 127.103671)); //12번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.524529, 127.102945)); //13번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.527188, 127.105837)); //14번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.527592, 127.105228)); //15번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.529621, 127.107355)); //16번

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
            Intent intent = (new Intent(InGwangnarumap.this, InGwangnaru.class));
            intent.putExtra("type", "1");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InGwangnarumap.this.finish();
        }
        else if(text.compareTo(text2) == 0)
        {
            Intent intent = (new Intent(InGwangnarumap.this, InGwangnaru.class));
            intent.putExtra("type", "2");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InGwangnarumap.this.finish();
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