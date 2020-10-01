package com.example.entrenaencasaconpeques;


import android.os.Bundle;
import android.view.View;
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
        TextView nombreEjercicio = (TextView) findViewById(R.id.TV_nombreEjercicioVideo);

        //Recepcionamos el bundle envíado desde el activity_main
        Bundle informacion = getIntent().getExtras();

        //Creamos la variable para albergar la información mediante el key (SUPERIORES)
        String tituloEjercicioVideoSup = informacion.getString("tituloGrupoMuscular");
        String nombreVideoSup = informacion.getString("tituloNombreEjercicio");

        //Creamos la variable para albergar la información mediante el key (INFERIORES)
        String tituloEjercicioVideoInf = informacion.getString("tituloGrupoMuscular");
        String nombreVideoInf = informacion.getString("tituloNombreEjercicio");

        //Creamos la variable para albergar la información mediante el key (ABDOMINALES)
        String tituloEjercicioVideoAbd = informacion.getString("tituloGrupoMuscular");
        String nombreVideoAbd = informacion.getString("tituloNombreEjercicio");

        //Creamos la variable para albergar la información mediante el key (CARDIO)
        String tituloEjercicioVideoCar = informacion.getString("tituloGrupoMuscular");
        String nombreVideoCar = informacion.getString("tituloNombreEjercicio");


        //Si la información que enviamos no está vacía, entonces que ponga el texto (PARA SUPERIORES)
        if(nombreVideoSup!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoSup);
            nombreEjercicio.setText(nombreVideoSup);
        }


        //Si la información que enviamos no está vacía, entonces que ponga el texto (PARA INFERIORES)
        if(nombreVideoInf!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoInf);
            nombreEjercicio.setText(nombreVideoInf);
        }


        //Si la información que enviamos no está vacía, entonces que ponga el texto (PARA ABDOMINALES)
        if(nombreVideoAbd!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoAbd);
            nombreEjercicio.setText(nombreVideoAbd);
        }


        //Si la información que enviamos no está vacía, entonces que ponga el texto (PARA CARDIO)
        if(nombreVideoCar!= null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoCar);
            nombreEjercicio.setText(nombreVideoCar);
        }

    } //Llave de cierre del OnCreate

    public void Volver(View vista){
        onBackPressed();
    }
}
