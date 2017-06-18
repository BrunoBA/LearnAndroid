package com.example.bruno.learnandroid;

/**
 * Created by bruno on 03/07/16.
 */


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SecondActivity extends AppCompatActivity {


    TextView meuTexto;
    Button botao1;
    Button botao2;

    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference referenceCorreta = reference.child("minha_cor");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        meuTexto = (TextView)findViewById(R.id.textView);
        botao1= (Button) findViewById(R.id.button5);
        botao2 = (Button) findViewById(R.id.button6);


    }

    @Override
    protected void onStart(){
        super.onStart();

        referenceCorreta.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                meuTexto.setText(text);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

