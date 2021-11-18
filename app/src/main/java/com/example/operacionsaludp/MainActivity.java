package com.example.operacionsaludp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculadora(View view){
        Intent icalculadora = new Intent(MainActivity.this, Operaciones.class);
        startActivity(icalculadora);
    }
    public void salud(View view){
        Intent isalud = new Intent(MainActivity.this, Salud.class);
        startActivity(isalud);
    }
    public void salir(View view){
        finish();
    }

}