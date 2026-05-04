package com.projecte.models;

public class Pelicula {

    private String titulo;
    private Integer anio;
    private String genero;

    public Pelicula(String titulo, Integer anio, String genero) {
        this.titulo = titulo;
        this.anio = anio;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula [titulo=" + titulo + ", anio=" + anio + ", genero=" + genero + "]";
    }

}
