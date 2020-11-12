package com.example.entrenaencasaconpeques.modelo;

import java.util.Date;

public class SesionesEnt { //CLASE POJO (Plain Old Java Object)

    //Campos de clase de la tabla sesiones entrenamiento
    private int id;
    private String nombreUsuario;
    private Date fecha;
    private String ejercicio;
    private String tipoEjercicio;

    //Constructor vacío por defecto
    public SesionesEnt(){

    }

    //Metodos setters y getter de todos los abributos/campos de clase

    //Setters
    public void setId(int id){
        this.id = id;
    }

    public void setNombreUsuario (String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    public void setFecha (Date fecha){
        this.fecha = fecha;
    }

    public void setEjercicio (String ejercicio){
        this.ejercicio = ejercicio;
    }

    public void setTipoEjercicio (String tipoEjercicio){ this.tipoEjercicio = tipoEjercicio;}

    //Getters
    public int getId(){
        return id;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public Date getFecha(){
        return fecha;
    }

    public String getEjercicio (){
        return ejercicio;
    }

    public String getTipoEjercicio(){ return tipoEjercicio;}

}
