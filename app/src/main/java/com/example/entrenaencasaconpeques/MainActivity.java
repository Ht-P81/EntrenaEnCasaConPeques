package com.example.entrenaencasaconpeques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para el botón salir de la aplicación
        final ImageButton boton_apagar = (ImageButton) findViewById(R.id.BotonApagar);
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
    }

    //Diferentes Intents para ir a la lista de Ejercicios 6 en sus correspondientes grupos musculares
    // Agregamos varios métodos con el onclick correspondiente a todos los botones de ejercicios (Superiores, inferiores, abdominales, cardio)

    //para ir desde el botón SUPERIORES hasta la actividad que muestra el listado de ejercicios SUPERIORES
    public void botonListaEjerciciosSuperiores(View vista){
        Intent intentListaEjerciciosSuperiores = new Intent(this, ListadoEjercicios6superiores.class);
        startActivity(intentListaEjerciciosSuperiores);
        Toast.makeText(this, "Elijamos ejercicios", Toast.LENGTH_SHORT).show();
    }

    //para ir desde el botón INFERIORES hasta la actividad que muestra el listado de ejercicios INFERIORES
    public void botonListaEjerciciosInferiores(View vista){
        Intent intentListaEjerciciosInferiores = new Intent(this, ListadoEjercicios6inferiores.class);
        startActivity(intentListaEjerciciosInferiores);
        Toast.makeText(this, "Elijamos ejercicios", Toast.LENGTH_SHORT).show();
    }

    //para ir desde el botón ABDOMINALES hasta la actividad que muestra el listado de ejercicios ABDOMINALES
    public void botonListaEjerciciosAbdominales(View vista){
        Intent intentListaEjerciciosAbdominales = new Intent(this, ListadoEjercicios6abdominales.class);
        startActivity(intentListaEjerciciosAbdominales);
        Toast.makeText(this, "Elijamos ejercicios", Toast.LENGTH_SHORT).show();
    }

    
    //para ir desde el botón CARDIO hasta la actividad que muestra el listado de ejercicios CARDIO
    public void botonListaEjerciciosCardio(View vista){
        Intent intentListaEjerciciosCardio = new Intent(this, ListadoEjercicios6cardio.class);
        startActivity(intentListaEjerciciosCardio);
        Toast.makeText(this, "Elijamos ejercicios", Toast.LENGTH_SHORT).show();
    }

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
