package com.projecte.models;

import java.time.LocalDate;

public class Director {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimientoDir;

    public Director(String nombre, String apellidos, LocalDate fechaNacimientoDir) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimientoDir = fechaNacimientoDir;
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

    public LocalDate getFechaNacimientoDir() {
        return fechaNacimientoDir;
    }

    public void setFechaNacimientoDir(LocalDate fechaNacimientoDir) {
        this.fechaNacimientoDir = fechaNacimientoDir;
    }

    @Override
    public String toString() {
        return "Director [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimientoDir=" + fechaNacimientoDir
                + "]";
    }

}
