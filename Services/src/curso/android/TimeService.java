package curso.android;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TimeService extends Service {
	
	private TimeWorker worker;
	private TimeServiceBinder binder = new TimeServiceBinder(this);
	
	@Override
	public void onCreate() {
		Log.i("TIME", "Serviço criado");
	}

	@Override
	public void onDestroy() {
		worker.stop();
		Log.i("TIME", "Serviço destruido");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		worker = new TimeWorker();
		new Thread(worker).start();

		return START_STICKY;
	}

	@Override
	public IBinder onBind(Intent arg0) {		
		return this.binder;
	}
	
	public int getSeconds(){
		return worker.getSeconds();		
	}

}
