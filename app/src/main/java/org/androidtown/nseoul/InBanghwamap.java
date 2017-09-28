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

public class InBanghwamap extends Activity {

    //다음 지도 API
    private static String API_KEY = "발급받은 API 키 입력";
    //다음 지도 마커
    private static final MapPoint MARKER_POINT  = MapPoint.mapPointWithGeoCoord(37.584801, 126.821056);
    private static final MapPoint MARKER_POINT2 = MapPoint.mapPointWithGeoCoord(37.57704 , 126.812719);

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;
    public Button btnBack;

    public TextView txtType;

    //소개 페이지
    LinearLayout banghwamapPage;
    LinearLayout map_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbanghwamap);

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
        banghwamapPage = (LinearLayout) findViewById(R.id.banghwamapPage);
        banghwamapPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
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
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.58097, 126.816954), 3, true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);

        //다음 지도 마커(명소)
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("방화대교(Banghwa Bridge)");
        marker.setTag(1);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker.setCustomImageResourceId(R.drawable.marker1);
        marker.setCustomImageAutoscale(false);
        marker.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker);

        //다음 지도 마커(지하철)
        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("방화역(Banghwa Station)");
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

        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.577040, 126.812719)); //1번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.576266, 126.812395)); //2번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.576281, 126.816499)); //3번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.576284, 126.817026)); //4번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.576126, 126.818217)); //5번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.576547, 126.818205)); //6번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.576611, 126.818088)); //7번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.577004, 126.818239)); //8번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.577209, 126.818356)); //9번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.577320, 126.818334)); //10번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.577448, 126.818402)); //11번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.577721, 126.818719)); //12번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.577820, 126.818939)); //13번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.577991, 126.818935)); //14번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.578005, 126.819149)); //15번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.578490, 126.819119)); //16번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.579010, 126.819802)); //17번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.579440, 126.820091)); //18번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.579887, 126.819706)); //19번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581739, 126.819722)); //20번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.582149, 126.819560)); //21번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.582794, 126.818760)); //22번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.583240, 126.818495)); //23번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.583856, 126.818733)); //24번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.584279, 126.818993)); //25번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.585040, 126.819631)); //26번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.585027, 126.820086)); //27번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.584855, 126.820676)); //28번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.584801, 126.821056)); //29번

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
            Intent intent = (new Intent(InBanghwamap.this, InBanghwa.class));
            intent.putExtra("type", "1");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InBanghwamap.this.finish();
        }
        else if(text.compareTo(text2) == 0)
        {
            Intent intent = (new Intent(InBanghwamap.this, InBanghwa.class));
            intent.putExtra("type", "2");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InBanghwamap.this.finish();
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
