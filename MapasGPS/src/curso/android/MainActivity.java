package curso.android;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends Activity implements LocationListener{

	private LocationManager locMgr;
	private EditText latitude;
	private EditText longitude;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		latitude = (EditText)findViewById(R.id.edt_latitude);
		longitude = (EditText)findViewById(R.id.edt_longitude);
		
		locMgr = (LocationManager)getSystemService(LOCATION_SERVICE);
		
		locMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 2, this);
		
		
	}

	@Override
	public void onLocationChanged(Location location) {
		double lat = location.getLatitude();
		double lon = location.getLatitude();
		latitude.setText(String.valueOf(lat));
		longitude.setText(String.valueOf(lon));
	}

	@Override
	public void onProviderDisabled(String provider) {
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		
	}
}
