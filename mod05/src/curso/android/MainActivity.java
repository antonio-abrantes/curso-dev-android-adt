package curso.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	// Atributos para representar os componentes da tela
	private TextView lblContador;
	private Button btnIniciar;
	
	//Handler da UI thread
	private Handler handler = new Handler();
	
	//Valor do contador
	private int contador;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Define o layout
		setContentView(R.layout.activity_main);
		
		//Obtém os componentes e atribui aos atributos
		lblContador = (TextView) findViewById(R.id.lbl_contador);
		btnIniciar = (Button) findViewById(R.id.btn_iniciar);
	}
	
	public void iniciar(View p) {
		//Ao clicar no botão, a contagem vai iniciar
		
		//Desabilita o botão 'Iniciar'
		btnIniciar.setEnabled(false);
		
		//Inicia o contador em 10
		contador = 10;
		
		//Agenda um Runnable para ser executado pela UI thread
		handler.post(new Runnable() {
			@Override
			public void run() {
				//Define o texto da view do contador com o valor atual do contador
				lblContador.setText(String.valueOf(contador));
				
				//Decrementa o contador
				contador--;
				
				if (contador >= 0) {
					//Se ainda é necessário continuar com o contador, recoloca o próprio objeto Runnable para execução
					//pelo handler da UI thread, mas com 1s (1000ms) de atraso. Isto vai fazer com que o Runnable seja 
					//executado de novo depois de 1s para o novo valor do contador
					handler.postDelayed(this, 1000);
				} else {
					//Quando o contador zerar, habilita o botão iniciar e o processo é finalizado.
					btnIniciar.setEnabled(true);
				}
			}
		});
	}
}
