package com.nsabimanainnocent1.frogar.movement;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.nsabimanainnocent1.frogar.GameScreen;


public class FrogMovement extends GameScreen{
    private SensorManager sensorManager;
    private Sensor sensor;
    public float xFrogSpeed;
    public float yFrogSpeed;

    public FrogMovement(){
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                xFrogSpeed = event.values[0];
                yFrogSpeed = event.values[1];
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public long getXVelocity(){
        return Math.round(xFrogSpeed);
    }

    public long getYVelocity(){
        return Math.round(yFrogSpeed);
    }

}
