package com.threads;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView texto;
	private Button botao;
	//private Handler handler = new Handler();
	private MyHandler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		texto = (TextView)findViewById(R.id.texto);
		botao = (Button)findViewById(R.id.botao);
		handler = new MyHandler(texto, botao);
		
	}
	
	
	public void processar(View v){
		texto.setText(R.string.processando);
		botao.setEnabled(false);
		
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
				
				Message msg = Message.obtain();
				msg.what = MyHandler.UPDATE_UI;
				handler.sendMessage(msg);			
			}
		};
		
		Thread t = new Thread(r);
		t.start();
	}
	
	
	
//	public void processar(View v){
//		texto.setText(R.string.processando);
//		
//		for(int i = 0; i < 10; i++){
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO: handle exception
//			}
//			texto.setText(R.string.fim_processamento);
//		}
//		
//	}
	
/*	public void processar(View v){
		texto.setText(R.string.processando);
		botao.setEnabled(false);
		
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
				
				runOnUiThread(new Runnable() {	
					@Override
					public void run() {
						texto.setText(R.string.fim_processamento);
						botao.setEnabled(true);
					}
				});
			}
		};
		
		Thread t = new Thread(r);
		t.start();
	}*/
}
