package com.example.entrenaencasaconpeques;

public class Usuario { //Esta será una clase POJO (Plain Old Java Object) en ella se la da
    // forma de objeto a una de las tablas de la BBDD

    //Campos o columnas que van a tener nuestras tablas
    private int id; //Primary key
    private String nombre;
    private String apellidos;
    private String correo;
    private String clave;

    //Constructor vacío por defecto
    public Usuario(){

    }

    //métodos setters y getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
