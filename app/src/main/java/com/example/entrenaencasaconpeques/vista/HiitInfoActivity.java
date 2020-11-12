package com.example.entrenaencasaconpeques.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.entrenaencasaconpeques.R;

public class HiitInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiit_info);
    }

    //Metodo para volver al activity main
    public void Volver(View vista){
        onBackPressed();
    }
}
