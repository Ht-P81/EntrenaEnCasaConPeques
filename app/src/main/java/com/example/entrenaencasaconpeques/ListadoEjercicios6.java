package com.example.entrenaencasaconpeques;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        //Creamos las variables para asignar funcionalidad a los botones
        Button botonVerEjercicio1 = (Button) findViewById(R.id.Btn_VerEjercicio1);
        Button botonVerEjercicio2 = (Button) findViewById(R.id.Btn_VerEjercicio2);
        Button botonVerEjercicio3 = (Button) findViewById(R.id.Btn_VerEjercicio3);
        Button botonVerEjercicio4 = (Button) findViewById(R.id.Btn_VerEjercicio4);
        Button botonVerEjercicio5 = (Button) findViewById(R.id.Btn_VerEjercicio5);


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



        //Si la información que enviamos no está vacía, entonces que ponga el texto enviado (SUPERIORES)
        if(tituloEjercicioSup!=null){
            //le colocamos texto al TextView del titulo de la actividad
           tituloEjercicio.setText("Ejercicios " + tituloEjercicioSup);
           //Le colocamos nombre a los ejercicios de la actividad
           nombreEjercicios1.setText(nombreEjercicioSup1);
           nombreEjercicios2.setText(nombreEjercicioSup2);
           nombreEjercicios3.setText(nombreEjercicioSup3);
           nombreEjercicios4.setText(nombreEjercicioSup4);
           nombreEjercicios5.setText(nombreEjercicioSup5);

             //Metemos la funcionalidad del boton "Btn_VerEjercicio1" aquí (SECCION SUPERIORES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
           botonVerEjercicio1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo1 = new Intent (ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo1.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo1.putExtra("tituloNombreEjercicio", "Push Up");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo1);
                }
            });

             //Metemos la funcionalidad del boton "Btn_VerEjercicio2" (SECCION SUPERIORES) aquí para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo2 = new Intent (ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo2.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo2.putExtra("tituloNombreEjercicio", "Fondo en silla");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo2);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio3" aquí (SECCION SUPERIORES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo3 = new Intent(ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo3.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo3.putExtra("tituloNombreEjercicio", "Push Up One Leg");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo3);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio4" aquí (SECCION SUPERIORES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo4 = new Intent(ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo4.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo4.putExtra("tituloNombreEjercicio", "Superman");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo4);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio5" aquí (SECCION SUPERIORES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo5 = new Intent(ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo5.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo5.putExtra("tituloNombreEjercicio", "Burpees");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo5);
                }
            });
        }



        //Si la información que enviamos no está vacía, entonces que ponga el texto enviado (INFERIORES)
        if(tituloEjercicioInf!=null){
            //le colocamos texto al TextView del titulo de la actividad
            tituloEjercicio.setText("Ejercicios " + tituloEjercicioInf);
            //Le colocamos nombre a los ejercicios de la actividad
            nombreEjercicios1.setText(nombreEjercicioInf1);
            nombreEjercicios2.setText(nombreEjercicioInf2);
            nombreEjercicios3.setText(nombreEjercicioInf3);
            nombreEjercicios4.setText(nombreEjercicioInf4);
            nombreEjercicios5.setText(nombreEjercicioInf5);

            //Metemos la funcionalidad del boton "Btn_VerEjercicio1" aquí (SECCION INFERIOES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo1 = new Intent (ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo1.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo1.putExtra("tituloNombreEjercicio", "Squats");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo1);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio2" aquí (SECCION INFERIOES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo2 = new Intent (ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo2.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo2.putExtra("tituloNombreEjercicio", "Jump Squats");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo2);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio3" aquí (SECCION INFERIOES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo3 = new Intent (ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo3.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo3.putExtra("tituloNombreEjercicio", "Lunges");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo3);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio4" aquí (SECCION INFERIOES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo4 = new Intent (ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo4.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo4.putExtra("tituloNombreEjercicio", "Patinador");
                    //se inicia el intent
                    startActivity(intentMuestraVideo4);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio5" aquí (SECCION INFERIOES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo5 = new Intent(ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo5.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo5.putExtra("tituloNombreEjercicio", "Wall Sit");
                    //se inicia el intent
                    startActivity(intentMuestraVideo5);
                }
            });
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

            //Metemos la funcionalidad del boton "Btn_VerEjercicio1" aquí (SECCION ABDOMINALES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo1 = new Intent (ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo1.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo1.putExtra("tituloNombreEjercicio", "Plancha");
                    //se inicia el intent
                    startActivity(intentMuestraVideo1);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio2" aquí (SECCION ABDOMINALES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo2 = new Intent(ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo2.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo2.putExtra("tituloNombreEjercicio", "Crunch");
                    //se inicia el intent
                    startActivity(intentMuestraVideo2);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio3" aquí (SECCION ABDOMINALES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo3 = new Intent(ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo3.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo3.putExtra("tituloNombreEjercicio", "Crunch Inverso");
                    //se inicia el intent
                    startActivity(intentMuestraVideo3);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio4" aquí (SECCION ABDOMINALES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo4 = new Intent(ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo4.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo4.putExtra("tituloNombreEjercicio", "Codo Rodilla");
                    //se inicia el intent
                    startActivity(intentMuestraVideo4);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio5" aquí (SECCION ABDOMINALES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo5 = new Intent(ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo5.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo5.putExtra("tituloNombreEjercicio", "Mountain Climbers");
                    //se inicia el intent
                    startActivity(intentMuestraVideo5);
                }
            });
        }

        //Si la información que enviamos no está vacía, entonces que ponga el texto (CARDIO)
        if(tituloEjercicioCar!=null){
            //le colocamos texto al TextView del titulo de la actividad
            tituloEjercicio.setText("Ejercicios " + tituloEjercicioCar);
            //Le colocamos nombre a los ejercicios de la actividad
            nombreEjercicios1.setText(nombreEjercicioCar1);
            nombreEjercicios2.setText(nombreEjercicioCar2);
            nombreEjercicios3.setText(nombreEjercicioCar3);
            nombreEjercicios4.setText(nombreEjercicioCar4);
            nombreEjercicios5.setText(nombreEjercicioCar5);

            //Metemos la funcionalidad del boton "Btn_VerEjercicio1" aquí (SECCION CARDIO) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo1 = new Intent (ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo1.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo1.putExtra("tituloNombreEjercicio", "Jumping Jacks");
                    //se inicia el intent
                    startActivity(intentMuestraVideo1);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio2" aquí (SECCION CARDIO) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo2 = new Intent (ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo2.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo2.putExtra("tituloNombreEjercicio", "High Knees");
                    //se inicia el intent
                    startActivity(intentMuestraVideo2);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio3" aquí (SECCION CARDIO) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo3 = new Intent (ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo3.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo3.putExtra("tituloNombreEjercicio", "Salto Comba");
                    //se inicia el intent
                    startActivity(intentMuestraVideo3);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio1" aquí (SECCION CARDIO) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo4 = new Intent (ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo4.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo4.putExtra("tituloNombreEjercicio", "Boxing");
                    //se inicia el intent
                    startActivity(intentMuestraVideo4);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio1" aquí (SECCION CARDIO) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            botonVerEjercicio5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo5 = new Intent (ListadoEjercicios6.this, VideoEjercicio7.class);
                    intentMuestraVideo5.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo5.putExtra("tituloNombreEjercicio", "Stand and Box");
                    //se inicia el intent
                    startActivity(intentMuestraVideo5);
                }
            });
        }

    }//Llave de cierre del Oncreate


    public void Volver(View vista){
        onBackPressed();
    }
}
