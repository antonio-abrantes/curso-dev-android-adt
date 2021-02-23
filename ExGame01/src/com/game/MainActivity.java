package com.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	
	Exemplo1 view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//setContentView(R.layout.main);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(
		WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		view = new Exemplo1(this);
		
		setContentView(view);
		
	}

}
