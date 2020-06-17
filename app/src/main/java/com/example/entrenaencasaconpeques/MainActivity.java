package com.example.entrenaencasaconpeques;

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

    //Intent para ir a la lista de Ejercicios
    public void botonListaEjercicios(View vista){
        Intent intentListaEjercicios = new Intent(this, ListadoEjercicios6.class);
        startActivity(intentListaEjercicios);
    }

    //Intent para ir al boton al actividad hiit Info
    public void botonHiitInfo(View vista) {
        Intent intenthiitinfo = new Intent(this, HiitInfo8.class);
        startActivity(intenthiitinfo);
    }

    //Intent para ir al boton al actividad hiit Trainning
    public void botonHiitTrainning(View vista) {
        Intent intentTrainning = new Intent(this, HiitTrainning9.class);
        startActivity(intentTrainning);
    }
}
