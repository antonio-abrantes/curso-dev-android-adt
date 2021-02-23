package curso.android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SendBroadcast extends Activity {
	
	private LogReciver log;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		log = new LogReciver();
		IntentFilter filter = new IntentFilter();
		filter.addAction("curso.android.log");
		
		registerReceiver(log, filter);
		
	}
	
	public void enviar(View v){
		Intent i = new Intent("curso.android.log");
		i.putExtra("msg", "Mensagem de log");
		sendBroadcast(i);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(log);
	}
}
