package com.example.bancodados;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void inserirContato(View v) {
		Intent i = new Intent(this, ActivityInserir.class);
		startActivity(i);
	}

	public void editarContato(View v) {
		Intent i = new Intent(this, ActivityEditar.class);
		startActivity(i);
	}

}
