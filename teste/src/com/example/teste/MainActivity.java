package com.example.teste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity{

	private EditText edNUM1;
	private EditText edNUM2;
	private EditText result;
	private Button multiplicar;
	private Button somar;
	private Button tela2;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edNUM1 = (EditText)findViewById(R.id.edNUM1);
		edNUM2 = (EditText)findViewById(R.id.edNUM2);
		result = (EditText)findViewById(R.id.edResult);

		somar = (Button)findViewById(R.id.btSoma);
		somar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					int num1 = Integer.valueOf(edNUM1.getText().toString());
					int num2 = Integer.valueOf(edNUM2.getText().toString());

					int soma = num1 + num2;

					result.setText(String.valueOf(soma));
				} catch (Exception e) {
					msg(v);
				}
			}
		});

		multiplicar = (Button)findViewById(R.id.btMult);
		multiplicar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					int num1 = Integer.valueOf(edNUM1.getText().toString());
					int num2 = Integer.valueOf(edNUM2.getText().toString());

					int mult = num1 * num2;

					result.setText(String.valueOf(mult));
				} catch (Exception e) {
					msg(v);
				}

			}
		});
		
		tela2 = (Button)findViewById(R.id.btTela2);
		tela2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(v.getContext(),Tela2.class);
				startActivity(i);
			}
		});
	}

	private void msg(View v){
		Toast t = Toast.makeText(v.getContext(), "Campos em branco ou valores invalidos!", Toast.LENGTH_SHORT);
		t.show();
	}

	//	public void facaSoma(View v) {
	//		try {
	//			int num1 = Integer.valueOf(edNUM1.getText().toString());
	//			int num2 = Integer.valueOf(edNUM2.getText().toString());
	//			
	//			int soma = num1 + num2;
	//			
	//			result.setText(String.valueOf(soma));
	//		} catch (Exception e) {
	//			Toast t = Toast.makeText(this, "Campos em branco ou valores invalidos!", Toast.LENGTH_SHORT);
	//			t.show();
	//		}
	//	}

	//	@Override
	//	public void onClick(View v) {
	//		try {
	//			int num1 = Integer.valueOf(edNUM1.getText().toString());
	//			int num2 = Integer.valueOf(edNUM2.getText().toString());
	//			
	//			int soma = num1 + num2;
	//			
	//			result.setText(String.valueOf(soma));
	//		} catch (Exception e) {
	//			Toast t = Toast.makeText(this, "Campos em branco ou valores invalidos!", Toast.LENGTH_SHORT);
	//			t.show();
	//		}
	//		
	//	}	
}

