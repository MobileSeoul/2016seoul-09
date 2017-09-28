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

public class InMaebongmap extends Activity {

    //다음 지도 API
    private static String API_KEY = "발급받은 API 키 입력";
    //다음 지도 마커
    private static final MapPoint MARKER_POINT  = MapPoint.mapPointWithGeoCoord(37.544485, 127.008819);
    private static final MapPoint MARKER_POINT2 = MapPoint.mapPointWithGeoCoord(37.547898, 127.007057);

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;
    public Button btnBack;

    public TextView txtType;

    //소개 페이지
    LinearLayout maebongmapPage;
    LinearLayout map_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inmaebongmap);

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
        maebongmapPage = (LinearLayout) findViewById(R.id.maebongmapPage);
        maebongmapPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
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
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.546135, 127.00722), 1, true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);

        //다음 지도 마커(명소)
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("매봉산(Maebong Mountain)");
        marker.setTag(1);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker.setCustomImageResourceId(R.drawable.marker1);
        marker.setCustomImageAutoscale(false);
        marker.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker);

        //다음 지도 마커(지하철)
        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("버티고개역(Beotigogae Station)");
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

        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.547898, 127.007057)); //1번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.547794, 127.006858)); //2번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.547433, 127.006962)); //3번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.547272, 127.007208)); //4번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.547243, 127.007360)); //5번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.547815, 127.008082)); //6번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.547541, 127.008453)); //7번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.547276, 127.008411)); //8번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.546583, 127.007491)); //9번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.546550, 127.006999)); //10번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.546409, 127.007067)); //11번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.546372, 127.007606)); //12번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.546280, 127.007700)); //13번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.546181, 127.007637)); //14번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.546164, 127.007355)); //15번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.546036, 127.007193)); //16번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.545832, 127.007213)); //17번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.545799, 127.007899)); //18번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.545662, 127.007789)); //19번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.545613, 127.007234)); //20번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.545492, 127.007224)); //21번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.545517, 127.007799)); //22번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.545845, 127.008328)); //23번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.546438, 127.008600)); //24번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.546206, 127.008704)); //25번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.546073, 127.008673)); //26번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.545882, 127.008610)); //27번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.545712, 127.008615)); //28번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.545032, 127.008160)); //29번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.544775, 127.008312)); //30번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.544563, 127.008343)); //31번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.544568, 127.008579)); //32번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.544485, 127.008819)); //33번


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
            Intent intent = (new Intent(InMaebongmap.this, InMaebong.class));
            intent.putExtra("type", "1");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InMaebongmap.this.finish();
        }
        else if(text.compareTo(text2) == 0)
        {
            Intent intent = (new Intent(InMaebongmap.this, InMaebong.class));
            intent.putExtra("type", "2");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InMaebongmap.this.finish();
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
