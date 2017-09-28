package org.androidtown.nseoul;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapView;

public class InSeoulforestmap extends Activity {

    //다음 지도 API
    private static String API_KEY = "발급받은 API 키 입력";
    //다음 지도 마커
    private static final MapPoint MARKER_POINT  = MapPoint.mapPointWithGeoCoord(37.537901, 127.041674);
    private static final MapPoint MARKER_POINT2 = MapPoint.mapPointWithGeoCoord(37.542940, 127.044432);

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;
    public Button btnBack;

    public TextView txtType;

    //소개 페이지
    LinearLayout seoulforestmapPage;
    LinearLayout map_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inseoulforestmap);

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
        seoulforestmapPage = (LinearLayout) findViewById(R.id.seoulforestmapPage);
        seoulforestmapPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
                (getResources(), R.drawable.background4)));

        try{
            this.Viewer();
        }
        catch(Exception e) {
            Toast.makeText(this, R.string.map_error, Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
    }

    public void Viewer() {
        //다음 지도 구문
        MapView mapView = new MapView(this);
        mapView.setDaumMapApiKey(API_KEY);
        LinearLayout mapViewContainer = (LinearLayout) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        //다음 지도 중심점 변경
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.541252, 127.041901), 2, true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);

        //다음 지도 마커(명소)
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("서울숲 전망대(Seoul Forest Observatory)");
        marker.setTag(1);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker.setCustomImageResourceId(R.drawable.marker1);
        marker.setCustomImageAutoscale(false);
        marker.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker);

        //다음 지도 마커(지하철)
        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("서울숲역(Seoul Forest Station)");
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

        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.542940, 127.044432)); //1번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.541778, 127.044024)); //2번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.542248, 127.041906)); //3번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.541999, 127.041815)); //4번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.542304, 127.040691)); //5번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.541257, 127.040255)); //6번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.541161, 127.039571)); //7번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.540559, 127.039221)); //8번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.540447, 127.039501)); //9번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.540325, 127.039705)); //10번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.540188, 127.040137)); //11번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.539930, 127.040188)); //12번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.539818, 127.040283)); //13번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.539603, 127.040448)); //14번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.539363, 127.040672)); //15번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.539384, 127.041017)); //16번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.538954, 127.042247)); //18번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.537901, 127.041674)); //19번

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
            Intent intent = (new Intent(InSeoulforestmap.this, InSeoulforest.class));
            intent.putExtra("type", "1");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InSeoulforestmap.this.finish();
        }
        else if(text.compareTo(text2) == 0)
        {
            Intent intent = (new Intent(InSeoulforestmap.this, InSeoulforest.class));
            intent.putExtra("type", "2");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InSeoulforestmap.this.finish();
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
