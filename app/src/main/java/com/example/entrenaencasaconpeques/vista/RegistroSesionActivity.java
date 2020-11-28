package com.example.entrenaencasaconpeques.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.entrenaencasaconpeques.R;
import com.example.entrenaencasaconpeques.controlador.ConexionSQLite;
import com.example.entrenaencasaconpeques.modelo.SesionesEnt;

import java.util.ArrayList;

public class RegistroSesionActivity extends AppCompatActivity {

    //Creamos variables para interactuar
    private TableLayout tlTabla;
    private TableRow fila;
    private TextView tvUsuario, tvIdEjercicio, tvFecha;
    private ArrayList<SesionesEnt> listaSesiones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_sesion);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Obtenemos el ID de usuario
        SharedPreferences preferencias = getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);

        //Lo utilizaremos en el where de la consulta query SQL
        int id_Usuario2 = preferencias.getInt("usuarioId", 0);

        //Inicializamos el array
        listaSesiones = new ArrayList<>();

        //Creamos varaible de tipo sesion
        SesionesEnt sesion;

        //Establecemos la conexion con al base de datos
        ConexionSQLite conexionSQLite = new ConexionSQLite(this);

        //Conexion de lextura
        SQLiteDatabase db = conexionSQLite.getReadableDatabase();

        //Creamos un array de string parametros pasándole el id de usuario pasado a string
        String[] parametros = {String.valueOf(id_Usuario2)};

        //Hacemos consulta multiple donde empleamos varias tablas
        String query = "SELECT E.nombreEjercicio, E.tipoEjercicio, S.fechahora FROM Ejercicio E, Sesion S WHERE E.id = S.idEjercicio AND S.idUsuario = ?";

        Cursor cursor = db.rawQuery(query, parametros);

        while (cursor.moveToNext()) {
            //inicializamos el objeto sesion
            sesion = new SesionesEnt();
            sesion.setEjercicio(cursor.getString(0));
            sesion.setTipoEjercicio(cursor.getString(1));
            sesion.setFecha(cursor.getString(2));

            //se lo pasamos al array
            listaSesiones.add(sesion);
        }

        //Mapeamos valores para la tabla
        tlTabla = findViewById(R.id.tlTabla);

        //Creamos el modelo para filas y columnas, aquí habrá tres columnas
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

        //Rellenamos la tabla, inicializamos el bucle en menos -1 para establecer un TITULO a la tabla
        for (int i = -1; i < listaSesiones.size(); i++) {
            fila = new TableRow(this);
            fila.setLayoutParams(layoutFila);

            //Fila cabecera, titutlo de tabla
            if (i == -1) {
                //Especificamos como se verá
                tvUsuario = new TextView(this);
                tvUsuario.setText("EJERCICIO");
                tvUsuario.setGravity(Gravity.CENTER);
                tvUsuario.setBackgroundColor(Color.GRAY);
                tvUsuario.setTextColor(Color.WHITE);
                tvUsuario.setPadding(10, 10, 10, 10);
                tvUsuario.setLayoutParams(layoutFila);
                //Añadimos la vista a la fila
                fila.addView(tvUsuario);

                tvIdEjercicio = new TextView(this);
                tvIdEjercicio.setText("TIPO");
                tvIdEjercicio.setGravity(Gravity.CENTER);
                tvIdEjercicio.setBackgroundColor(Color.GRAY);
                tvIdEjercicio.setTextColor(Color.WHITE);
                tvIdEjercicio.setPadding(10, 10, 10, 10);
                tvIdEjercicio.setLayoutParams(layoutFila);
                fila.addView(tvIdEjercicio);

                tvFecha = new TextView(this);
                tvFecha.setText("FECHA Y HORA");
                tvFecha.setGravity(Gravity.CENTER);
                tvFecha.setBackgroundColor(Color.GRAY);
                tvFecha.setTextColor(Color.WHITE);
                tvFecha.setPadding(10, 10, 10, 10);
                tvFecha.setLayoutParams(layoutFila);
                fila.addView(tvFecha);

                //añadimos a la vista de la tabla
                tlTabla.addView(fila);

                //Ahora escribimos los valores obtenidos a continuació del título.
            }else{
                //instanciamos un textView
                tvUsuario = new TextView(this);
                //Le colocamos el texto que obtiene de recorrer el bucle en el campo ejercicio
                tvUsuario.setText(String.valueOf(listaSesiones.get(i).getEjercicio()));
                tvUsuario.setTextColor(Color.parseColor("#ff0ea1ea"));
                tvUsuario.setPadding(10, 10, 10, 10);
                //colocamos los parametros establecidos en la fila
                tvUsuario.setLayoutParams(layoutFila);
                //agregamos al vista fila
                fila.addView(tvUsuario);

                //lo mismo con los otras campos
                tvIdEjercicio = new TextView(this);
                tvIdEjercicio.setText(String.valueOf(listaSesiones.get(i).getTipoEjercicio()));
                tvIdEjercicio.setTextColor(Color.parseColor("#ff0ea1ea"));
                tvIdEjercicio.setPadding(10, 10, 10, 10);
                tvIdEjercicio.setGravity(Gravity.CENTER);
                tvIdEjercicio.setLayoutParams(layoutFila);
                fila.addView(tvIdEjercicio);

                tvFecha = new TextView(this);
                tvFecha.setText(listaSesiones.get(i).getFecha());
                tvFecha.setTextColor(Color.parseColor("#ff0ea1ea"));
                tvFecha.setPadding(10, 10, 10, 10);
                tvFecha.setGravity(Gravity.CENTER);
                tvFecha.setLayoutParams(layoutFila);
                fila.addView(tvFecha);

                tlTabla.addView(fila);


            }
        }//llave de cierre del bucle
    } //llave de cierre del onCreate

    public void Volver(View Vista) {
        onBackPressed();
    }
}