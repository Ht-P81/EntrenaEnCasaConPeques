package com.example.entrenaencasaconpeques.vista;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
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
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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

        //Recojemos la información procedentes de cada onClink con los datos de los bundles, en este caso para
        //el título de cada grupo muscular
        String tituloEjercicioSup = informacion.getString("tituloEtiqueta");
        String tituloEjercicioInf = informacion.getString("tituloEtiqueta");
        String tituloEjercicioAb = informacion.getString("tituloEtiqueta");
        String tituloEjercicioCar = informacion.getString("tituloEtiqueta");

        //Con estos condicionales nos aseguramos que los títulos son los que corresponden con el grupo muscular
        if (tituloEjercicioSup.equals("Superiores")){
            mTituloEjercicio.setText("Ejercicios " + tituloEjercicioSup);
        }else if (tituloEjercicioInf.equals("Inferiores")){
            mTituloEjercicio.setText("Ejercicios " + tituloEjercicioInf);
        }else if (tituloEjercicioAb.equals("Abdominales")){
            mTituloEjercicio.setText("Ejercicios " + tituloEjercicioAb);
        }else if(tituloEjercicioCar.equals("Cardio")){
            mTituloEjercicio.setText("Ejercicios " + tituloEjercicioCar);
        }

        //Obtenemos la información de los bundles y lo guardamos en la variable tipoEjercicios
        tipoEjercicios = informacion.getString("tipoEjercicios");

        //implementamos el método
        //Con esta simple línea podemos obtener la información de los campos de la base de datos
        obtenerEjercicios(tipoEjercicios);

        //los añadimos al array de checkBoxes
        checkBoxes.add(mNombreEjercicios1);
        checkBoxes.add(mNombreEjercicios2);
        checkBoxes.add(mNombreEjercicios3);
        checkBoxes.add(mNombreEjercicios4);
        checkBoxes.add(mNombreEjercicios5);

        //con un bucle for recorremos todo
        for (int i = 0; i< checkBoxes.size(); i++){
            checkBoxes.get(i).setText(ejercicios.get(i).getNombreEjercicio());
        }

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

                //Agregamos información para el usuario
                Toast.makeText(getApplicationContext(), "Ejercicios seleccionados", Toast.LENGTH_SHORT).show();
                //iniciamos el intent
                startActivity(intentEnviar);
            }
        });
    }//Llave de cierre del Oncreate

    //SE CREARÁ EL MÉTODO GUARDARPREFERENCIAS
    private void guardarPreferencias(){
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putStringSet(tipoEjercicios, nombreEjercicios);
        editor.apply();
    }

    //Creamos el método obtenerEjercicios, le pasamos por parámetro el tipo de ejercicio
    //Este método cargará en el arrayList de ejercicios toda la información que contenga la base de datos
    private void obtenerEjercicios (String tipoEjercicios){

        //Indicamos la instrucción para que lea desde nuestra base de datos
        SQLiteDatabase db = conexionSQLite.getReadableDatabase();

        //Creamos un array de tipo String donde lo inicializamos con el tipoEjercicios
        String [] parametros = {tipoEjercicios};

        //Realizamos un try catch por si se produce algún error
        try{
            //Realizamos la consulta, el signo de interrogación será sustituida por el parámetro que contenga (tipoEjercicios)
            //Esto se conoce como Place Holder.
            String select = "SELECT * FROM EJERCICIO WHERE tipoEjercicio = ?";
            //El cursor realiza la consulta y añada la información pasada por parámetro.
            Cursor cursor = db.rawQuery(select, parametros);

            //Bucle while
            while(cursor.moveToNext()){
                //Instanciamos un objeto de tipo Ejercicio
                Ejercicio ej = new Ejercicio();
                //Colocamos al objeto ejercicio la información conseguida de la tabla
                ej.setId(cursor.getInt(0));
                ej.setNombreEjercicio(cursor.getString(1));
                ej.setTipoEjercicio(cursor.getString(2));
                //Al arrayList ejercicios de tipo Ejercicio le pasamos el objeto ej (de tipo ejercicio)
                ejercicios.add(ej);
            }

            //Cerramos el cursor
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
