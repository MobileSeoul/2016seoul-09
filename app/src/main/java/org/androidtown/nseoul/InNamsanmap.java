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

public class InNamsanmap extends Activity {

    //다음 지도 API
    private static String API_KEY = "발급받은 API 키 입력";
    //다음 지도 마커
    private static final MapPoint MARKER_POINT  = MapPoint.mapPointWithGeoCoord(37.558327, 127.005409);
    private static final MapPoint MARKER_POINT2 = MapPoint.mapPointWithGeoCoord(37.558898, 127.005019);
    private static final MapPoint MARKER_POINT3 = MapPoint.mapPointWithGeoCoord(37.556650, 126.984096);
    private static final MapPoint MARKER_POINT4 = MapPoint.mapPointWithGeoCoord(37.560750, 126.985460);

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;
    public Button btnBack;

    public TextView txtType;

    //소개 페이지
    LinearLayout namsanmapPage;
    LinearLayout map_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innamsanmap);

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
        namsanmapPage = (LinearLayout) findViewById(R.id.namsanmapPage);
        namsanmapPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
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
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.558307, 126.994448), 4, true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);

        /*-----------------------------------------------------------------------------------------------*/
        /*------------------------------------------- 버스 -----------------------------------------------*/
        /*-----------------------------------------------------------------------------------------------*/

        //다음 지도 마커(명소)
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("남산 버스 정류장(Bus Stop)");
        marker.setTag(1);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker.setCustomImageResourceId(R.drawable.marker1);
        marker.setCustomImageAutoscale(false);
        marker.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker);

        //다음 지도 마커(지하철)
        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("동대입구역(Dongguk University Station)");
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

        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.558898, 127.005019)); //1번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.558916, 127.005434)); //2번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.558869, 127.005561)); //3번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.558690, 127.005615)); //4번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.558327, 127.005409)); //5번

        mapView.addPolyline(polyline);
        MapPointBounds mapPointBounds = new MapPointBounds(polyline.getMapPoints());
        int padding = 100; // px

        /*-----------------------------------------------------------------------------------------------*/
        /*----------------------------------------- 케이블카 ---------------------------------------------*/
        /*-----------------------------------------------------------------------------------------------*/

        //다음 지도 마커(명소)
        MapPOIItem marker3 = new MapPOIItem();
        marker3.setItemName("케이블카(Cable Car)");
        marker3.setTag(1);
        marker3.setMapPoint(MARKER_POINT3);
        marker3.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker3.setCustomImageResourceId(R.drawable.marker1);
        marker3.setCustomImageAutoscale(false);
        marker3.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker3);

        //다음 지도 마커(지하철)
        MapPOIItem marker4 = new MapPOIItem();
        marker4.setItemName("명동역(Myeong-Dong Station)");
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

        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.560750, 126.985460)); //1번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.560744, 126.985344)); //2번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.560692, 126.985375)); //3번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.560588, 126.985549)); //4번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.560114, 126.985491)); //5번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.559997, 126.985278)); //6번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.559541, 126.985070)); //7번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.559075, 126.984765)); //8번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.558852, 126.984645)); //9번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.558536, 126.984571)); //10번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.558533, 126.984452)); //11번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.558080, 126.984432)); //12번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.557725, 126.984521)); //13번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.557364, 126.984517)); //14번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.556895, 126.984363)); //15번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.556745, 126.984355)); //16번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.556650, 126.984096)); //17번

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
        String text3 = "3";
        String text4 = "4";

        if(text.compareTo(text1) == 0)
        {
            Intent intent = (new Intent(InNamsanmap.this, InNamsan.class));
            intent.putExtra("type", "1");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InNamsanmap.this.finish();
        }
        else if(text.compareTo(text2) == 0)
        {
            Intent intent = (new Intent(InNamsanmap.this, InNamsan.class));
            intent.putExtra("type", "2");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InNamsanmap.this.finish();
        }
        else if(text.compareTo(text3) == 0)
        {
            Intent intent = (new Intent(InNamsanmap.this, InNamsan.class));
            intent.putExtra("type", "3");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InNamsanmap.this.finish();
        }
        else if(text.compareTo(text4) == 0)
        {
            Intent intent = (new Intent(InNamsanmap.this, InNamsan.class));
            intent.putExtra("type", "4");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InNamsanmap.this.finish();
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
