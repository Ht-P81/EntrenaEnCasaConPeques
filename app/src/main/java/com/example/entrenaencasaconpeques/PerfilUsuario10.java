package com.example.entrenaencasaconpeques;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class PerfilUsuario10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario10);
    }

    public void Volver(View vista){
        onBackPressed();
    }
}
