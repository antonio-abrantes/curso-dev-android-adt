package curso.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReciver extends BroadcastReceiver {

	@Override
	public void onReceive(Context ctx, Intent arg1) {
		
		Log.i("Alarm", "Alarme disparou!");

	}

}
