package com.example.entrenaencasaconpeques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Creamos las variables donde vamos a equiparar a etiquetas y botones para darle funcionalidad lógica a
    //las actividades
    Button mbotonSuperiores;
    Button mbotonInferiores;
    Button mbotonAbdominales;
    Button mbotonCardio;
    //
    Button mbotonHiitTrainning;
    //

    //Creamos las variables de tipo ArrayList<String> para recorrer los diferentes grupos musculares y enviar la información contenida a HiitTrainning
    //
    private ArrayList<String> ejerciciosSuperiores, ejerciciosInferiores, ejerciciosAbdominales, ejerciciosCardio;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Mapeamos las variables donde vamos a equiparar a etiquetas y botones para darle funcionalidad lógica a
        //las actividades
        mbotonSuperiores = findViewById(R.id.btn_BotonSuperiores);
        mbotonInferiores = findViewById(R.id.btn_BotonInferiores);
        mbotonAbdominales = findViewById(R.id.btn_BotonAbdominales);
        mbotonCardio = findViewById(R.id.btn_BotonCardio);
        //
        mbotonHiitTrainning = findViewById(R.id.btn_botonHiitTrainning);
        //

        //Inicializamos los arrayslist
        //
        ejerciciosSuperiores = new ArrayList<>();
        ejerciciosInferiores = new ArrayList<>();
        ejerciciosAbdominales = new ArrayList<>();
        ejerciciosCardio = new ArrayList<>();
        //

        //Para el botón salir de la aplicación
        final ImageButton boton_apagar = findViewById(R.id.ibtn_BotonApagar);

        //Metodo OnClick con intent para ir de una actividad a otra y con bundles para pasar información (SUPERIORES)
        mbotonSuperiores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el intent
                Intent intentBotonSuperiores = new Intent(MainActivity.this, ListadoEjercicios6.class);

                //Mediante el método put Extra introducimos la información que se recogerá en la actividad destino.
                intentBotonSuperiores.putExtra("tituloEtiquetaSup", "Superiores");
                intentBotonSuperiores.putExtra("nombreEjercicioSup1", "Push Up");
                intentBotonSuperiores.putExtra("nombreEjercicioSup2", "Fondo en silla");
                intentBotonSuperiores.putExtra("nombreEjercicioSup3", "Push Up One Leg");
                intentBotonSuperiores.putExtra("nombreEjercicioSup4", "Superman");
                intentBotonSuperiores.putExtra("nombreEjercicioSup5", "Burpees");
                //Debemos incluir una línea que se ajuste al tipo de Ejercicio con un valor correspondiente a su grupo muscular
                //
                intentBotonSuperiores.putExtra("tipoEjercicios", "superiores");
                //

                //Se inicia el intent
                startActivity(intentBotonSuperiores);
            }
        });


        //Metodo OnClick con intent para ir de una actividad a otra y con bundles para pasar información (INFERIORES)
        mbotonInferiores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creamos el intent
                Intent intentBotonInferiores = new Intent (MainActivity.this, ListadoEjercicios6.class);
                intentBotonInferiores.putExtra("tituloEtiquetaInf", "Inferiores");
                intentBotonInferiores.putExtra("nombreEjercicioInf1", "Squats");
                intentBotonInferiores.putExtra("nombreEjercicioInf2", "Jump Squats");
                intentBotonInferiores.putExtra("nombreEjercicioInf3", "Lunges");
                intentBotonInferiores.putExtra("nombreEjercicioInf4", "Patinador");
                intentBotonInferiores.putExtra("nombreEjercicioInf5", "Wall Sit");
                //Debemos incluir una línea que se ajuste al tipo de Ejercicio con un valor correspondiente a su grupo muscular
                //
                intentBotonInferiores.putExtra("tipoEjercicios", "inferiores");
                //

                //Se inicia el intent
                startActivity(intentBotonInferiores);
            }
        });


        //Metodo OnClick con intent para ir de una actividad a otra y con bundles para pasar información (ABDOMINALES)
        mbotonAbdominales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creamos el intent
                Intent intentBotonAbdominales = new Intent ( MainActivity.this, ListadoEjercicios6.class);
                intentBotonAbdominales.putExtra("tituloEtiquetaAb", "Abdominales");
                intentBotonAbdominales.putExtra("nombreEjercicioAb1", "Plancha");
                intentBotonAbdominales.putExtra("nombreEjercicioAb2", "Crunch");
                intentBotonAbdominales.putExtra("nombreEjercicioAb3", "Crunch Inverso");
                intentBotonAbdominales.putExtra("nombreEjercicioAb4", "Codo Rodilla");
                intentBotonAbdominales.putExtra("nombreEjercicioAb5", "Mountain Climbers");
                //Debemos incluir una línea que se ajuste al tipo de Ejercicio con un valor correspondiente a su grupo muscular
                //
                intentBotonAbdominales.putExtra("tipoEjercicios", "abdominales");
                //


                //Se inicia el intent
                startActivity(intentBotonAbdominales);
            }
        });

        //Metodo OnClick con intent para ir de una actividad a otra y con bundles para pasar información (CARDIO)
        mbotonCardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creamos el intent
                Intent intentBotonCardio = new Intent(MainActivity.this, ListadoEjercicios6.class);
                intentBotonCardio.putExtra("tituloEtiquetaCar", "Cardio");
                intentBotonCardio.putExtra("nombreEjercicioCar1", "Jumping Jacks");
                intentBotonCardio.putExtra("nombreEjercicioCar2", "High Knees");
                intentBotonCardio.putExtra("nombreEjercicioCar3", "Salto Comba");
                intentBotonCardio.putExtra("nombreEjercicioCar4", "Boxing");
                intentBotonCardio.putExtra("nombreEjercicioCar5", "Stand and Box");
                //Debemos incluir una línea que se ajuste al tipo de Ejercicio con un valor correspondiente a su grupo muscular
                //
                intentBotonCardio.putExtra("tipoEjercicios", "cardio");
                //

                //Se inicia el intent
                startActivity(intentBotonCardio);

            }
        });

        //Metodo para salir de la aplicación
        boton_apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    finish();
                    Intent intentsalir = new Intent(Intent.ACTION_MAIN);
                    intentsalir.addCategory(Intent.CATEGORY_HOME);
                    intentsalir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intentsalir);
                }
        });

        //Recepcionamos el bundle envíado desde Lista_Ejercicios con los ejercicios seleccionados por el usuario
        //
        Bundle informacion = getIntent().getExtras();
        //

        //TODO: INCORPORAR SHARED PREFERENCES

        //Aplicamos los condicinales que decanten el key para asignárselos a los arrayList y
        // nos den la información de ListadoEjercicios6 (los checkboxs que el usuario ha elegido)
        //
        if(informacion != null) {
            if (informacion.getStringArrayList("superiores") != null) {
                ejerciciosSuperiores = informacion.getStringArrayList("superiores");
            }

            if (informacion.getStringArrayList("inferiores") != null) {
                ejerciciosInferiores = informacion.getStringArrayList("inferiores");
            }
            if (informacion.getStringArrayList("abdominales") != null){
                ejerciciosAbdominales = informacion.getStringArrayList("abdominales");
            }
            if (informacion.getStringArrayList("cardio") != null){
                ejerciciosCardio = informacion.getStringArrayList("cardio");
            }
        }
        //

        //desarrollar un setOnclick con el botonHiitTrainning y quitar el otro método
        //
        mbotonHiitTrainning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ejerciciosSuperiores.size() !=0 || ejerciciosInferiores.size() !=0 || ejerciciosAbdominales.size() !=0 || ejerciciosCardio.size() !=0){

                    //Creamos un intent
                    Intent intentEntrenar = new Intent (MainActivity.this, HiitTrainning9.class);
                    //Con estos putExtra envíamos información a HiitTrainning9 con los ejercicios seleccionados por el usuario
                    intentEntrenar.putExtra("ejerciciosSuperiores", ejerciciosSuperiores);
                    intentEntrenar.putExtra("ejerciciosInferiores", ejerciciosInferiores);
                    intentEntrenar.putExtra("ejerciciosAbdominales", ejerciciosAbdominales);
                    intentEntrenar.putExtra("ejerciciosCardio", ejerciciosCardio);

                    //Iniciamos el intent
                    startActivity(intentEntrenar);

                    //Hacemos un comentario para darle Feeback al usuario
                    Toast.makeText(getApplicationContext(), "¡RECUERDA: Debemos calentar al menos 5 minutos!", Toast.LENGTH_LONG).show();

                }else{

                    //Hacemos un comentario para darle Feeback al usuario
                    Toast.makeText(getApplicationContext(), "Para empezar a entrenar debes seleccionar algún ejercicio", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //

    }//Llave del OnCreate


    //Intent para ir desde el boton Hiit info hasta la actividad hiit Info 8
    public void botonHiitInfo(View vista) {
        Intent intenthiitinfo = new Intent(this, HiitInfo8.class);
        startActivity(intenthiitinfo);
    }

    //Intent para ir desde el boton perfil hasta la actividad perfil_usuario 10
    public void botonPerfil(View vista) {
        Intent intentPerfil = new Intent(this, PerfilUsuario10.class);
        startActivity(intentPerfil);
    }
}
