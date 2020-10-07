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
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.push_up;
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

                videoEjercicio.start();

            } else if (nombreVideoSup.contentEquals("Fondo en silla")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.fondo_en_silla;
                //Creamos un objeto de tipo Uri que son las relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de víeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start();

            } else if (nombreVideoSup.contentEquals("Push Up One Leg")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.push_up_one_leg;
                //Creamos un objeto de tipo Uri que son las relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de víeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start();

            } else if (nombreVideoSup.contentEquals("Superman")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.superman;
                //Creamos un objeto de tipo Uri que son las relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de víeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start();

            } else if (nombreVideoSup.contentEquals("Burpees")) {
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.burpees;
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

                videoEjercicio.start();
            }
        }


        //Si la información que enviamos no está vacía, entonces que ponga el texto (PARA INFERIORES)
        if(nombreVideoInf!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoInf);
            nombreEjercicio.setText(nombreVideoInf);

            if(nombreVideoInf.contentEquals("Squats")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.squats;
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

                videoEjercicio.start();

            } else if (nombreVideoInf.contentEquals("Jump Squats")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.jumpsquats;
                //Creamos un objeto de tipo Uri que son las relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de víeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start();

            } else if (nombreVideoInf.contentEquals("Lunges")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.lunges;
                //Creamos un objeto de tipo Uri que son las relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de víeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start();

            } else if (nombreVideoInf.contentEquals("Patinador")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.patinador;
                //Creamos un objeto de tipo Uri que son las relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de víeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start();

            } else if (nombreVideoInf.contentEquals("Wall Sit")) {
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.wall_sit;
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

                videoEjercicio.start();
            }

        }


        //Si la información que enviamos no está vacía, entonces que ponga el texto (PARA ABDOMINALES)
        if(nombreVideoAbd!=null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoAbd);
            nombreEjercicio.setText(nombreVideoAbd);

            if(nombreVideoAbd.contentEquals("Plancha")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.plancha;
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

                videoEjercicio.start();

            } else if (nombreVideoAbd.contentEquals("Crunch")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.crunch;
                //Creamos un objeto de tipo Uri que son las relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de víeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start();

            } else if (nombreVideoAbd.contentEquals("Crunch Inverso")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.cruch_inverso;
                //Creamos un objeto de tipo Uri que son las relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de víeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start();

            } else if (nombreVideoAbd.contentEquals("Codo Rodilla")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.codo_rodilla;
                //Creamos un objeto de tipo Uri que son las relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de víeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start();

            } else if (nombreVideoAbd.contentEquals("Mountain Climbers")) {
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.mountain_climbers;
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

                videoEjercicio.start();
            }
        }


        //Si la información que enviamos no está vacía, entonces que ponga el texto (PARA CARDIO)
        if(nombreVideoCar!= null){
            grupoMuscular.setText("Ejercicios " + tituloEjercicioVideoCar);
            nombreEjercicio.setText(nombreVideoCar);

            if(nombreVideoCar.contentEquals("Jumping Jacks")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.jumping_jacks;
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

                videoEjercicio.start();

            } else if (nombreVideoCar.contentEquals("High Knees")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.high_knee;
                //Creamos un objeto de tipo Uri que son las relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de víeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start();

            } else if (nombreVideoCar.contentEquals("Salto Comba")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.salto_comba;
                //Creamos un objeto de tipo Uri que son las relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de víeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start();

            } else if (nombreVideoCar.contentEquals("Boxing")){
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.boxing;
                //Creamos un objeto de tipo Uri que son las relacionados para video
                Uri uri = Uri.parse(ruta_videoEjercicio);
                videoEjercicio.setVideoURI(uri);

                //Botones de reproducción de víeo de la API de Android
                MediaController botonesReproduccion = new MediaController(this);
                videoEjercicio.setMediaController(botonesReproduccion);

                //Asignar loop al vídeo
                videoEjercicio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });

                videoEjercicio.start();

            } else if (nombreVideoCar.contentEquals("Stand and Box")) {
                //Creamos el String que recogerá el directorio de almacenamiento del vídeo que se muestre
                String ruta_videoEjercicio = "android.resource://" + getPackageName() + "/" + R.raw.stand_and_box;
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

                videoEjercicio.start();
            }

        }

    } //Llave de cierre del OnCreate

    public void Volver(View vista){
        onBackPressed();
    }
}
