package mod03;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Imagem extends Activity {
	
	private ImageView imagem;
	private Button botao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(android.mod03.R.layout.imagem);

		botao = new Button(this);
		
		
		Bundle b = getIntent().getExtras();
		int contador = 0;
		if(b.getInt("cont") != 0){
			contador = b.getInt("cont");
			botao.setText(String.valueOf(contador));
			setContentView(botao);
		}else{
			botao = (Button)findViewById(android.mod03.R.id.btNum);
			botao.setText(String.valueOf(contador));
		}	
		
		botao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int contador = Integer.parseInt(botao.getText().toString());
				contador++;
				
				Intent i = new Intent();
				//Cria um bundle, coloca o contador dentro dele e atrela o bundle à intent
				Bundle b = new Bundle();
				b.putInt("cont", contador);
				i.putExtras(b);
				setResult(RESULT_OK, i);
				finish();
			}
		});
			
	}
}
