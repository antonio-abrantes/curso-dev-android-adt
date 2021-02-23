package com.example.bancodados;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityInserir extends Activity {
	
	private EditText nome;
	private EditText telefone;
	private SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inserir);
		
		nome = (EditText)findViewById(R.id.nome);
		telefone = (EditText) findViewById(R.id.telefone);
		
		DBHelper dbHelper = new DBHelper(this, "contatos", 1);
		db = dbHelper.getWritableDatabase();
		
	}
	
	public void gravar(View v){
		
		ContentValues values = new ContentValues();
		values.put("nome", nome.getText().toString());
		values.put("telefone", Integer.parseInt(telefone.getText().toString()));

		db.insert("contato", null, values);
		
		Toast.makeText(this, "Gravado com sucesso...", Toast.LENGTH_SHORT).show();
	}

}
