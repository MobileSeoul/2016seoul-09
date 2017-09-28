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

public class InNamhansanmap extends Activity {

    //다음 지도 API
    private static String API_KEY = "발급받은 API 키 입력";
    //다음 지도 마커
    private static final MapPoint MARKER_POINT  = MapPoint.mapPointWithGeoCoord(37.48469, 127.176061 );
    private static final MapPoint MARKER_POINT2 = MapPoint.mapPointWithGeoCoord(37.495384, 127.153305);

    //백버튼
    private BackPressCloseHandler backPressCloseHandler;
    public Button btnBack;

    public TextView txtType;

    //소개 페이지
    LinearLayout namhansanmapPage;
    LinearLayout map_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innamhansanmap);

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
        namhansanmapPage = (LinearLayout) findViewById(R.id.namhansanmapPage);
        namhansanmapPage.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource
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
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.490091, 127.163589), 3, true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);

        //다음 지도 마커(명소)
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("남한산성(Namhansanseong)");
        marker.setTag(1);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        marker.setCustomImageResourceId(R.drawable.marker1);
        marker.setCustomImageAutoscale(false);
        marker.setCustomImageAnchor(0.5f, 1.0f);
        mapView.addPOIItem(marker);

        //다음 지도 마커(지하철)
        MapPOIItem marker2 = new MapPOIItem();
        marker2.setItemName("마천역(Macheon Station)");
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

        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.495384, 127.153305)); //1번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.496030, 127.154281)); //2번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.495411, 127.154507)); //3번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.494438, 127.155360)); //4번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.491899, 127.156573)); //5번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.491087, 127.157229)); //6번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.491139, 127.157322)); //7번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.491013, 127.157355)); //8번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.490926, 127.157666)); //9번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.490691, 127.157998)); //10번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.489906, 127.158455)); //11번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.489555, 127.158793)); //12번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.489327, 127.159132)); //13번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.489051, 127.159436)); //14번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.488971, 127.159600)); //15번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.488691, 127.159995)); //16번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.488548, 127.160570)); //17번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.488288, 127.160984)); //18번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.488056, 127.161238)); //19번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487888, 127.161706)); //20번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487519, 127.162670)); //21번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487309, 127.162941)); //22번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487293, 127.163412)); //23번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487212, 127.163528)); //24번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487154, 127.163826)); //25번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.486653, 127.164633)); //26번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.486557, 127.165242)); //27번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.486501, 127.166088)); //28번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.486474, 127.166311)); //29번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.486519, 127.166406)); //30번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.486501, 127.166449)); //31번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487333, 127.169000)); //32번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487547, 127.169262)); //33번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487724, 127.169932)); //34번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487681, 127.170001)); //35번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487699, 127.171009)); //36번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487620, 127.171587)); //37번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487681, 127.171956)); //38번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487602, 127.172049)); //39번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487492, 127.172449)); //40번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487516, 127.172541)); //41번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.487028, 127.173742)); //42번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.486728, 127.174073)); //43번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.486453, 127.174227)); //44번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.485910, 127.174912)); //46번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.485898, 127.174966)); //47번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.485531, 127.175359)); //48번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.485384, 127.175528)); //49번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.485268, 127.175820)); //50번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.485067, 127.175867)); //51번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.484945, 127.175936)); //52번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.484870, 127.175994)); //53번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.484702, 127.175943)); //54번
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.484690, 127.176061)); //55번

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
            Intent intent = (new Intent(InNamhansanmap.this, InNamhansan.class));
            intent.putExtra("type", "1");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InNamhansanmap.this.finish();
        }
        else if(text.compareTo(text2) == 0)
        {
            Intent intent = (new Intent(InNamhansanmap.this, InNamhansan.class));
            intent.putExtra("type", "2");
            startActivity(intent);
            overridePendingTransition(R.anim.fade, R.anim.hold);
            InNamhansanmap.this.finish();
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
