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

public class InSeongsanmap extends Activity {

    //다음 지도 API
    private static String API_KEY = "발급받은 API 키 입력";
    //다음 지도 마커
    private static final MapPoint MARKER_POINT  = MapPoint.mapPointWithGeoCoord(37.548330, 126.888285);
    private static final MapPoint MARKER_POINT2 = MapPoint.mapPointWithGeoCoord(37.538243, 126.894063);
    private static final MapPoint MARKER_POINT3 = MapPoint.mapPointWithGeoCoord(37.556956, 126.893829);
    private static final MapPoint MARKER_POINT4 = MapPoint.mapPointWithGeoCoord(37.562931, 126.903185);

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;
    public Button btnBack;

    public TextView txtType;

    //소개 페이지
    LinearLayout seongsanmapPage;
    LinearLayout map_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inseongsanmap);

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
        seongsanmapPage = (LinearLayout) findViewById(R.id.seongsanmapPage);
        seongsanmapPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
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
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.549536, 126.895913), 4, true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);

        /*-----------------------------------------------------------------------------------------------*/
        /*--------------------------------------- 성산대교 남단 -------------------------------------------*/
        /*-----------------------------------------------------------------------------------------------*/

        //다음 지도 마커(명소)
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("성산대교 남단(Southern Extremity)");
        marker.setTag(1);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker.setCustomImageResourceId(R.drawable.marker1);
        marker.setCustomImageAutoscale(false);
        marker.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker);

        //다음 지도 마커(지하철)
        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("선유도역(Seonyudo Station)");
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

        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.538243, 126.894063)); //1번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.538340, 126.894135)); //2번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.538930, 126.892968)); //3번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.539281, 126.893193)); //4번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.541033, 126.889806)); //5번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.543718, 126.888503)); //6번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.544355, 126.888971)); //7번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.544579, 126.888498)); //8번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.545709, 126.889573)); //9번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.545621, 126.889721)); //10번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.546010, 126.890706)); //11번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.547119, 126.889897)); //12번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.548001, 126.888758)); //13번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.548330, 126.888285)); //14번

        mapView.addPolyline(polyline);
        MapPointBounds mapPointBounds = new MapPointBounds(polyline.getMapPoints());
        int padding = 100; // px

        /*-----------------------------------------------------------------------------------------------*/
        /*--------------------------------------- 성산대교 북단 -------------------------------------------*/
        /*-----------------------------------------------------------------------------------------------*/

        //다음 지도 마커(명소)
        MapPOIItem marker3 = new MapPOIItem();
        marker3.setItemName("성산대교 북단(Northern Extremity)");
        marker3.setTag(1);
        marker3.setMapPoint(MARKER_POINT3);
        marker3.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker3.setCustomImageResourceId(R.drawable.marker1);
        marker3.setCustomImageAutoscale(false);
        marker3.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker3);

        //다음 지도 마커(지하철)
        MapPOIItem marker4 = new MapPOIItem();
        marker4.setItemName("마포구청역(Mapo-gu Office Station)");
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

        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.562931, 126.903185)); //1번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.562592, 126.90209 )); //2번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.562565, 126.901444)); //3번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.562543, 126.901192)); //4번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.562062, 126.900119)); //5번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.559494, 126.893813)); //6번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.558831, 126.893105)); //7번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.558145, 126.892953)); //8번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.557215, 126.893874)); //9번
        polyline2.addPoint(MapPoint.mapPointWithGeoCoord(37.556956, 126.893829)); //10번

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
            Intent intent = (new Intent(InSeongsanmap.this, InSeongsan.class));
            intent.putExtra("type", "1");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InSeongsanmap.this.finish();
        }
        else if(text.compareTo(text2) == 0)
        {
            Intent intent = (new Intent(InSeongsanmap.this, InSeongsan.class));
            intent.putExtra("type", "2");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InSeongsanmap.this.finish();
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
