package com.example.bancodados;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityEditar extends Activity {
	
	private EditText nome;
	private EditText telefone;
	private Button gravar;
	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editar);
		
		nome = (EditText)findViewById(R.id.nome);
		telefone = (EditText) findViewById(R.id.telefone);
		gravar = (Button) findViewById(R.id.bt_gravar);
		
		DBHelper dbHelper = new DBHelper(this, "contatos", 1);
		db = dbHelper.getWritableDatabase();
		
	}
	
	public void gravar(View v){
		
		ContentValues values = new ContentValues();
		//values.put("nome", nome.getText().toString());
		values.put("telefone", Integer.parseInt(telefone.getText().toString()));
		
		db.update("contato", values, "nome = ?", new String[]{ nome.getText().toString() });
		
		Toast.makeText(this, "Alterado com sucesso...", Toast.LENGTH_SHORT).show();
	}
	
	public void procurar(View v){
		
		Cursor c = db.query("contato", new String[] {"telefone"}, "nome = ?", new String[]{ nome.getText().toString() }, 
				null, null, null);
		
		startManagingCursor(c);
		
		if(c.moveToNext()){
			int tel = c.getInt(0);
			telefone.setText(String.valueOf(tel));
			gravar.setEnabled(true);
			telefone.setEnabled(true);
		}else{
			Toast.makeText(this, "Nenhum regostro encontrado...", Toast.LENGTH_SHORT).show();
		}
	}	
}
