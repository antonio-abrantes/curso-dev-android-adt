package curso.android;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends MapActivity {
	
	private LocationManager locMgr;
	private MapView map;
	private MapController controller;
	private EditText latitude;
	private EditText longitude; 
	private PosOverlay posOverlay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//map = new MapView();//(MapView)findViewById(R.id.map);
		controller = map.getController();
		
		map.setBuiltInZoomControls(true);
		map.setSatellite(true);
		
		posOverlay = new PosOverlay();
		map.getOverlays().add(posOverlay);
		
		
	}

	public void buscar(View v){
		//Dados digitados pelo usúario
		
		GeoPoint geoP = new GeoPoint((int)(37.545 * 1E6), (int)(30.545 * 1E6));
		controller.animateTo(geoP);
		posOverlay.setGeoPoint(geoP);
		map.invalidate();
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
}
