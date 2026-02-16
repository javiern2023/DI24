package com.example.elementosjavafx;

public class Alumno {

    private String nombre;
    private String contrasenia;

    public Alumno(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
