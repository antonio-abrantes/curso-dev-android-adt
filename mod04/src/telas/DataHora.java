package telas;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class DataHora extends Activity implements OnDateChangedListener, OnTimeChangedListener{
	
	private DatePicker date;
	private TimePicker time;
	private TextView lblDataHora;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(mod04.exercicio.R.layout.data_hora);
		
		date = (DatePicker) findViewById(mod04.exercicio.R.id.data);
		time = (TimePicker) findViewById(mod04.exercicio.R.id.hora);
		lblDataHora = (TextView) findViewById(mod04.exercicio.R.id.lbl_datahora);
		
		Calendar today = Calendar.getInstance();
		int ano = today.get(Calendar.YEAR);
		int mes = today.get(Calendar.MONTH);
		int dia = today.get(Calendar.DAY_OF_MONTH);
		int hora = today.get(Calendar.HOUR_OF_DAY);
		int minuto = today.get(Calendar.MINUTE);
		
		// Coloca a data atual no DatePicker
		// Aqui um listener também é definido, que será invocado sempre que ocorrer uma alteração na data
		date.init(ano, mes, dia, (OnDateChangedListener) this);

		// Define o horário como padrão 24h
		time.setIs24HourView(true);
		
		//Adiciona um listener, invocado sempre que ocorrer uma alteração no horário
		time.setOnTimeChangedListener((OnTimeChangedListener) this);

		// Define hora e minuto no TimePicker
		time.setCurrentHour(hora);
		time.setCurrentMinute(minuto);
		
		//Atualiza a data/hora formatada
		atualizarDataHora();
		
	}
	
	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
		//Quando a data for mudada, chama o atualizarDataHora()
		atualizarDataHora();
	}

	@Override
	public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
		//Quando o horário for mudado, chama o atualizarDataHora()
		atualizarDataHora();
	}
	
	private void atualizarDataHora() {
		//Lê os dados atuais de data e hora fornecidos pelo usuário
		int ano = date.getYear();
		int mes = date.getMonth() + 1; //lembre que o mês no Java inicia em 0!
		int dia = date.getDayOfMonth();
		int hora = time.getCurrentHour();
		int minuto = time.getCurrentMinute();
		
		//Formata a string no formato de data/hora
		String dataHora = String.format("%02d/%02d/%d %02d:%02d", dia, mes, ano, hora, minuto);
		
		//Coloca a data/hora formatada no TextView
		lblDataHora.setText(dataHora);
	}
	
}
