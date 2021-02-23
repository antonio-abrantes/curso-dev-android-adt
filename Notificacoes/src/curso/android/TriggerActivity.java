package curso.android;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

public class TriggerActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trigger);
		
//		NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
//		nm.cancel(R.string.id_msg);
	}
}
