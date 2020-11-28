package com.example.entrenaencasaconpeques.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.entrenaencasaconpeques.R;
import com.example.entrenaencasaconpeques.modelo.Usuario;

public class PerfilUsuarioActivity extends AppCompatActivity {

    //Declaramos variables
    private TextView nombre, apellidos, mail, clave;
    private Usuario usuario;
    private Button mbtn_sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Mapeamos las variables con los elementos de la actividad
        nombre = findViewById(R.id.tv_nombrePerfil);
        apellidos = findViewById(R.id.tv_apellidosPerfil);
        mail = findViewById(R.id.tv_correoPerfil);
        clave = findViewById(R.id.tv_contraseñaPerfil);
        mbtn_sesion = findViewById(R.id.btn_SesionesEnt);

        //inicializamos objeto usuario
        usuario = new Usuario();

        //Cargamos las preferencias que guardamos al cargar el usuario
        cargarUsuario();

        mbtn_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PerfilUsuarioActivity.this, RegistroSesionActivity.class);
                startActivity(i);
            }
        });
        //Colocamos la información solicitada en cada campo
        nombre.setText("Nombre:     " +usuario.getNombre());
        apellidos.setText("Apellidos:     " +usuario.getApellidos());
        mail.setText("Mail:     " +usuario.getCorreo());

        String claveParcial = "";

        for(int i = 0; i < usuario.getClave().length(); i++){
            if(i < usuario.getClave().length()-2){
                claveParcial += "*";
            }else{
                claveParcial += usuario.getClave().charAt(i);
            }
        }

        clave.setText("Contraseña:     " +claveParcial);


    } //llave de cierre del Oncreate

    //Metodo que carga la información del Usuario mediante SharedPreferences
    private void cargarUsuario(){

        SharedPreferences preferencias = getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
        //Aquí cargaremos la variables de tipo Usuario con los sets de todos los campos del objeto
        usuario.setId(preferencias.getInt("usuarioId", 0));
        usuario.setNombre(preferencias.getString("usuarioNombre", null));
        usuario.setApellidos(preferencias.getString("usuarioApe", null));
        usuario.setCorreo(preferencias.getString("usuarioCorreo", null));
        usuario.setClave(preferencias.getString("usuarioClave", null));

    }

    //Boton volver a la actividad principal
    public void Volver(View vista){

        onBackPressed();
    }
}
