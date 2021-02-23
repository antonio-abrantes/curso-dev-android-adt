package com.tgameasteroids;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Accelerometer implements SensorEventListener {

	private AccelerometerDelegate delegate;

	private float currentAccelerationX;
	private float currentAccelerationY;

	private float calibratedAccelerationX;
	private float calibratedAccelerationY; 
	
	private SensorManager sensorManager;

	private int calibrated;

	static Accelerometer sharedAccelerometer = null;

	public static Accelerometer sharedAccelerometer() {
		if (sharedAccelerometer == null) {
			sharedAccelerometer = new Accelerometer();
		}
		return sharedAccelerometer;
	}

	public Accelerometer() {
		this.catchAccelerometer();
	}

	public void catchAccelerometer() {

		sensorManager = DeviceSettings.getSensormanager();
		sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_GAME);

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onSensorChanged(SensorEvent acceleration) {
		
		this.currentAccelerationX = acceleration.values[0];
		this.currentAccelerationY = acceleration.values[1];
	}

	public void setDelegate(AccelerometerDelegate delegate) {
		this.delegate = delegate;
	}

	public AccelerometerDelegate getDelegate() {
		return delegate;
	}

}
