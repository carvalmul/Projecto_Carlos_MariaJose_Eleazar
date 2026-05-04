package com.projecte.gestors;
import com.projecte.models.*;
import java.io.*;
import java.util.*;

public class GestorLlistes {

    // guardar

    public void afegirPelicula(Pelicula p, String carpeta) {
        guardarLinea(carpeta, "pelicules.llista",
                "PELICULA|" + p.getTitulo() + "|" + p.getAnio() + "|" + p.getGenero());
    }

    public void afegirActor(Actor a, String carpeta) {
        guardarLinea(carpeta, "actors.llista",
                "ACTOR|" + a.getNombre() + "|" + a.getApellidos() + "|" + a.getFechaNacimiento());
    }

    public void afegirDirector(Director d, String carpeta) {
        guardarLinea(carpeta, "directors.llista",
                "DIRECTOR|" + d.getNombre() + "|" + d.getApellidos() + "|" + d.getFechaNacimientoDir());
    }

    private void guardarLinea(String carpeta, String fitxer, String linea) {
        String ruta = "com/projecte/usuaris/" + carpeta + "/" + fitxer;

        try (FileWriter fw = new FileWriter(ruta, true)) {
            fw.write(linea + "\n");
        } catch (IOException e) {
            System.out.println("Error guardant en USUARI: " + fitxer);
            System.out.println(e.getMessage());
        }
    }

    // cargar

    public List<String> carregarLlistaUsuario(String ruta) {
        List<String> llista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linia;

            while ((linia = br.readLine()) != null) {
                llista.add(linia);
            }

        } catch (IOException e) {
            System.out.println("Error llegint USUARI");
        }

        return llista;
    }
}