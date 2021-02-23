package curso.android;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Avisos extends Activity{
	
	public void Menssagem(Context ctx, LayoutInflater inflater){
		
//		Toast.makeText(this, "Mensagem do Toast", Toast.LENGTH_SHORT).show();
		
//		LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
		
		View vi = inflater.inflate(R.layout.toast, null);
		
		Toast t = new Toast(ctx);
		t.setView(vi);
		t.setDuration(Toast.LENGTH_SHORT);
		t.show();
	}

}
