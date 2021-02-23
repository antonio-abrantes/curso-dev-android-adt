package curso.android;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class Notificacao {

	public static void notify(Context ctx, int icon, int tituloBarra, Class<?> activityClass){
		NotificationManager nm = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
		
		Notification n = new Notification(R.drawable.ic_launcher, "Chegou mensagem", System.currentTimeMillis());
		
		Intent i = new Intent(ctx, activityClass);
		PendingIntent pi = PendingIntent.getActivity(ctx, 0, i, 0);
		
		String msg = "Só para informar que a notificação executou com sucesso!";
		
		n.setLatestEventInfo(ctx, "Aviso importante", msg, pi);
		
		nm.notify(R.string.id_msg, n);
	}
}
