package com.example.bruno.learnandroid;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AcelerometroActivity extends AppCompatActivity implements SensorEventListener{

    private static final int TIPO_SENSOR = Sensor.TYPE_ACCELEROMETER;
    private SensorManager sensorManager;
    private Sensor sensor;
    private static double SENSIBILIDADE_SENSOR_X = 1.2;
    private static double SENSIBILIDADE_SENSOR_Y = 1.5;
    private static double MIN_SENSOR_Z = 8;
    private static double MAX_SENSOR_Z = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(TIPO_SENSOR);

        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

        Log.i("teste",sensor.toString());

        CharSequence text = "onCreateSensorActivity";
        Toast t = Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float sensorX = -event.values[0];
        float sensorY = event.values[1];
        float sensorZ = event.values[2];

        TextView tX = (TextView) findViewById(R.id.tX);
        TextView tY = (TextView) findViewById(R.id.tY);
        TextView tZ = (TextView) findViewById(R.id.tZ);

        tX.setText("X: " + sensorX);
        tY.setText("Y: " + sensorY);
        tZ.setText("Z: " + sensorZ);

        if(checkTheConditions(sensorX,sensorY,sensorZ)){

//            Log.i("sensor","X: " + sensorX);
//            Log.i("sensor","Y: " + sensorY);
//            Log.i("sensor","Z: " + sensorZ);
//            Log.i("sensor","Buraco!");

            CharSequence text = "Buraco!";
            Toast t = Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT);
            t.show();
        }
    }

    private boolean checkTheConditions(float x, float y, float z){

        if(x > SENSIBILIDADE_SENSOR_X && y > SENSIBILIDADE_SENSOR_Y &&
                (MAX_SENSOR_Z > z &&  z < MIN_SENSOR_Z) ||
                (-MAX_SENSOR_Z > z &&  z < -MIN_SENSOR_Z)){
            return true;
        }
        return false;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
