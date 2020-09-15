package com.example.entrenaencasaconpeques;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListadoEjercicios6abdominales extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_ejercicios6abdominales);
    }

    //Intent para mostrar los ejercicios en la actividad 7
    public void VerEjercicio(View vista){
        Intent VerEjercicio = new Intent(this, VideoEjercicio7.class);
        startActivity(VerEjercicio);
    }

    public void Volver (View vista){ onBackPressed(); }
}
