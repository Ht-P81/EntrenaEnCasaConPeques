package com.example.entrenaencasaconpeques.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.entrenaencasaconpeques.modelo.SesionesEnt;
import com.example.entrenaencasaconpeques.modelo.Usuario;

import java.util.Date;

public class ConexionSQLite extends SQLiteOpenHelper {

    //Creamos el constructor que nos obliga a implementar y a desarrollar adaptandolo
    // a nuestras necesidades este constructor tiene más elementos
    // por parámetros además del contexto, se simplifica para no ir repitiendo
    public ConexionSQLite(@Nullable Context context) {
        super(context, "entrena_con_peques", null, 1);
    }

    //Implementamos (sobreescribimos) los métodos que nos obliga SQLiteHelper (abstracta)
    // a implementar y a desarrollar adaptandolo a nuestra necesidades
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos las tablas que va a tener nuestra conexión
        //Creación de la tabla usuario
        db.execSQL("CREATE TABLE USUARIO(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, " +
                "apellidos TEXT, email TEXT, clave TEXT)");

        //Creación de la tabla ejercicio
        db.execSQL("CREATE TABLE EJERCICIO (id INTEGER PRIMARY KEY AUTOINCREMENT, nombreEjercicio TEXT, tipoEjercicio TEXT)");

        //Inicializamos la tabla con ejercicios SUPERIORES
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Push Up', 'Superiores')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Fondo en silla', 'Superiores')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Push Up One Leg', 'Superiores')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Superman', 'Superiores')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Burpees', 'Superiores')");

        //Inicializamos la tabla con ejercicios INFERIORES
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Squats', 'Inferiores')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Jump Squats', 'Inferiores')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Lunges', 'Inferiores')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Patinador', 'Inferiores')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Wall Sit', 'Inferiores')");

        //Inicializamos la tabla con ejercicios ABDOMINALES
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Plancha', 'Abdominales')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Crunch', 'Abdominales')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Crunch Inverso', 'Abdominales')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Codo Rodilla', 'Abdominales')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Escalador', 'Abdominales')");

        //Inicializamos la tabla con ejercicios CARDIO
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Jumping Jacks', 'Cardio')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('High Knees', 'Cardio')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Salto Comba', 'Cardio')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Boxing', 'Cardio')");
        db.execSQL("INSERT INTO EJERCICIO (nombreEjercicio, tipoEjercicio) VALUES ('Stand and Box', 'Cardio')");


        //Creación de la tabla sesionesEnt
        db.execSQL("CREATE TABLE SESION (idUsuario INTEGER, idEjercicio INTEGER, fechahora DATETIME," +
                " FOREIGN KEY (idUsuario) REFERENCES USUARIO (id), FOREIGN KEY (idEjercicio) REFERENCES EJERCICIO (id), " +
                "PRIMARY KEY(idUsuario, idEjercicio, fechahora))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //en caso de actualización de nuestra BBDD que borre y cree de nuevo para actualizar
        db.execSQL("DROP TABLE IF EXISTS USUARIO");
        onCreate(db);
    }

    ///Con este método creamos los insert y además nos devuelve el id mediante (contentvalues) para poder saber
    //si el usuario ya está registrado o no (si el id es 0 no lo está, si es otro valor sí lo está)
    public long registrarUsuario(Usuario usuario){

        //imprescindible y obligatorio para permitir escritura en la BBDD
        SQLiteDatabase db = this.getWritableDatabase();

        //Intanciamos este objeto ContentValues para pasarle los campos de la tabla
        ContentValues values = new ContentValues();

        //Agregamos a cada uno de los campos de la tabla los atributos del objeto usuario
        values.put("nombre", usuario.getNombre());
        values.put("apellidos", usuario.getApellidos());
        values.put("email", usuario.getCorreo());
        values.put("clave", usuario.getClave());

        //En esta variable que será la que retorne el método es donde guardamos el valor de la columna id
        long resultado = db.insert("USUARIO", "id", values);

        //Cerramos la bases de datos
        db.close();

        //retornamos la variable del método
        return resultado;
    }

    //Finalmente crearemos la tabla de tipos de ejercicios, pero no será necesario desarrollar ningun método
     //TODO: Creamos métodos de tipos de ejercicios?

    //TODO:Creamos metodo registro (usuario, dia, ejercicio).
    public void sesionesEntrenos (SesionesEnt sesionesEnt){

        //Escribimos en nuestra BBDD
        SQLiteDatabase base_de_datos = this.getWritableDatabase();

        //Creamos estas variables que asociamos para escribir información
        String nombreUsuario = sesionesEnt.getNombreUsuario();
        Date fechaEntreno = sesionesEnt.getFecha();
        String ejercicio = sesionesEnt.getEjercicio();

        //Guardamos la información en una sentencia
        String sentencia = "INSERT INTO SESIONESENT (nombreUsuario, fecha, ejercicio) VALUES('"+nombreUsuario+"', '"
              +fechaEntreno+"', '"+ejercicio+"')";

    }
}
