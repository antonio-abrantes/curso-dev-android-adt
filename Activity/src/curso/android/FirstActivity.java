package curso.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class FirstActivity extends Activity implements OnClickListener {

	private Button b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		b = (Button)findViewById(R.id.btNovaTela);
		b.setOnClickListener(this);
		
//		b = new Button(this);
//		b.setText(R.string.msg);
//		b.setOnClickListener(this);
//		setContentView(b);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		
		super.onPrepareOptionsMenu(menu);
		SubMenu subMenu = menu.addSubMenu("Abrir sbmenu");
		MenuItem item = subMenu.add(0, Menu.FIRST, 0, "CheckBox");
		item.setCheckable(true);
		
//		subMenu.add(GROUP_RADIO, menu.FIRST+ 1, 0, "Radio 1");
//		subMenu.add(GROUP_RADIO, menu.FIRST+ 2, 0, "Radio 1");
//		subMenu.add(GROUP_RADIO, menu.FIRST+ 3, 0, "Radio 1");
//		subMenu.setGroupCheckable(GROUP_RADIO, true, true);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}
	
//	@Override
//	public boolean onPrepareOptionsMenu(Menu menu) {
//
//		
//		return true;
//	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onContextItemSelected(item);
	}

	@Override
	public void onClick(View arg0) {	
		Intent i = new Intent(getApplicationContext(), SecondActivity.class);
		i.putExtra("msg", "Funcou a mensagem por parametro");
		//startActivity(i);
		startActivityForResult(i, 50);
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Bundle bd = data.getExtras();
		b.setText(bd.getString("msg1"));
	}	
}
