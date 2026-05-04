package com.projecte.models;

import java.time.LocalDate;

public class Actor {

    private String nombre;
    private LocalDate fechaNacimiento;
    private String apellidos;

    public Actor(String nombre, LocalDate fechaNacimiento, String apellidos) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Actor [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", apellidos=" + apellidos + "]";
    }

}
