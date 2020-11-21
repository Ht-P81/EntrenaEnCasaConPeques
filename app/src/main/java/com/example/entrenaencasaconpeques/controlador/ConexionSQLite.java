package com.example.entrenaencasaconpeques.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.entrenaencasaconpeques.modelo.SesionesEnt;
import com.example.entrenaencasaconpeques.modelo.Usuario;

import java.util.ArrayList;
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
        //Damos referencias a claves foráneas y claves primarias
        //Con estas rectricciones implementadas nos aseguramos que no se le ponga un ejercicio o un usuario que no exista
        db.execSQL("CREATE TABLE SESION (idUsuario INTEGER, idEjercicio INTEGER, fechahora DATETIME," +
                " FOREIGN KEY (idUsuario) REFERENCES USUARIO (id), FOREIGN KEY (idEjercicio) REFERENCES EJERCICIO (id), " +
                "PRIMARY KEY(idUsuario, idEjercicio, fechahora))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //en caso de actualización de nuestra BBDD que borre y cree de nuevo para actualizar
        db.execSQL("DROP TABLE IF EXISTS USUARIO");
        //tabla ejercicio
        db.execSQL("DROP TABLE IF EXISTS EJERCICIO");
        //tabla sesionesEnt
        db.execSQL("DROP TABLE IF EXISTS SESION");

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

    //Metodo para registrar las sesiones de entrenamiento
    public void registroSesiones (int idUsuario, ArrayList<Integer> idEjercicios, String fechahora){

        //Creamos una conexión con la base de datos de escritura
        SQLiteDatabase db = this.getWritableDatabase();

        //Con este bucle for se recorreran todos los ejercicios que el usuario haya seleccionado
        for(int i = 0; i < idEjercicios.size(); i++){

            //Introducimos los valores que necesitamos, el idUsuario y fecha y hora será el mismo
            //mientras que idEjercicios variará de cuantos ejercicios haya seleccionado el usuario.
            ContentValues values = new ContentValues();
            values.put("idUsuario", idUsuario);
            values.put("idEjercicio", idEjercicios.get(i));
            values.put("fechahora", fechahora);

            //insertamos en la tabla sesión los valores que se an indiciado anteriormente.
            db.insert("SESION", "idUsuario", values);

            //Mensaje para seguir por consola que el método funciona y hacía lo debido
            Log.e("INSERCION", "ok");
        }

        //Una vez salimos del bucle, entonces cerramos la conexión
        db.close();
    }
}
