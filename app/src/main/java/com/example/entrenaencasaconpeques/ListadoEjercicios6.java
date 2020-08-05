package com.example.entrenaencasaconpeques;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ListadoEjercicios6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_ejercicios6);
    }

    //Intent para mostrar los ejercicios en la actividad 7
    public void VerEjercicio(View vista) {
        Intent VerEjercicio = new Intent(this, VideoEjercicio7.class);
        startActivity(VerEjercicio);
    }

    public void Volver(View vista){
        onBackPressed();
    }
}
