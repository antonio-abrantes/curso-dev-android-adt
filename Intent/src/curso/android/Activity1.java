package curso.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Activity1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity1);
	}
	
	public void invocar(View v) {
		
		Uri uri = Uri.parse("http://tonhus.github.io");
		Intent i = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(i);
		
		//Invocação explicita
//		Intent i = new Intent(this, Activity2.class);
//		startActivity(i);
		
		//Invocação Implicita
//		Intent i = new Intent("alguma.activity");
//		startActivity(i);
		
//		Intent i = new Intent(Settings.ACTION_SETTINGS);
//		startActivity(i);
		
	}
}
