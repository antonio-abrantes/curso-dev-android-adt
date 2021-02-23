package com.tgameasteroids;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Retrato
		setRequestedOrientation(
		ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(
		WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		// configura a tela
		CCGLSurfaceView glSurfaceView = new CCGLSurfaceView(this);
		setContentView(glSurfaceView);
		CCDirector.sharedDirector().attachInView(glSurfaceView);
		
		// configura CCDirector
		CCDirector.sharedDirector().setScreenSize(320, 480);
		
		// abre tela principal
		CCScene scene = new TitleScreen().scene();
		CCDirector.sharedDirector().runWithScene(scene);
		
		configSensorManager();
	}
	
//	@Override
//	protected void onDestroy() {
//		super.onDestroy();
//		finish();
//		System.exit(0);
//	}
	
	private void configSensorManager() {
		SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		DeviceSettings.setSensorManager(sensorManager);
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
		System.exit(0);
	}
	
}
