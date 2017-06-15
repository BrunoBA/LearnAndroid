package com.example.bruno.learnandroid;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AcelerometroActivity extends AppCompatActivity implements SensorEventListener{

    private static final int TIPO_SENSOR = Sensor.TYPE_ACCELEROMETER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);

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
