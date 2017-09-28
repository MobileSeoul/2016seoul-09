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

public class InPeacegatemap extends Activity {

    //다음 지도 API
    private static String API_KEY = "발급받은 API 키 입력";
    //다음 지도 마커
    private static final MapPoint MARKER_POINT  = MapPoint.mapPointWithGeoCoord(37.512731, 127.128058);
    private static final MapPoint MARKER_POINT2 = MapPoint.mapPointWithGeoCoord(37.516630, 127.130836);
    private static final MapPoint MARKER_POINT3 = MapPoint.mapPointWithGeoCoord(37.518015, 127.114359);
    private static final MapPoint MARKER_POINT4 = MapPoint.mapPointWithGeoCoord(37.517717, 127.113262);

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;
    public Button btnBack;

    public TextView txtType;

    //소개 페이지
    LinearLayout peacegatemapPage;
    LinearLayout map_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inpeacegatemap);

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
        peacegatemapPage = (LinearLayout) findViewById(R.id.peacegatemapPage);
        peacegatemapPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
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
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.515765, 127.12139), 4, true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);

        /*-----------------------------------------------------------------------------------------------*/
        /*------------------------------------------ 장미 광장 -------------------------------------------*/
        /*-----------------------------------------------------------------------------------------------*/

        //다음 지도 마커(명소)
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("장미 광장(Rose Plaza)");
        marker.setTag(1);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker.setCustomImageResourceId(R.drawable.marker1);
        marker.setCustomImageAutoscale(false);
        marker.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker);

        //다음 지도 마커(지하철)
        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("올림픽공원역(Olympic Park Station)");
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

        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.51663 , 127.130836)); //1번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.516611, 127.130961)); //2번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.512669, 127.12832 )); //3번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.512731, 127.128058)); //4번

        mapView.addPolyline(polyline);
        MapPointBounds mapPointBounds = new MapPointBounds(polyline.getMapPoints());
        int padding = 100; // px

        /*-----------------------------------------------------------------------------------------------*/
        /*---------------------------------------- 평화의 광장 -------------------------------------------*/
        /*-----------------------------------------------------------------------------------------------*/

        //다음 지도 마커(명소)
        MapPOIItem marker3 = new MapPOIItem();
        marker3.setItemName("평화의 광장(Peace Plaza)");
        marker3.setTag(1);
        marker3.setMapPoint(MARKER_POINT3);
        marker3.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker3.setCustomImageResourceId(R.drawable.marker1);
        marker3.setCustomImageAutoscale(false);
        marker3.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker3);

        //다음 지도 마커(지하철)
        MapPOIItem marker4 = new MapPOIItem();
        marker4.setItemName("몽촌토성역(Mongchontoseong Station)");
        marker4.setTag(1);
        marker4.setMapPoint(MARKER_POINT4);
        marker4.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker4.setCustomImageResourceId(R.drawable.marker2);
        marker4.setCustomImageAutoscale(false);
        marker4.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker4);

        //다음 지도 길안내
        MapPolyline polyline2 = new MapPolyline();
        polyline2.setTag(1000);
        polyline2.setLineColor(Color.argb(128, 255, 0, 0)); // Polyline 컬러 지정.

        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.517717, 127.113262)); //1번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.518015, 127.114359)); //2번

        mapView.addPolyline(polyline2);
        MapPointBounds mapPointBounds2 = new MapPointBounds(polyline2.getMapPoints());
        int padding2 = 100; // px
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
            Intent intent = (new Intent(InPeacegatemap.this, InPeacegate.class));
            intent.putExtra("type", "1");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InPeacegatemap.this.finish();
        }
        else if(text.compareTo(text2) == 0)
        {
            Intent intent = (new Intent(InPeacegatemap.this, InPeacegate.class));
            intent.putExtra("type", "2");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InPeacegatemap.this.finish();
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
