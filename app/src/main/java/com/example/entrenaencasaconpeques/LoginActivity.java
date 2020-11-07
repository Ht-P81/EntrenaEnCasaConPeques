package com.example.entrenaencasaconpeques;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    //Declaramos las variables necesarias para operar con el login
    private EditText et_username, et_password;
    private Button btn_entrar, btn_registrar;
    private UsuarioBBDD mUsuario;
    private ConexionSQLite conexionSQLite;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Mapeamos las variables creadas con los elementos de la vista de la actividad
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_entrar = findViewById(R.id.btn_entrar);
        btn_registrar = findViewById(R.id.btn_registrar);
        mUsuario = new UsuarioBBDD();
        conexionSQLite = new ConexionSQLite(this);

        //Aqui cargamos las preferencias de usuario (sharedpreferences)
        //Se guarda los datos del usuario registrado y no necesitará loguearse de nuevo
        cargarUsuario();

        //si el Id del usuario es distinto de 0 es que ya se le ha otorgado un id y por tanto
        //ese usuario ya está registrado.
        if(mUsuario.getId() !=0){
            Intent i = new Intent (LoginActivity.this, MainActivity.class);
            startActivity(i);
        }

        //Creamos funcionallidad al boton entrar
        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //En estar variables guardamos la información que usuario meta en el editText nombre y contraseña
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                //Creamos condiciones para asegurarnos que el usurio ha introducido los campos
                if(username.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Debe introducir un nombre de usuario", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Debe introducir una contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase db = conexionSQLite.getReadableDatabase();
                    String[] parametros = {username, password};

                    try {

                        //Hacemos la consulta donde el campo nombre usuario o clave usuario sea igual a algunos de los
                        //campos (username, password) que le hemos pasado al array String que llamamos parámetros
                        //El simbolo de interrogación será sustituido por username y password (placeholder)
                        String select = "SELECT * FROM USUARIO WHERE nombre = ? AND clave = ?";

                        //Objeto que recorre fila a fila las tablas
                        Cursor cursor = db.rawQuery(select, parametros);
                        cursor.moveToFirst();

                        //De esta manera recorre el objeto usuario obteniendo su información en las columnas de la tabla
                        //de nuestra base de datos
                        mUsuario.setId(cursor.getInt(0));
                        mUsuario.setNombre(cursor.getString(1));
                        mUsuario.setApellidos(cursor.getString(2));
                        mUsuario.setCorreo(cursor.getString(3));
                        mUsuario.setClave(cursor.getString(4));

                        guardarPreferenciasUsuario(mUsuario);
                        cursor.close();

                        startActivity(new Intent(LoginActivity.this, MainActivity.class));

                        Toast.makeText(getApplicationContext(), "Bienvenido " + mUsuario.getNombre(), Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Usuario no encontrado", Toast.LENGTH_LONG).show();

                    }
                }

            }
        });

        //Desarrollamos funcionalidad al boton registrar
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, Nuevo_usuario.class));
            }
        });

    }//LLave de cierre del Oncreate

    //Metodo que cargue las preferencias de usuario
    //Sharedpreferences
    private void cargarUsuario(){
        SharedPreferences preferencias = getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
        //Aquí cargaremos la variables de tipo Usuario con los sets de todos los campos
        mUsuario.setId(preferencias.getInt("usuarioId", 0));
        mUsuario.setNombre(preferencias.getString("usuarioNombre", null));
        mUsuario.setApellidos(preferencias.getString("usuarioApe", null));
        mUsuario.setCorreo(preferencias.getString("usuarioCorreo", null));
        mUsuario.setClave(preferencias.getString("usuarioClave", null));

    }

    private void guardarPreferenciasUsuario(UsuarioBBDD usuario){
        SharedPreferences preferencias = getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        //Aquí le pasamos la información
        editor.putInt("usuarioId", usuario.getId());
        editor.putString("usuarioNombre", usuario.getNombre());
        editor.putString("usuarioApe", usuario.getApellidos());
        editor.putString("usuarioCorreo", usuario.getCorreo());
        editor.putString("usuarioClave", usuario.getClave());
        editor.apply();
    }
}
