package com.example.entrenaencasaconpeques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Creamos las variables donde vamos a equiparar a etiquetas y botones para darle funcionalidad lógica a
        //las actividades
        Button botonSuperiores = (Button) findViewById(R.id.btn_BotonSuperiores);
        Button botonInferiores = (Button) findViewById(R.id.btn_BotonInferiores);
        Button botonAbdominales = (Button) findViewById(R.id.btn_BotonAbdominales);
        Button botonCardio = (Button) findViewById(R.id.btn_BotonCardio);

        //Para el botón salir de la aplicación
        final ImageButton boton_apagar = (ImageButton) findViewById(R.id.ibtn_BotonApagar);

        //Metodo OnClick con intent para ir de una actividad a otra y con bundles para pasar información (SUPERIORES)
        botonSuperiores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el intent
                Intent intentBotonSuperiores = new Intent(MainActivity.this, ListadoEjercicios6.class);
                //Mediante el método put Extra introducimos la información que se recogerá en la actividad destino.
                intentBotonSuperiores.putExtra("tituloEtiquetaSuperiores", "Superiores");
                intentBotonSuperiores.putExtra("nombreEjercicioSuperior1", "Push Up");
                intentBotonSuperiores.putExtra("nombreEjercicioSuperior2", "Fondo en silla");
                intentBotonSuperiores.putExtra("nombreEjercicioSuperior3", "Push Up One Leg");
                intentBotonSuperiores.putExtra("nombreEjercicioSuperior4", "Superman");
                intentBotonSuperiores.putExtra("nombreEjercicioSuperior5", "Burpees");
                //Se inicia el intent
                startActivity(intentBotonSuperiores);
            }
        });

        //Metodo OnClick con intent para ir de una actividad a otra y con bundles para pasar información (INFERIORES)
        botonInferiores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el intent
                Intent intentBotonInferiores = new Intent (MainActivity.this, ListadoEjercicios6.class);
                intentBotonInferiores.putExtra("tituloEtiquetaInferiores", "Inferiores");
                intentBotonInferiores.putExtra("nombreEjercicioInferior1", "Squats");
                intentBotonInferiores.putExtra("nombreEjercicioInferior2", "Jump Squats");
                intentBotonInferiores.putExtra("nombreEjercicioInferior3", "Lunges");
                intentBotonInferiores.putExtra("nombreEjercicioInferior4", "Patinador");
                intentBotonInferiores.putExtra("nombreEjercicioInferior5", "Wall Sit");
                //Se inicia el intent
                startActivity(intentBotonInferiores);
            }
        });

        //Metodo OnClick con intent para ir de una actividad a otra y con bundles para pasar información (ABDOMINALES)
        botonAbdominales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBotonAbdominales = new Intent ( MainActivity.this, ListadoEjercicios6.class);
                intentBotonAbdominales.putExtra("tituloEtiquetaAbdominales", "Abdominales");
                intentBotonAbdominales.putExtra("nombreEjercicioAbdominal1", "Plancha");
                intentBotonAbdominales.putExtra("nombreEjercicioAbdominal2", "Crunch");
                intentBotonAbdominales.putExtra("nombreEjercicioAbdominal3", "Crunch Inverso");
                intentBotonAbdominales.putExtra("nombreEjercicioAbdominal4", "Codo Rodilla");
                intentBotonAbdominales.putExtra("nombreEjercicioAbdominal5", "Mountain Climbers");
                //Se inicia el intent
                startActivity(intentBotonAbdominales);
            }
        });

        //Metodo OnClick con intent para ir de una actividad a otra y con bundles para pasar información (CARDIO)
        botonCardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBotonCardio = new Intent(MainActivity.this, ListadoEjercicios6.class);
                intentBotonCardio.putExtra("tituloEtiquetaCardio", "Cardio");
                intentBotonCardio.putExtra("nombreEjercicioCardio1", "Jumping Jacks");
                intentBotonCardio.putExtra("nombreEjercicioCardio2", "High Knees");
                intentBotonCardio.putExtra("nombreEjercicioCardio3", "Salto Comba");
                intentBotonCardio.putExtra("nombreEjercicioCardio4", "Boxing");
                intentBotonCardio.putExtra("nombreEjercicioCardio5", "Stand and Box");
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
    }//Llave del OnCreate

    //Diferentes Intents para ir a la lista de Ejercicios 6 en sus correspondientes grupos musculares
    //Intent para ir desde el boton Hiit info hasta la actividad hiit Info 8
    public void botonHiitInfo(View vista) {
        Intent intenthiitinfo = new Intent(this, HiitInfo8.class);
        startActivity(intenthiitinfo);
    }

    //Intent para ir desde el boton Hiit Trainning hasta la actividad hiit Trainning 9
    public void botonHiitTrainning(View vista) {
        Intent intentTrainning = new Intent(this, HiitTrainning9.class);
        startActivity(intentTrainning);
        Toast.makeText(this, "¡A Entrenar!", Toast.LENGTH_SHORT).show();
    }

    //Intent para ir desde el boton perfil hasta la actividad perfil_usuario 10
    public void botonPerfil(View vista) {
        Intent intentPerfil = new Intent(this, PerfilUsuario10.class);
        startActivity(intentPerfil);
    }
}
