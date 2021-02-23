package curso.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AsyncTaskActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async_task);
	}
	
	public void iniciar(View v){
		TextView texto = (TextView)findViewById(R.id.texto);
		Button botao = (Button)findViewById(R.id.botao);
		
		CounterTask task = new CounterTask(texto, botao);
		task.execute(10);
	}
}
