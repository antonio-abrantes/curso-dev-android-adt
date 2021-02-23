package com.tgame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

public class Game extends Activity implements OnTouchListener {
	Jogo1 view;

	@SuppressLint("ClickableViewAccessibility")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
		WindowManager.LayoutParams.FLAG_FULLSCREEN);

		super.onCreate(savedInstanceState);

		// Lógica do jogo
		view = new Jogo1(this);
		// Configura view
		setContentView(view);
		view.setOnTouchListener(this);

	}
	
	protected void onResume() {
		super.onResume();
		view.resume();
	}
	
	

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		//Reiniciar
		if(event.getX() > 400 && event.getX() < 500 && event.getY() > 350 && event.getY() < 430) {
			view.init();
						
		}
		
		// Sair
		if(event.getX() > 400 && event.getX() < 500 && event.getY() > 440 && event.getY() < 510) {
			System.exit(0);
		}
		
		if(event.getY() < 250) {
			view.moveUp(10);
			view.addScore(100);
		}
		
		if(event.getY() > 350) {
			view.moveDown(10);
			view.addScore(100);
		}
		
		if(event.getX() < 250 && event.getY()< 350 && event.getY()> 250) {
			view.moveLeft(10);
			view.addScore(100);
		}
		
		if(event.getX() > 250 && event.getY()< 350 && event.getY()> 250) {
			view.moveRight(10);
			view.addScore(100);
		}
		return true;
	}
}
