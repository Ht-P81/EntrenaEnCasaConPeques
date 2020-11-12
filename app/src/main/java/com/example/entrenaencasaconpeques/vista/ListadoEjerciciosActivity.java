package com.example.entrenaencasaconpeques.vista;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.entrenaencasaconpeques.R;
import com.example.entrenaencasaconpeques.controlador.ConexionSQLite;
import com.example.entrenaencasaconpeques.modelo.Ejercicio;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class ListadoEjerciciosActivity extends AppCompatActivity {

    //Declaración de variables
    TextView mTituloEjercicio;
    //Variable de checkbox, en cada ListaEjercicios6 habra 5 ejercicios de cada grupo muscular
    CheckBox mNombreEjercicios1, mNombreEjercicios2, mNombreEjercicios3, mNombreEjercicios4, mNombreEjercicios5;
    //Variable de tipo button, para poder ver cada uno de los vídeos de los grupos muscular
    Button mBotonVerEjercicio1, mBotonVerEjercicio2, mBotonVerEjercicio3, mBotonVerEjercicio4, mBotonVerEjercicio5;
    //Variable de tipo button de nombre ENVIAR para enviar los ejercicios que seleccione el usuario
    Button mBotonEnviar;

    //Con estos arraylist guardamos la informacion de los ejercicios seleccionados por el usario que
    // se envia desde el bundle desde este actividad lista_ejercicios a al main activity de nuevo
    //Aqui declaramos ArrayList<String>nombreEjercicios, ArrayList<CheckBox> checkBoxes y string tipoEjercicios
    ArrayList <CheckBox> checkBoxes;
    Set<String> nombreEjercicios;
    String tipoEjercicios;
    //ArrayList<Ejerccio> ejercicios y Conexion SQLite
    ArrayList <Ejercicio> ejercicios;
    ConexionSQLite conexionSQLite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_ejercicios);

        //Aquí inicialimaos los ArrayList<String><CheckBox>
        /// SOLO EL ARRAY LIST NOMBRE EJERCICIOS LO DEBEMOS INICIALIZAR DE TIPO LINKEDHASHSET
        nombreEjercicios = new LinkedHashSet<>();
        checkBoxes = new ArrayList<>();
        ejercicios = new ArrayList<>();
        conexionSQLite = new ConexionSQLite(this);

        //ESTABLECEMOS RELACIONES DE MAPEO CON LOS COMPONENTES VISUALES ASIGNANDO VARIABLES
        //Creamos la variable para asignar al textView de TV_Ejercicios
        mTituloEjercicio = findViewById(R.id.TV_Ejercicios);

        //Creamos las variables para asignar a los checkbok de Ejercicios
        mNombreEjercicios1 = findViewById(R.id.ChBx_Ejercicio1);
        mNombreEjercicios2 = findViewById(R.id.ChBx_Ejercicio2);
        mNombreEjercicios3 = findViewById(R.id.ChBx_Ejercicio3);
        mNombreEjercicios4 = findViewById(R.id.ChBx_Ejercicio4);
        mNombreEjercicios5 = findViewById(R.id.ChBx_Ejercicio5);

        //Creamos las variables para asignar funcionalidad a los botones
        mBotonVerEjercicio1 = findViewById(R.id.Btn_VerEjercicio1);
        mBotonVerEjercicio2 = findViewById(R.id.Btn_VerEjercicio2);
        mBotonVerEjercicio3 = findViewById(R.id.Btn_VerEjercicio3);
        mBotonVerEjercicio4 = findViewById(R.id.Btn_VerEjercicio4);
        mBotonVerEjercicio5 = findViewById(R.id.Btn_VerEjercicio5);

        //Creamos las variables para asignar funcionalidad a los botones
        mBotonEnviar = findViewById(R.id.btn_EnviarListadoEjercicios);

        //Recepcionamos el bundle envíado desde el activity_main (poner títulos de nombre de ejercicios a los checkboxs)
        Bundle informacion = getIntent().getExtras();

        //Recojemos la información procedentes de cada onClink con los datos de los bundles (SUPERIORES)


        String tituloEjercicioSup = informacion.getString("tituloEtiqueta");
        String tituloEjercicioInf = informacion.getString("tituloEtiqueta");
        String tituloEjercicioAb = informacion.getString("tituloEtiqueta");
        String tituloEjercicioCar = informacion.getString("tituloEtiqueta");

        if (tituloEjercicioSup.equals("Superiores")){
            mTituloEjercicio.setText("Ejercicios " + tituloEjercicioSup);
        }else if (tituloEjercicioInf.equals("Inferiores")){
            mTituloEjercicio.setText("Ejercicios " + tituloEjercicioInf);
        }else if (tituloEjercicioAb.equals("Abdominales")){
            mTituloEjercicio.setText("Ejercicios " + tituloEjercicioAb);
        }else if(tituloEjercicioCar.equals("Cardio")){
            mTituloEjercicio.setText("Ejercicios " + tituloEjercicioCar);
        }

        /*String nombreEjercicioSup1 = informacion.getString("nombreEjercicioSup1");
        String nombreEjercicioSup2  = informacion.getString("nombreEjercicioSup2");
        String nombreEjercicioSup3 = informacion.getString("nombreEjercicioSup3");
        String nombreEjercicioSup4 = informacion.getString("nombreEjercicioSup4");
        String nombreEjercicioSup5 = informacion.getString("nombreEjercicioSup5");*/
        tipoEjercicios = informacion.getString("tipoEjercicios");

        //implementamos el método
        obtenerEjercicios(tipoEjercicios);

        //los añadimos al array de checkBoxes
        checkBoxes.add(mNombreEjercicios1);
        checkBoxes.add(mNombreEjercicios2);
        checkBoxes.add(mNombreEjercicios3);
        checkBoxes.add(mNombreEjercicios4);
        checkBoxes.add(mNombreEjercicios5);

        mBotonVerEjercicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            //If tipo ejercicios es igual a "Superior"

            public void onClick(View v) {
                if (tipoEjercicios.equals("Superiores")){
                    Intent intentMuestraVideo1 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo1.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo1.putExtra("tituloNombreEjercicio", "Push Up");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo1);
                }else if (tipoEjercicios.equals("Inferiores")){
                    Intent intentMuestraVideo1 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo1.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo1.putExtra("tituloNombreEjercicio", "Squats");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo1);
                }else if (tipoEjercicios.equals("Abdominales")){
                    Intent intentMuestraVideo1 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo1.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo1.putExtra("tituloNombreEjercicio", "Plancha");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo1);
                }else if(tipoEjercicios.equals("Cardio")){
                    Intent intentMuestraVideo1 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo1.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo1.putExtra("tituloNombreEjercicio", "Jumping Jacks");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo1);
                }
            }
        });

        //Metemos la funcionalidad del boton "Btn_VerEjercicio2" (SECCION SUPERIORES) aquí para que
        // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
        mBotonVerEjercicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tipoEjercicios.equals("Superiores")){
                    Intent intentMuestraVideo2 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo2.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo2.putExtra("tituloNombreEjercicio", "Fondo en silla");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo2);
                }else if (tipoEjercicios.equals("Inferiores")){
                    Intent intentMuestraVideo2 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo2.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo2.putExtra("tituloNombreEjercicio", "Jump Squats");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo2);
                }else if (tipoEjercicios.equals("Abdominales")){
                    Intent intentMuestraVideo2 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo2.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo2.putExtra("tituloNombreEjercicio", "Crunch");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo2);
                }else if(tipoEjercicios.equals("Cardio")){
                    Intent intentMuestraVideo2 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo2.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo2.putExtra("tituloNombreEjercicio", "High Knees");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo2);
                }
            }
        });

        //Metemos la funcionalidad del boton "Btn_VerEjercicio3" aquí (SECCION SUPERIORES) para que
        // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
        mBotonVerEjercicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tipoEjercicios.equals("Superiores")){
                    Intent intentMuestraVideo3 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo3.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo3.putExtra("tituloNombreEjercicio", "Push Up One Leg");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo3);
                }else if (tipoEjercicios.equals("Inferiores")){
                    Intent intentMuestraVideo3 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo3.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo3.putExtra("tituloNombreEjercicio", "Lunges");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo3);
                }else if (tipoEjercicios.equals("Abdominales")){
                    Intent intentMuestraVideo3 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo3.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo3.putExtra("tituloNombreEjercicio", "Crunch Inverso");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo3);
                }else if(tipoEjercicios.equals("Cardio")){
                    Intent intentMuestraVideo3 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo3.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo3.putExtra("tituloNombreEjercicio", "Salto Comba");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo3);
                }
            }
        });

        //Metemos la funcionalidad del boton "Btn_VerEjercicio4" aquí (SECCION SUPERIORES) para que
        // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
        mBotonVerEjercicio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tipoEjercicios.equals("Superiores")){
                    Intent intentMuestraVideo4 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo4.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo4.putExtra("tituloNombreEjercicio", "Superman");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo4);
                }else if (tipoEjercicios.equals("Inferiores")){
                    Intent intentMuestraVideo4 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo4.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo4.putExtra("tituloNombreEjercicio", "Patinador");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo4);
                }else if (tipoEjercicios.equals("Abdominales")){
                    Intent intentMuestraVideo4 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo4.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo4.putExtra("tituloNombreEjercicio", "Codo rodilla");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo4);
                }else if(tipoEjercicios.equals("Cardio")){
                    Intent intentMuestraVideo4 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo4.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo4.putExtra("tituloNombreEjercicio", "Boxing");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo4);
                }
            }
        });

        //Metemos la funcionalidad del boton "Btn_VerEjercicio5" aquí (SECCION SUPERIORES) para que
        // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
        mBotonVerEjercicio5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tipoEjercicios.equals("Superiores")){
                    Intent intentMuestraVideo5 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo5.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo5.putExtra("tituloNombreEjercicio", "Burpees");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo5);
                }else if (tipoEjercicios.equals("Inferiores")){
                    Intent intentMuestraVideo5 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo5.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo5.putExtra("tituloNombreEjercicio", "Wall Sit");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo5);
                }else if (tipoEjercicios.equals("Abdominales")){
                    Intent intentMuestraVideo5 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo5.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo5.putExtra("tituloNombreEjercicio", "Escalador");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo5);
                }else if(tipoEjercicios.equals("Cardio")){
                    Intent intentMuestraVideo5 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo5.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo5.putExtra("tituloNombreEjercicio", "Stand and Box");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo5);
                }
            }
        });

        //con un bucle for recorremos todo
        for (int i = 0; i< checkBoxes.size(); i++){
            checkBoxes.get(i).setText(ejercicios.get(i).getNombreEjercicio());
        }

        //Recojemos la información procedentes de cada onClink con los datos de los bundles (INFERIORES)
        /*String tituloEjercicioInf = informacion.getString("tituloEtiquetaInf");
        String nombreEjercicioInf1= informacion.getString("nombreEjercicioInf1");
        String nombreEjercicioInf2 = informacion.getString("nombreEjercicioInf2");
        String nombreEjercicioInf3 = informacion.getString("nombreEjercicioInf3");
        String nombreEjercicioInf4 = informacion.getString("nombreEjercicioInf4");
        String nombreEjercicioInf5 = informacion.getString("nombreEjercicioInf5");
        tipoEjercicios = informacion.getString("tipoEjercicios");*/

        //Recojemos la información procedentes de cada onClink con los datos de los bundles (ABDOMINALES)
        /*String tituloEjercicioAb = informacion.getString("tituloEtiquetaAb");
        String nombreEjercicioAb1= informacion.getString("nombreEjercicioAb1");
        String nombreEjercicioAb2 = informacion.getString("nombreEjercicioAb2");
        String nombreEjercicioAb3 = informacion.getString("nombreEjercicioAb3");
        String nombreEjercicioAb4 = informacion.getString("nombreEjercicioAb4");
        String nombreEjercicioAb5 = informacion.getString("nombreEjercicioAb5");
        tipoEjercicios = informacion.getString("tipoEjercicios");*/

        //Recojemos la información procedentes de cada onClink con los datos de los bundles (CARDIO)
        /*String tituloEjercicioCar = informacion.getString("tituloEtiquetaCar");
        String nombreEjercicioCar1= informacion.getString("nombreEjercicioCar1");
        String nombreEjercicioCar2 = informacion.getString("nombreEjercicioCar2");
        String nombreEjercicioCar3 = informacion.getString("nombreEjercicioCar3");
        String nombreEjercicioCar4 = informacion.getString("nombreEjercicioCar4");
        String nombreEjercicioCar5 = informacion.getString("nombreEjercicioCar5");
        tipoEjercicios = informacion.getString("tipoEjercicios");*/

        //Si la información que enviamos no está vacía, entonces que ponga el texto enviado (SUPERIORES)
        //RECORDEMOS QUE ESTE PRIMERO ES DE EJERCICIOS SUPERIORES
        /*if(tituloEjercicioSup!=null) {
            //le colocamos texto al TextView del titulo de la actividad
            mTituloEjercicio.setText("Ejercicios " + tituloEjercicioSup);
            //Le colocamos nombre a los ejercicios de la actividad
            mNombreEjercicios1.setText(nombreEjercicioSup1);
            mNombreEjercicios2.setText(nombreEjercicioSup2);
            mNombreEjercicios3.setText(nombreEjercicioSup3);
            mNombreEjercicios4.setText(nombreEjercicioSup4);
            mNombreEjercicios5.setText(nombreEjercicioSup5);

            //Se lo agregramos a nuestro array de checkboxes
            checkBoxes.add(mNombreEjercicios1);
            checkBoxes.add(mNombreEjercicios2);
            checkBoxes.add(mNombreEjercicios3);
            checkBoxes.add(mNombreEjercicios4);
            checkBoxes.add(mNombreEjercicios5);

             //Metemos la funcionalidad del boton "Btn_VerEjercicio1" aquí (SECCION SUPERIORES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
           mBotonVerEjercicio1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo1 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo1.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo1.putExtra("tituloNombreEjercicio", "Push Up");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo1);
                }
            });

             //Metemos la funcionalidad del boton "Btn_VerEjercicio2" (SECCION SUPERIORES) aquí para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo2 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo2.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo2.putExtra("tituloNombreEjercicio", "Fondo en silla");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo2);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio3" aquí (SECCION SUPERIORES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo3 = new Intent(ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo3.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo3.putExtra("tituloNombreEjercicio", "Push Up One Leg");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo3);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio4" aquí (SECCION SUPERIORES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo4 = new Intent(ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo4.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo4.putExtra("tituloNombreEjercicio", "Superman");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo4);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio5" aquí (SECCION SUPERIORES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo5 = new Intent(ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo5.putExtra("tituloGrupoMuscular", "Superiores");
                    intentMuestraVideo5.putExtra("tituloNombreEjercicio", "Burpees");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo5);
                }
            });
        }*/


        //Si la información que enviamos no está vacía, entonces que ponga el texto enviado (INFERIORES)
        //RECORDEMOS QUE ESTE SEGUNDO ES DE EJERCICIOS INFERIORES
        /*if(tituloEjercicioInf!=null) {
            //le colocamos texto al TextView del titulo de la actividad
            mTituloEjercicio.setText("Ejercicios " + tituloEjercicioInf);
            //Le colocamos nombre a los ejercicios de la actividad
            mNombreEjercicios1.setText(nombreEjercicioInf1);
            mNombreEjercicios2.setText(nombreEjercicioInf2);
            mNombreEjercicios3.setText(nombreEjercicioInf3);
            mNombreEjercicios4.setText(nombreEjercicioInf4);
            mNombreEjercicios5.setText(nombreEjercicioInf5);

            //Se lo agregramos a nuestro array de checkboxes
            checkBoxes.add(mNombreEjercicios1);
            checkBoxes.add(mNombreEjercicios2);
            checkBoxes.add(mNombreEjercicios3);
            checkBoxes.add(mNombreEjercicios4);
            checkBoxes.add(mNombreEjercicios5);

            //Metemos la funcionalidad del boton "Btn_VerEjercicio1" aquí (SECCION INFERIOES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo1 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo1.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo1.putExtra("tituloNombreEjercicio", "Squats");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo1);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio2" aquí (SECCION INFERIOES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo2 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo2.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo2.putExtra("tituloNombreEjercicio", "Jump Squats");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo2);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio3" aquí (SECCION INFERIOES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo3 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo3.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo3.putExtra("tituloNombreEjercicio", "Lunges");
                    //Se inicia el intent
                    startActivity(intentMuestraVideo3);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio4" aquí (SECCION INFERIOES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo4 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo4.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo4.putExtra("tituloNombreEjercicio", "Patinador");
                    //se inicia el intent
                    startActivity(intentMuestraVideo4);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio5" aquí (SECCION INFERIOES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo5 = new Intent(ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo5.putExtra("tituloGrupoMuscular", "Inferiores");
                    intentMuestraVideo5.putExtra("tituloNombreEjercicio", "Wall Sit");
                    //se inicia el intent
                    startActivity(intentMuestraVideo5);
                }
            });
        }*/


        //Si la información que enviamos no está vacía, entonces que ponga el texto (ABDOMINALES)
        //RECORDEMOS QUE ESTE TERCERO ES DE EJERCICIOS ABDOMINALES
        /*if(tituloEjercicioAb!=null){
            //le colocamos texto al TextView del titulo de la actividad
            mTituloEjercicio.setText("Ejercicios " + tituloEjercicioAb);
            //Le colocamos nombre a los ejercicios de la actividad
            mNombreEjercicios1.setText(nombreEjercicioAb1);
            mNombreEjercicios2.setText(nombreEjercicioAb2);
            mNombreEjercicios3.setText(nombreEjercicioAb3);
            mNombreEjercicios4.setText(nombreEjercicioAb4);
            mNombreEjercicios5.setText(nombreEjercicioAb5);

            //Se lo agregramos a nuestro array de checkboxes
            checkBoxes.add(mNombreEjercicios1);
            checkBoxes.add(mNombreEjercicios2);
            checkBoxes.add(mNombreEjercicios3);
            checkBoxes.add(mNombreEjercicios4);
            checkBoxes.add(mNombreEjercicios5);

            //Metemos la funcionalidad del boton "Btn_VerEjercicio1" aquí (SECCION ABDOMINALES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo1 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo1.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo1.putExtra("tituloNombreEjercicio", "Plancha");
                    //se inicia el intent
                    startActivity(intentMuestraVideo1);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio2" aquí (SECCION ABDOMINALES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo2 = new Intent(ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo2.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo2.putExtra("tituloNombreEjercicio", "Crunch");
                    //se inicia el intent
                    startActivity(intentMuestraVideo2);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio3" aquí (SECCION ABDOMINALES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo3 = new Intent(ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo3.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo3.putExtra("tituloNombreEjercicio", "Crunch Inverso");
                    //se inicia el intent
                    startActivity(intentMuestraVideo3);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio4" aquí (SECCION ABDOMINALES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo4 = new Intent(ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo4.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo4.putExtra("tituloNombreEjercicio", "Codo Rodilla");
                    //se inicia el intent
                    startActivity(intentMuestraVideo4);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio5" aquí (SECCION ABDOMINALES) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo5 = new Intent(ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo5.putExtra("tituloGrupoMuscular", "Abdominales");
                    intentMuestraVideo5.putExtra("tituloNombreEjercicio", "Mountain Climbers");
                    //se inicia el intent
                    startActivity(intentMuestraVideo5);
                }
            });
        }*/

        //Si la información que enviamos no está vacía, entonces que ponga el texto (CARDIO)
        //RECORDEMOS QUE ESTE CUARTO ES DE EJERCICIOS CARDIO
        /*if(tituloEjercicioCar!=null){
            //le colocamos texto al TextView del titulo de la actividad
            mTituloEjercicio.setText("Ejercicios " + tituloEjercicioCar);
            //Le colocamos nombre a los ejercicios de la actividad
            mNombreEjercicios1.setText(nombreEjercicioCar1);
            mNombreEjercicios2.setText(nombreEjercicioCar2);
            mNombreEjercicios3.setText(nombreEjercicioCar3);
            mNombreEjercicios4.setText(nombreEjercicioCar4);
            mNombreEjercicios5.setText(nombreEjercicioCar5);

            //Se lo agregramos a nuestro array de checkboxes
            checkBoxes.add(mNombreEjercicios1);
            checkBoxes.add(mNombreEjercicios2);
            checkBoxes.add(mNombreEjercicios3);
            checkBoxes.add(mNombreEjercicios4);
            checkBoxes.add(mNombreEjercicios5);

            //Metemos la funcionalidad del boton "Btn_VerEjercicio1" aquí (SECCION CARDIO) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo1 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo1.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo1.putExtra("tituloNombreEjercicio", "Jumping Jacks");
                    //se inicia el intent
                    startActivity(intentMuestraVideo1);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio2" aquí (SECCION CARDIO) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo2 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo2.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo2.putExtra("tituloNombreEjercicio", "High Knees");
                    //se inicia el intent
                    startActivity(intentMuestraVideo2);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio3" aquí (SECCION CARDIO) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo3 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo3.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo3.putExtra("tituloNombreEjercicio", "Salto Comba");
                    //se inicia el intent
                    startActivity(intentMuestraVideo3);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio1" aquí (SECCION CARDIO) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo4 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo4.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo4.putExtra("tituloNombreEjercicio", "Boxing");
                    //se inicia el intent
                    startActivity(intentMuestraVideo4);
                }
            });

            //Metemos la funcionalidad del boton "Btn_VerEjercicio1" aquí (SECCION CARDIO) para que
            // previamente sepa a que grupo pertenece ya que realmente esta info viene desde el bundle de MainActivity
            mBotonVerEjercicio5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMuestraVideo5 = new Intent (ListadoEjerciciosActivity.this, VideoEjercicioActivity.class);
                    intentMuestraVideo5.putExtra("tituloGrupoMuscular", "Cardio");
                    intentMuestraVideo5.putExtra("tituloNombreEjercicio", "Stand and Box");
                    //se inicia el intent
                    startActivity(intentMuestraVideo5);
                }
            });
        }*/

        //Creamos el OnClik del botón Enviar
        mBotonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un bucle con el que recorremos el arrayList de checboxes
                for(int i = 0; i< checkBoxes.size(); i++){
                    //Si el checkbox esta seleccionado que ponga la información al array list nombre Ejercicios
                    if(checkBoxes.get(i).isChecked()){
                        nombreEjercicios.add(checkBoxes.get(i).getText().toString());
                    }
                }//llave de cierre del for

                ///APLICAR EL METODO GUARDARPREFERENCIAS
                guardarPreferencias();


                //Creamos el intent dentro del onclick del boton Enviar
                Intent intentEnviar = new Intent(ListadoEjerciciosActivity.this, MainActivity.class);

                //iniciamos el intent
                startActivity(intentEnviar);
            }
        });
    }//Llave de cierre del Oncreate

    //SE CREARÁ EL MÉTODO GUARDARPREFERENCIAS OJO CON LOS 4 GRUPOS MUSCULARES
    private void guardarPreferencias(){
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putStringSet(tipoEjercicios, nombreEjercicios);
        editor.apply();
    }

    //Creamos el método obtenerEjercicios
    private void obtenerEjercicios (String tipoEjercicios){
        SQLiteDatabase db = conexionSQLite.getReadableDatabase();

        String [] parametros = {tipoEjercicios};

        try{
            String select = "SELECT * FROM EJERCICIO WHERE tipoEjercicio = ?";
            Cursor cursor = db.rawQuery(select, parametros);

            while(cursor.moveToNext()){
                Ejercicio ej = new Ejercicio();
                ej.setId(cursor.getInt(0));
                ej.setNombreEjercicio(cursor.getString(1));
                ej.setTipoEjercicio(cursor.getString(2));
                ejercicios.add(ej);
            }

            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Se ha producido un error", Toast.LENGTH_LONG).show();
        }
    }

    //Metodo para volver a la actividad principal
    public void Volver(View vista){
        onBackPressed();
    }
}
