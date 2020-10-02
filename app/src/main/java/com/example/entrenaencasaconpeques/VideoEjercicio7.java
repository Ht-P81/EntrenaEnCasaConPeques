package com.example.entrenaencasaconpeques;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoEjercicio7 extends AppCompatActivity {

    //Creamos la variable para video de tipo VideoView
    private VideoView videoEjercicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_ejercicio7);

        //Declaramos las variables que se equipararán a los componentes de la actividad (TextView)
        TextView grupoMuscular = (TextView) findViewById(R.id.TV_Ejercicios);

        //Declaramos las variables que se equipararán a los componentes de la actividad (CheckBox)
        TextView nombreEjercicio = (TextView) findViewById(R.id.TV_nombreEjercicioVideo);

        //Declaramos las variables que se equipararán a los componentes de la actividad (VideoView)
        videoEjercicio = findViewById(R.id.vV_VideoEjercicio);

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
        if(nombreVideoSup!=null) {
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoSup);
            nombreEjercicio.setText(nombreVideoSup);

            if(nombreVideoSup.contentEquals("Push Up")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.pexels_pushupmovavi;
                //Creamos un objeto de tipo Uri que son los relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de vídeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start(); //peta por las dimensiones del video debe ser más pequeño

            } else if (nombreVideoSup.contentEquals("Burpees")) {
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.pexels_burpess_movavi;
                //Creamos un objeto de tipo Uri que son los relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de vídeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start(); //peta por las dimensiones del video debe ser más pequeño
            }
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

            if (nombreVideoCar.contentEquals("Jumping Jacks")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.pexels_jumpingjacks_movavi;
                //Creamos un objeto de tipo Uri que son los relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de vídeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start(); //peta por las dimensiones del video debe ser más pequeño

            }
        }

    } //Llave de cierre del OnCreate

    public void Volver(View vista){
        onBackPressed();
    }
}
