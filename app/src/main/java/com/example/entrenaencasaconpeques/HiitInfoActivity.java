package com.example.entrenaencasaconpeques;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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
