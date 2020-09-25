package com.example.entrenaencasaconpeques;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoEjercicio7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_ejercicio7);

        //Declaramos las variables que se equipararán a los componentes de la actividad (TextView)
        TextView grupoMuscular = (TextView) findViewById(R.id.TV_Ejercicios);

        //Declaramos las variables que se equipararán a los componentes de la actividad (CheckBox)
        CheckBox nombreEjercicio = (CheckBox) findViewById(R.id.ChBx_Ejercicio3);

        //Recepcionamos el bundle envíado desde el activity_main
        Bundle informacion = getIntent().getExtras();

        //Creamos la variable para albergar la información mediante el key (SUPERIORES)
        String tituloEjercicioVideoSup = informacion.getString("tituloGrupoMuscular");
        String nombreVideoSup1 = informacion.getString("tituloNombreEjercicio1");
        String nombreVideoSup2 = informacion.getString("tituloNombreEjercicio2");
        String nombreVideoSup3 = informacion.getString("tituloNombreEjercicio3");
        String nombreVideoSup4 = informacion.getString("tituloNombreEjercicio4");
        String nombreVideoSup5 = informacion.getString("tituloNombreEjercicio5");

        //Si la información que enviamos no está vacía, entonces que ponga el texto (PARA SUPERIORES)
        if(nombreVideoSup1!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoSup);
            nombreEjercicio.setText(nombreVideoSup1);

        }

        if (nombreVideoSup2 != null) {
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoSup);
            nombreEjercicio.setText(nombreVideoSup2);
        }

        if (nombreVideoSup3 != null) {
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoSup);
            nombreEjercicio.setText(nombreVideoSup3);
        }

        if (nombreVideoSup4 != null) {
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoSup);
            nombreEjercicio.setText(nombreVideoSup4);
        }

        if (nombreVideoSup4 != null) {
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoSup);
            nombreEjercicio.setText(nombreVideoSup4);
        }

        if (nombreVideoSup5 != null) {
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoSup);
            nombreEjercicio.setText(nombreVideoSup5);
        }


    } //Llave de cierre del OnCreate

    public void Volver(View vista){
        onBackPressed();
    }
}
