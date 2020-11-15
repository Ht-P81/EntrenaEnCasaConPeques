package com.example.entrenaencasaconpeques.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.entrenaencasaconpeques.R;
import com.example.entrenaencasaconpeques.controlador.ConexionSQLite;
import com.example.entrenaencasaconpeques.modelo.Ejercicio;
import com.example.entrenaencasaconpeques.modelo.Usuario;

import java.util.ArrayList;

public class PerfilUsuarioActivity extends AppCompatActivity {

    //Declaramos variables
    private TextView nombre, apellidos, mail, clave;
    private Usuario usuario;

    //Varibles para o
    ArrayList<TextView> informacion;
    ArrayList<Usuario> usuarioPerfil;
    ConexionSQLite conexionSQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        //Mapeamos las variables con los elementos de la actividad
        nombre = findViewById(R.id.tv_nombrePerfil);
        apellidos = findViewById(R.id.tv_apellidosPerfil);
        mail = findViewById(R.id.tv_correoPerfil);
        clave = findViewById(R.id.tv_contraseñaPerfil);



        //inicializamos objeto usuario
        informacion = new ArrayList<>();
        conexionSQLite = new ConexionSQLite(this);
        usuarioPerfil = new ArrayList<>();
        usuario = new Usuario();

        nombre.setText("Nombre: " +usuario.getNombre());
        apellidos.setText("Apellidos: " +usuario.getApellidos());
        mail.setText("Mail: " +usuario.getCorreo());
        clave.setText("Contraseña: " +usuario.getClave());



        //implementamos el método
        //Con esta simple línea podemos obtener la información de los campos de la base de datos
        //obtenerUsuario();

        /*//los añadimos al array de checkBoxes
        informacion.add(nombre);
        informacion.add(apellidos);
        informacion.add(mail);
        informacion.add(clave);


        //con un bucle for recorremos todo
        for (int i = 0; i< informacion.size(); i++){
            informacion.get(i).setText(usuarioPerfil.get(i).getNombre());
            informacion.get(i).setText(usuarioPerfil.get(i).getApellidos());
            informacion.get(i).setText(usuarioPerfil.get(i).getCorreo());
            informacion.get(i).setText(usuarioPerfil.get(i).getClave());
        }

    }

    //Creamos el método obtenerEjercicios, le pasamos por parámetro el tipo de ejercicio
    //Este método cargará en el arrayList de ejercicios toda la información que contenga la base de datos
    private void obtenerUsuario (String nombre){

        //Indicamos la instrucción para que lea desde nuestra base de datos
        SQLiteDatabase db = conexionSQLite.getReadableDatabase();

        //Creamos un array de tipo String donde lo inicializamos con el tipoEjercicios
        String [] parametros = {nombre};

        //Realizamos un try catch por si se produce algún error
        try{
            //Realizamos la consulta, el signo de interrogación será sustituida por el parámetro que contenga (tipoEjercicios)
            //Esto se conoce como Place Holder.
            String select = "SELECT * FROM USUARIO WHERE nombre = ?";
            //El cursor realiza la consulta y añada la información pasada por parámetro.
            Cursor cursor = db.rawQuery(select, parametros);

            //Bucle while
            while(cursor.moveToNext()){
                //Instanciamos un objeto de tipo Ejercicio
                Usuario us = new Usuario();
                //Colocamos al objeto ejercicio la información conseguida de la tabla
                us.setId(cursor.getInt(0));
                us.setNombre(cursor.getString(1));
                us.setApellidos(cursor.getString(2));
                us.setCorreo(cursor.getString(3));
                us.setClave(cursor.getString(4));
                //Al arrayList ejercicios de tipo Ejercicio le pasamos el objeto ej (de tipo ejercicio)
                usuarioPerfil.add(us);
            }

            //Cerramos el cursor
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Se ha producido un error", Toast.LENGTH_LONG).show();
        }*/
    }


    public void Volver(View vista){
        onBackPressed();
    }
}
