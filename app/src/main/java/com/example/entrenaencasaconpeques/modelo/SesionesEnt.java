package com.example.entrenaencasaconpeques.modelo;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SesionesEnt { //CLASE POJO (Plain Old Java Object)

    //Campos de clase de la tabla sesiones entrenamiento
   //private int id;
    //private String nombreUsuario;
    private String fecha;
    private String ejercicio;
    private String tipoEjercicio;

    //Constructor vacío por defecto
    public SesionesEnt(){

    }

    //Metodos setters y getter de todos los abributos/campos de clase

    //Setters
    //public void setId(int id){ this.id = id; }

    //public void setNombreUsuario (String nombreUsuario){this.nombreUsuario = nombreUsuario;}

    public void setFecha (String fecha){
        this.fecha = fecha;
    }

    public void setEjercicio (String ejercicio){
        this.ejercicio = ejercicio;
    }

    public void setTipoEjercicio (String tipoEjercicio){ this.tipoEjercicio = tipoEjercicio;}

    //Getters
    //public int getId(){return id;}

    //public String getNombreUsuario(){return nombreUsuario;}

    public String getFecha(){

        //Cambiar el formato de fecha
        SimpleDateFormat conver = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat conver2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = null;

        String nuevoFormato = null;

        try {
            date = conver.parse(this.fecha);
        } catch (ParseException e) {
            Log.e("Error", "Error en fecha");
        }

        //Para convertir de Date a String, usamos lo siguiente:
        try {

            nuevoFormato = conver2.format(date.getTime());
        } catch (Exception ex) {
            Log.e("ERROR", "CONVERTIR FECHA A TEXTO");
        }

        return nuevoFormato;

    }

    public String getEjercicio (){
        return ejercicio;
    }

    public String getTipoEjercicio(){ return tipoEjercicio;}

}
