package mod03;

import android.app.Activity;
import android.content.Intent;
import android.mod03.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.AlertDialog;

public class Principal extends Activity {
	
	private static final int REQUEST_CODE = 10;
	private Button btAbrir;
	private Button btNumero;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
		
		btNumero = (Button)findViewById(R.id.btNumero);
		btNumero.setText("1");
		btNumero.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int contador = Integer.parseInt(btNumero.getText().toString());
				contador++;
				
				Bundle b = new Bundle();
				b.putInt("cont", contador);
				
				novaTela(b);	
			}
		});
		
		
		btAbrir = (Button)findViewById(R.id.btAbrir);
		btAbrir.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Bundle b = new Bundle();
				novaTela(b);
			}
		});
		
	}
	private void novaTela(Bundle b) {
		Intent i = new Intent(getApplicationContext(), mod03.Imagem.class);
		if(b == null)
			startActivity(i);
		else{
			i.putExtras(b);
			startActivityForResult(i, REQUEST_CODE);
		}			
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
			//Obtém o bundle relacionado à intent enviada pela Activity2 e extrai o valor
			//atual do contador
			Bundle b = data.getExtras();
			int contador = b.getInt("cont");
			
			//Define o valor do contador como o novo texto do botão
			btNumero.setText(String.valueOf(contador));
			AlertDialog.Builder a = new AlertDialog.Builder(this);
			a.setTitle("Aviso");
			a.setMessage("Dialog teste");
			
			AlertDialog al = a.create();
			al.show();
			
		}
	}
	
	
	
}
