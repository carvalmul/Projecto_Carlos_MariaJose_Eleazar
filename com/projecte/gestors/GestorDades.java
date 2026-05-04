package com.projecte.gestors;
import com.projecte.models.*;
import java.io.*;
import java.util.*;

public class GestorDades {

    private String carpeta = "com/projecte/dades";

    // guardar

    public void afegirPelicula(Pelicula p) {
        guardarLinea("pelicules.dades",
                "PELICULA|" + p.getTitulo() + "|" + p.getAnio() + "|" + p.getGenero());
    }

    public void afegirActor(Actor a) {
        guardarLinea("actors.dades",
                "ACTOR|" + a.getNombre() + "|" + a.getApellidos() + "|" + a.getFechaNacimiento());
    }

    public void afegirDirector(Director d) {
        guardarLinea("directors.dades",
                "DIRECTOR|" + d.getNombre() + "|" + d.getApellidos() + "|" + d.getFechaNacimientoDir());
    }

    private void guardarLinea(String fitxer, String linea) {
        String ruta = carpeta + "/" + fitxer;

        try (FileWriter fw = new FileWriter(ruta, true)) {
            fw.write(linea + "\n");
        } catch (IOException e) {
            System.out.println("Error guardant en GENERAL: " + fitxer);
            System.out.println(e.getMessage());
        }
    }

    // cargar

    public List<String> carregarLlistaGeneral(String fitxer) {
        String ruta = carpeta + "/" + fitxer;
        List<String> llista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linia;

            while ((linia = br.readLine()) != null) {
                llista.add(linia);
            }

        } catch (IOException e) {
            System.out.println("Error llegint GENERAL");
        }

        return llista;
    }
}