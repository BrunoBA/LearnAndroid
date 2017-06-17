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

        CharSequence text = "onSensorChanged";
        Toast t = Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT);
        t.show();

        float sensorX = event.values[0];
        float sensorY = event.values[1];
        float sensorZ = event.values[2];

        TextView tx = (TextView) findViewById(R.id.tX);
        TextView tY = (TextView) findViewById(R.id.tY);
        TextView tZ = (TextView) findViewById(R.id.tZ);

        if(tx != null){
            tx.setText("X: " + sensorX);
            tY.setText("Y: " + sensorY);
            tZ.setText("Z: " + sensorZ);
        }

//        CharSequence text = "onSensorChanged";
//        Toast t = Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT);
//        t.show();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
