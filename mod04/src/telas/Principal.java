package telas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Principal extends Activity {
	
	private EditText edNome;
	private RadioButton radio_masc;
	private RadioButton radio_fem;
	private TextView result_nome;
	private TextView result_sexo;
	private TextView nome_label;
	private TextView sexo_label;
	private TableLayout tabela;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(mod04.exercicio.R.layout.principal);
		
		tabela = (TableLayout)findViewById(mod04.exercicio.R.id.tabela);
		
		edNome = (EditText)findViewById(mod04.exercicio.R.id.edNome);
		
		radio_masc = (RadioButton)findViewById(mod04.exercicio.R.id.radio_masc);
		radio_fem = (RadioButton)findViewById(mod04.exercicio.R.id.radio_fem);
		
		//nome_label = (TextView)findViewById(mod04.exercicio.R.id.nome_label);
		//result_nome = (TextView)findViewById(mod04.exercicio.R.id.result_nome);
		
		//sexo_label = (TextView)findViewById(mod04.exercicio.R.id.sexo_label);
		//result_sexo = (TextView)findViewById(mod04.exercicio.R.id.result_sexo);
		
	}
	
	public void verData(View aView){
		try {
			Intent i = new Intent(getApplicationContext(), DataHora.class);
			startActivity(i);
		} catch (Exception e) {
			Toast t = Toast.makeText(aView.getContext(), e.toString(), Toast.LENGTH_SHORT);
			t.show();
		}
	}
	
	public void exibir(View v) {		
		Cadastro novo = new Cadastro();
		novo.setNome(edNome.getText().toString());
		
		if(radio_masc.isChecked()){
			novo.setSexo(String.format("%s",radio_masc.getText()));
		}else if(radio_fem.isChecked()){
			novo.setSexo(String.format("%s",radio_fem.getText()));
		}
		
		Toast t = Toast.makeText(v.getContext(), "Cadastrou", Toast.LENGTH_SHORT);
		t.show();
		TableRow linha1 = new TableRow(getApplicationContext());
		TableRow linha2 = new TableRow(getApplicationContext());
		TextView nomeLabel = new TextView(getApplicationContext());
		TextView nome = new TextView(getApplicationContext());
		TextView sexoLabel = new TextView(getApplicationContext());
		TextView sexo = new TextView(getApplicationContext());
		
		nomeLabel.setText(mod04.exercicio.R.string.result_nome_label);
		nome.setText(novo.getNome());
		linha1.addView(nomeLabel);
		linha1.addView(nome);
		
		sexoLabel.setText(mod04.exercicio.R.string.result_sexo_label);
		sexo.setText(novo.getSexo());
		linha2.addView(sexoLabel);
		linha2.addView(sexo);
		tabela.addView(linha1);
		tabela.addView(linha2);
		
//		if(radio_masc.isChecked()){
//			result_sexo.setText(mod04.exercicio.R.string.radio_masc_txt);
//		}else if(radio_fem.isChecked()){
//			result_sexo.setText(mod04.exercicio.R.string.radio_fem_txt);
//		}
	}
	
	public void limpar(View v){
		edNome.setText("");
		nome_label.setText("");
		result_nome.setText("");
		sexo_label.setText("");
		result_sexo.setText("");
		radio_masc.setChecked(true);
	}
}
