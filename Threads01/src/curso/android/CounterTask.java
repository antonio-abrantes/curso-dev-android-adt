package curso.android;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

public class CounterTask extends AsyncTask<Integer , Integer, Void> {
	
	private TextView texto;
	private Button botao;
	
	public CounterTask(TextView texto, Button botao) {
		super();
		this.texto = texto;
		this.botao = botao;
	}

	@Override
	protected Void doInBackground(Integer... arg0) {
		int n = arg0[0];
		
		for (int i = 0; i < n; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			publishProgress(i);
		}		
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		botao.setEnabled(true);
	}

	@Override
	protected void onPreExecute() {
		botao.setEnabled(false);
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		texto.setText(String.valueOf(values[0]));
		
	}
	
}
