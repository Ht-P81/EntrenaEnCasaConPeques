package com.example.entrenaencasaconpeques;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class HiitInfo8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiit_info8);
    }

    public void Volver(View vista){
        onBackPressed();
    }
}
