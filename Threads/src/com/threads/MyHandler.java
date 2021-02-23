package com.threads;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

public class MyHandler extends Handler {
	
	public static final int UPDATE_UI = 100;
	
	private TextView texto;
	private Button botao;
	
	public MyHandler(TextView texto, Button botao) {
		this.texto = texto;
		this.botao = botao;
	}

	@Override
	public void handleMessage(Message msg) {
		if(msg.what == UPDATE_UI){
			texto.setText(R.string.fim_processamento);
			botao.setEnabled(true);
		}
	}
}
