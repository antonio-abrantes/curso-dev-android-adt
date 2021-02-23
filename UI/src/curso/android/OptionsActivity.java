package curso.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class OptionsActivity extends Activity {
	
	private CheckBox op1;
	private CheckBox op2;
	private TextView texto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options_activity);
		
		op1 = (CheckBox)findViewById(R.id.op01);
		op2 = (CheckBox)findViewById(R.id.op02);
		texto = (TextView)findViewById(R.id.texto);
		
	}
	
	
	public void verificar(View v) {
//		if(op1.isChecked() && op2.isChecked()){
//			texto.setText(R.string.op1_op2_checked);
//		}else if(op1.isChecked()){
//			texto.setText(R.string.op1_checked);
//		}else if(op2.isChecked()){
//			texto.setText(R.string.op2_checked);
//		}else{
//			texto.setText(R.string.none_checked);
//		}
	}
}
