package com.example.entrenaencasaconpeques;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListadoEjercicios6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_ejercicios6);

        //ESTABLECEMOS RELACIONES CON LOS COMPONENTES VISUALES ASIGNANDO VARIABLES

        //Creamos la variable para asignar al textView de TV_Ejercicios
        TextView tituloEjercicio = (TextView) findViewById(R.id.TV_Ejercicios);

        //Creamos las variables para asignar a los checkbok de Ejercicios
        CheckBox nombreEjercicios1 = (CheckBox) findViewById(R.id.ChBx_Ejercicio1);
        CheckBox nombreEjercicios2 = (CheckBox) findViewById(R.id.ChBx_Ejercicio2);
        CheckBox nombreEjercicios3 = (CheckBox) findViewById(R.id.ChBx_Ejercicio3);
        CheckBox nombreEjercicios4 = (CheckBox) findViewById(R.id.ChBx_Ejercicio4);
        CheckBox nombreEjercicios5 = (CheckBox) findViewById(R.id.ChBx_Ejercicio5);



        //Recepcionamos el bundle envíado desde el activity_main
        Bundle informacion = getIntent().getExtras();

        //Creamos la variable para albergar la información mediante el key (SUPERIORES)
        String tituloEjercicioSup = informacion.getString("tituloEtiquetaSuperiores");
        String nombreEjercicioSup1 = informacion.getString("nombreEjercicioSuperior1");
        String nombreEjercicioSup2 = informacion.getString("nombreEjercicioSuperior2");
        String nombreEjercicioSup3 = informacion.getString("nombreEjercicioSuperior3");
        String nombreEjercicioSup4 = informacion.getString("nombreEjercicioSuperior4");
        String nombreEjercicioSup5 = informacion.getString("nombreEjercicioSuperior5");

        //Creamos la variable para albergar la información mediante el key (INFERIORES)
        String tituloEjercicioInf = informacion.getString("tituloEtiquetaInferiores");
        String nombreEjercicioInf1 = informacion.getString("nombreEjercicioInferior1");
        String nombreEjercicioInf2 = informacion.getString("nombreEjercicioInferior2");
        String nombreEjercicioInf3 = informacion.getString("nombreEjercicioInferior3");
        String nombreEjercicioInf4 = informacion.getString("nombreEjercicioInferior4");
        String nombreEjercicioInf5 = informacion.getString("nombreEjercicioInferior5");

        //Creamos la variable para albergar la informacion mediante el key (ABDOMINALES)
        String tituloEjercicioAbd = informacion.getString("tituloEtiquetaAbdominales");
        String nombreEjercicioAbd1 = informacion.getString("nombreEjercicioAbdominal1");
        String nombreEjercicioAbd2 = informacion.getString("nombreEjercicioAbdominal2");
        String nombreEjercicioAbd3 = informacion.getString("nombreEjercicioAbdominal3");
        String nombreEjercicioAbd4 = informacion.getString("nombreEjercicioAbdominal4");
        String nombreEjercicioAbd5 = informacion.getString("nombreEjercicioAbdominal5");

        //Creamos la variable para albergar la informacion mediante el key (CARDIO)
        String tituloEjercicioCar = informacion.getString("tituloEtiquetaCardio");
        String nombreEjercicioCar1 = informacion.getString("nombreEjercicioCardio1");
        String nombreEjercicioCar2 = informacion.getString("nombreEjercicioCardio2");
        String nombreEjercicioCar3 = informacion.getString("nombreEjercicioCardio3");
        String nombreEjercicioCar4 = informacion.getString("nombreEjercicioCardio4");
        String nombreEjercicioCar5 = informacion.getString("nombreEjercicioCardio5");


        //Si la información que enviamos no está vacía, entonces que ponga el texto (SUPERIORES)
        if(tituloEjercicioSup!=null){
            //le colocamos texto al TextView del titulo de la actividad
           tituloEjercicio.setText("Ejercicios " + tituloEjercicioSup);
           //Le colocamos nombre a los ejercicios de la actividad
           nombreEjercicios1.setText(nombreEjercicioSup1);
           nombreEjercicios2.setText(nombreEjercicioSup2);
           nombreEjercicios3.setText(nombreEjercicioSup3);
           nombreEjercicios4.setText(nombreEjercicioSup4);
           nombreEjercicios5.setText(nombreEjercicioSup5);
        }

        //Si la información que enviamos no está vacía, entonces que ponga el texto (INFERIORES)
        if(tituloEjercicioInf!=null){
            //le colocamos texto al TextView del titulo de la actividad
            tituloEjercicio.setText("Ejercicios " + tituloEjercicioInf);
            //Le colocamos nombre a los ejercicios de la actividad
            nombreEjercicios1.setText(nombreEjercicioInf1);
            nombreEjercicios2.setText(nombreEjercicioInf2);
            nombreEjercicios3.setText(nombreEjercicioInf3);
            nombreEjercicios4.setText(nombreEjercicioInf4);
            nombreEjercicios5.setText(nombreEjercicioInf5);
        }

        //Si la información que enviamos no está vacía, entonces que ponga el texto (ABDOMINALES)
        if(tituloEjercicioAbd!=null){
            //le colocamos texto al TextView del titulo de la actividad
            tituloEjercicio.setText("Ejercicios " + tituloEjercicioAbd);
            //Le colocamos nombre a los ejercicios de la actividad
            nombreEjercicios1.setText(nombreEjercicioAbd1);
            nombreEjercicios2.setText(nombreEjercicioAbd2);
            nombreEjercicios3.setText(nombreEjercicioAbd3);
            nombreEjercicios4.setText(nombreEjercicioAbd4);
            nombreEjercicios5.setText(nombreEjercicioAbd5);
        }

        //Si la información que enviamos no está vacía, entonces que ponga el texto (CARDIO)
        if(tituloEjercicioCar!=null){
            //le colocamos texto al TextView del titulo de la actividad
            tituloEjercicio.setText("Ejercicios" + tituloEjercicioCar);
            //Le colocamos nombre a los ejercicios de la actividad
            nombreEjercicios1.setText(nombreEjercicioCar1);
            nombreEjercicios2.setText(nombreEjercicioCar2);
            nombreEjercicios3.setText(nombreEjercicioCar3);
            nombreEjercicios4.setText(nombreEjercicioCar4);
            nombreEjercicios5.setText(nombreEjercicioCar5);
        }

    }//Llave de cierre del Oncreate

    //Intent para mostrar los ejercicios en la actividad 7
    public void VerEjercicio(View vista) {
        Intent VerEjercicio = new Intent(this, VideoEjercicio7.class);
        startActivity(VerEjercicio);
    }

    public void Volver(View vista){
        onBackPressed();
    }
}
