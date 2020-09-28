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
        String nombreVideoSup1 = informacion.getString("tituloNombreEjercicio1");
        String nombreVideoSup2 = informacion.getString("tituloNombreEjercicio2");
        String nombreVideoSup3 = informacion.getString("tituloNombreEjercicio3");
        String nombreVideoSup4 = informacion.getString("tituloNombreEjercicio4");
        String nombreVideoSup5 = informacion.getString("tituloNombreEjercicio5");

        //Creamos la variable para albergar la información mediante el key (INFERIORES)
        String tituloEjercicioVideoInf = informacion.getString("tituloGrupoMuscular");
        String nombreVideoInf1 = informacion.getString("tituloNombreEjercicio1");
        String nombreVideoInf2 = informacion.getString("tituloNombreEjercicio2");
        String nombreVideoInf3 = informacion.getString("tituloNombreEjercicio3");
        String nombreVideoInf4 = informacion.getString("tituloNombreEjercicio4");
        String nombreVideoInf5 = informacion.getString("tituloNombreEjercicio5");

        //Creamos la variable para albergar la información mediante el key (ABDOMINALES)
        String tituloEjercicioVideoAbd = informacion.getString("tituloGrupoMuscular");
        String nombreVideoAbd1 = informacion.getString("tituloNombreEjercicio1");
        String nombreVideoAbd2 = informacion.getString("tituloNombreEjercicio2");
        String nombreVideoAbd3 = informacion.getString("tituloNombreEjercicio3");
        String nombreVideoAbd4 = informacion.getString("tituloNombreEjercicio4");
        String nombreVideoAbd5 = informacion.getString("tituloNombreEjercicio5");

        //Creamos la variable para albergar la información mediante el key (CARDIO)
        String tituloEjercicioVideoCar = informacion.getString("tituloGrupoMuscular");
        String nombreVideoCar1 = informacion.getString("tituloNombreEjercicio1");
        String nombreVideoCar2 = informacion.getString("tituloNombreEjercicio2");
        String nombreVideoCar3 = informacion.getString("tituloNombreEjercicio3");
        String nombreVideoCar4 = informacion.getString("tituloNombreEjercicio4");
        String nombreVideoCar5 = informacion.getString("tituloNombreEjercicio5");


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



        //Si la información que enviamos no está vacía, entonces que ponga el texto (PARA INFERIORES)
        if(nombreVideoInf1!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoInf);
            nombreEjercicio.setText(nombreVideoInf1);
        }

        if(nombreVideoInf2!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoInf);
            nombreEjercicio.setText(nombreVideoInf2);
        }

        if(nombreVideoInf3!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoInf);
            nombreEjercicio.setText(nombreVideoInf3);
        }

        if(nombreVideoInf4!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoInf);
            nombreEjercicio.setText(nombreVideoInf4);
        }

        if(nombreVideoInf5!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoInf);
            nombreEjercicio.setText(nombreVideoInf5);
        }

        //Si la información que enviamos no está vacía, entonces que ponga el texto (PARA ABDOMINALES)
        if(nombreVideoAbd1!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoAbd);
            nombreEjercicio.setText(nombreVideoAbd1);
        }

        if(nombreVideoAbd2!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoAbd);
            nombreEjercicio.setText(nombreVideoAbd2);
        }

        if(nombreVideoAbd3!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoAbd);
            nombreEjercicio.setText(nombreVideoAbd3);
        }

        if(nombreVideoAbd4!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoAbd);
            nombreEjercicio.setText(nombreVideoAbd4);
        }

        if(nombreVideoAbd5!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoAbd);
            nombreEjercicio.setText(nombreVideoAbd5);
        }

        //Si la información que enviamos no está vacía, entonces que ponga el texto (PARA CARDIO)
        if(nombreVideoCar1!= null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoCar);
            nombreEjercicio.setText(nombreVideoCar1);
        }

        if(nombreVideoCar2!= null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoCar);
            nombreEjercicio.setText(nombreVideoCar2);
        }

        if(nombreVideoCar3!= null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoCar);
            nombreEjercicio.setText(nombreVideoCar3);
        }

        if(nombreVideoCar4!= null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoCar);
            nombreEjercicio.setText(nombreVideoCar4);
        }

        if(nombreVideoCar5!= null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoCar);
            nombreEjercicio.setText(nombreVideoCar5);
        }


    } //Llave de cierre del OnCreate

    public void Volver(View vista){
        onBackPressed();
    }
}
