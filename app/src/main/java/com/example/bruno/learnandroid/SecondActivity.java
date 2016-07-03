package com.example.bruno.learnandroid;

/**
 * Created by bruno on 03/07/16.
 */


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        CharSequence text = "Segunda Ativity";
        Toast t = Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT);
        t.show();
    }

}
