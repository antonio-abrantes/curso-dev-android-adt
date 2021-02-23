package curso.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
//		Intent i = getIntent();
//		Bundle b =  i.getExtras();
//		
//		String msg = b.getString("msg");
//		
//		TextView t = new TextView(this);
//		t.setText(msg);
//		setContentView(t);
		
		Button b = new Button(this);
		b.setText(R.string.nova_string);
		b.setOnClickListener(this);
		setContentView(b);
			
	}

	@Override
	public void onClick(View arg0) {
		Intent i = new Intent();
		//Cria um bundle, coloca o contador dentro dele e atrela o bundle à intent
		Bundle b = new Bundle();
		b.putString("msg1", "O retorno do Bunble deu certo");
		i.putExtras(b);
		setResult(RESULT_OK, i);
		finish();
	}

}
