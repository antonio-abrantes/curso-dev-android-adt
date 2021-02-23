package curso.android;

import android.os.Binder;

public class TimeServiceBinder extends Binder{
	
	private TimeService service;
	
	public TimeServiceBinder(TimeService service){
		this.service = service;
	}
	
	public TimeService getService(){
		return this.service;
	}
	
}
