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

public class InChihyunjungmap extends Activity {

    //다음 지도 API
    private static String API_KEY = "발급받은 API 키 입력";
    //다음 지도 마커
    private static final MapPoint MARKER_POINT  = MapPoint.mapPointWithGeoCoord(37.582366, 126.81738);
    private static final MapPoint MARKER_POINT2 = MapPoint.mapPointWithGeoCoord(37.57704, 126.812719);

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;
    public Button btnBack;

    public TextView txtType;

    //소개 페이지
    LinearLayout chihyunjungmapPage;
    LinearLayout map_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inchihyunjungmap);

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
        chihyunjungmapPage = (LinearLayout) findViewById(R.id.chihyunjungmapPage);
        chihyunjungmapPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
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
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.58013, 126.814729), 2, true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);

        //다음 지도 마커(명소)
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("치현정(Chihyunjung)");
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
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.580693, 126.814051)); //2번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.580905, 126.813917)); //3번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581070, 126.814129)); //4번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581090, 126.814551)); //5번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581125, 126.814692)); //6번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581205, 126.814768)); //7번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581567, 126.814951)); //8번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581698, 126.814906)); //9번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581834, 126.815155)); //10번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581828, 126.815233)); //11번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581872, 126.815303)); //12번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.582142, 126.815459)); //13번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.582125, 126.815544)); //14번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.582065, 126.815641)); //15번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581987, 126.815724)); //16번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581970, 126.815885)); //17번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581985, 126.815955)); //18번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581857, 126.816232)); //19번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581758, 126.816545)); //20번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581615, 126.816629)); //21번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581289, 126.816599)); //22번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581332, 126.816782)); //23번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581473, 126.816772)); //24번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581515, 126.816782)); //25번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581711, 126.816922)); //26번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581749, 126.817002)); //27번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.581974, 126.817185)); //28번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.582017, 126.817185)); //29번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.582174, 126.817217)); //30번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.582337, 126.817374)); //31번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.582366, 126.817380)); //32번

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
            Intent intent = (new Intent(InChihyunjungmap.this, InChihyunjung.class));
            intent.putExtra("type", "1");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InChihyunjungmap.this.finish();
        }
        else if(text.compareTo(text2) == 0)
        {
            Intent intent = (new Intent(InChihyunjungmap.this, InChihyunjung.class));
            intent.putExtra("type", "2");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InChihyunjungmap.this.finish();
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
