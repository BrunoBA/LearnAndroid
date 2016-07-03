package com.example.bruno.learnandroid;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.net.ssl.SSLSessionContext;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CharSequence text = "onCreate";
        Toast t = Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT);
        t.show();

    }

    protected void onStart(){
        super.onStart();

        CharSequence text = "onStart";
        Toast t = Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT);
        t.show();
    }

    protected void onRestart(){
        super.onRestart();

        CharSequence text = "onRestart";
        Toast t = Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT);
        t.show();
    }

    protected void onResume(){
        super.onResume();

        CharSequence text = "onResume";
        Toast t = Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT);
        t.show();
    }

    protected void onPause(){
        super.onPause();

        CharSequence text = "onPause";
        Toast t = Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT);
        t.show();
    }

    protected void onStop(){
        super.onStop();

        CharSequence text = "onStop";
        Toast t = Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT);
        t.show();
    }

    protected void onDestroy(){
        super.onDestroy();

        CharSequence text = "onDestroy";
        Toast t = Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT);
        t.show();
    }

    public void callSecondAtctivity(){

        Intent i = new Intent( this, SecondActivity.class);
        startActivity(i);

    }



}
