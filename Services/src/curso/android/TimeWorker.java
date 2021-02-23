package curso.android;

import android.util.Log;

public class TimeWorker implements Runnable{

	private int seconds;
	private boolean running; 
	
	@Override
	public void run() {
		setRunning(true);
		
		while (running) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			incrment();
			Log.i("Thread", "Funcionamento");
		}	
	}
	
	public synchronized boolean isRunning() {
		return running;
	}

	public synchronized void setRunning(boolean running) {
		this.running = running;
	}
	
	public synchronized int getSeconds() {
		return seconds;
	}

	private synchronized void incrment() {
		this.seconds++;
	}
	
	public void stop(){
		setRunning(false);
	}
}
