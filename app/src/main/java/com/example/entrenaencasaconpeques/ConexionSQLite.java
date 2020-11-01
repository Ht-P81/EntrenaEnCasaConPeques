package com.example.entrenaencasaconpeques;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSQLite extends SQLiteOpenHelper {

    //Creamos el constructor que nos obliga a implementar y a desarrollar adaptandolo
    // a nuestras necesidades este constructor tiene más elementos
    // por parámetros además del contexto, se simplifica para no ir repitiendo
    public ConexionSQLite(@Nullable Context context) {
        super(context, "entrana_con_peques", null, 1);
    }

    //Implementamos (sobreescribimos) los métodos que nos obliga SQLiteHelper (abstracta)
    // a implementar y a desarrollar adaptandolo a nuestra necesidades
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos las tablas que va a tener nuestra conexión
        db.execSQL("CREATE TABLE USUARIO(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, " +
                "apellidos TEXT, email TEXT, clave TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //en caso de actuliazación de nuestra BBDD que borre y cree de nuevo para actualizar
        db.execSQL("DROP TABLE IF EXISTS USUARIO");
        onCreate(db);
    }

    //Nos creamos este método con el que poder hacer los INSERT en nuestra consulta
    public void registrarUsuario(UsuarioBBDD usuario){

        //Escribimos en nuestraBBDD objeto SQLiteDatabase
        SQLiteDatabase base_de_datos = this.getWritableDatabase();

        //Creamos estas variables que asosciamos para escribir la información
        String nombre = usuario.getNombre();
        String apellidos = usuario.getApellidos();
        String correo = usuario.getCorreo();
        String clave = usuario.getClave();

        //Guardamos toda la información una sentencia
        String sentencia = "INSERT INTO USUARIO(nombre, apellidos, email, clave) VALUES ('"+nombre+"','"+apellidos+"','"+correo+"','"+clave+"')";

        //Ejecutamos la sentencia albergada en el string sentencia
        base_de_datos.execSQL(sentencia);

        //Cerramos nuestra bases de datos
        base_de_datos.close();
    }

    //Creamos métodos ejercicio (id, nombre, tipo).

    //Creamos metodo registro (usuario, dia, ejercicio).
}
