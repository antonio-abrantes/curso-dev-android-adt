package curso.android;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private AlarmManager alerMgr;
	private PendingIntent pi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		alerMgr = (AlarmManager)getSystemService(ALARM_SERVICE);
		
	}
	
	public void definirAlarme(View v){
		
		Intent i = new Intent("ALARME");
		pi = PendingIntent.getBroadcast(this, 0, i, 0);

		alerMgr.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 3000, pi);
		
		Toast.makeText(this, "Alarme Ativado!", Toast.LENGTH_SHORT).show();
	}
	
	private void cancelarAlarme(View v) {
		alerMgr.cancel(pi);
		//Toast.makeText(this, "Alarme desativado", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	public void notify(View v){
		
//		LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);		
//		Avisos av = new Avisos();
//		av.Menssagem(this, inflater);
		
//		Intent i = new Intent(this, TriggerActivity.class);
//		startActivity(i);
		
//		Notificacao.notify(this, 1, 2, TriggerActivity.class);
		
//		NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
//		
//		Notification n = new Notification(R.drawable.ic_launcher, "Chegou mensagem", System.currentTimeMillis());
//		
//		Intent i = new Intent(this, TriggerActivity.class);
//		PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
//		
//		String msg = "Só para informar que a notificação executou com sucesso!";
//		
//		n.setLatestEventInfo(this, "Aviso importante", msg, pi);
//		
//		nm.notify(R.string.id_msg, n);
		
	}
	
}
