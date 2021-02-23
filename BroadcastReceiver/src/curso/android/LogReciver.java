package curso.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class LogReciver extends BroadcastReceiver {

	@Override
	public void onReceive(Context ctx, Intent i) {
		String msg = i.getStringExtra("msg");
		Log.i("LogReciver", msg);
	}
}
