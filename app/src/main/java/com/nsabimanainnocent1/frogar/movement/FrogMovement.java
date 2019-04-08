package com.nsabimanainnocent1.frogar.movement;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.nsabimanainnocent1.frogar.GameScreen;
import com.nsabimanainnocent1.frogar.gameObjects.Frog;


public class FrogMovement{
    private SensorManager sensorManager;
    private Sensor sensor;
    private Frog frog;
    private boolean isActive = false;
    private Context context;

    public FrogMovement(Frog frog, Context context){
       this.frog = frog;
       this.context = context;
    }

    public void activateFrog(){
        if(isActive) {
            sensorManager = (SensorManager) this.context.getSystemService(Context.SENSOR_SERVICE);
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    frog.changePosition(event.values[0] * 20, event.values[1]*20);
                }
                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {

                }
            }, sensor, SensorManager.SENSOR_DELAY_FASTEST);
        }
    }

    public void markActivate(){
        this.isActive = true;
    }

    public void markDeActivate(){
        this.isActive = false;
    }



//    public long getXVelocity(){
//        return Math.round(xFrogSpeed);
//    }
//
//    public long getYVelocity(){
//        return Math.round(yFrogSpeed);
//    }

}
