package curso.android;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView textoLer;
	private EditText textoGravar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		textoLer = (TextView) findViewById(R.id.text_read);
		textoGravar = (EditText) findViewById(R.id.text_write);
	}
	
	
	public void gravar(View v) {

		BufferedWriter writer = null;
		try {

			FileOutputStream fos = openFileOutput("text.txt", MODE_PRIVATE);
			writer = new BufferedWriter(new OutputStreamWriter(fos));
			writer.write(textoGravar.getText().toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	public void ler(View v) {
		BufferedReader reader = null;
		try {
			
			FileInputStream fos = openFileInput("text.txt");
			reader = new BufferedReader(new InputStreamReader(fos));
			String texto = reader.readLine();
			textoLer.setText(texto);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
