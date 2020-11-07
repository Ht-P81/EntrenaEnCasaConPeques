package com.example.entrenaencasaconpeques;

import android.content.ContentValues;
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

    ///Con este método creamos los insert y además nos devuelve el id mediante (contentvalues) para poder saber
    //si el usuario ya está registrado o no (si el id es 0 no lo está, si es otro valor sí lo está)
    public long registrarUsuario(Usuario usuario){

        //imprescindible y obligatorio para permitir escritura en la BBDD
        SQLiteDatabase db = this.getWritableDatabase();

        //Intanciamos este objeto ContentValues para pasale los campos de la tabla
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

    //Creamos métodos ejercicio (id, nombre, tipo).
     //TODO
    //Creamos metodo registro (usuario, dia, ejercicio).
}
