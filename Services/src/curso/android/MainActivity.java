package curso.android;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Intent i;
	private ServiceConnection conn;
	private TimeService timeService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
	
	public void inicarServico(View v){
		 i = new Intent("TIME_SERVICE");
		 startService(i);
		 
		 conn = new ServiceConnection() {
			
			@Override
			public void onServiceDisconnected(ComponentName arg0) {
				
			}
			
			@Override
			public void onServiceConnected(ComponentName arg0, IBinder service) {
				TimeServiceBinder binder = (TimeServiceBinder) service;
				timeService = binder.getService();
			}
		};
		 
		 bindService(i, conn, 0);
	}
	
	public void pararServico(View v){
		unbindService(conn);
		stopService(i);		
	}
	
	public void lerServico(View v){
		int seconds = timeService.getSeconds();
		
		TextView tex = (TextView) findViewById(R.id.text_num01);
		
		tex.setText(Integer.toString(seconds));
		
	}
	
}
