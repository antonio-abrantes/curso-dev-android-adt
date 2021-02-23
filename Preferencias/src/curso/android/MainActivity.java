package curso.android;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.layout.prefs);
		
//		EditTextPreference edtPref =  (EditTextPreference)findPreference("city");
//		
//		String cidade = edtPref.getText();
//		
//		CheckBoxPreference cb = (CheckBoxPreference)findPreference("use_gps");
//		boolean marcado = cb.isChecked();
//		
//		ListPreference l = (ListPreference)findPreference("unit");
//		String item = l.getEntry().toString();
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		boolean mercado = prefs.getBoolean("use_gps", false);
		
		String cidade = prefs.getString("city", "");
		
		prefs.registerOnSharedPreferenceChangeListener(this);
		
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

		Toast.makeText(this, key, Toast.LENGTH_SHORT).show();
		
	}
}
