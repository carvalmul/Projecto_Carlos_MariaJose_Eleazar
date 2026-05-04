package com.projecte.menus;

import com.projecte.gestors.*;
import com.projecte.models.*;
import java.util.Scanner;
import java.time.LocalDate;

public class ProgramaPrincipal {

    private Scanner sc = new Scanner(System.in);
    private GestorDades gestorDades = new GestorDades();
    private GestorLlistes gestorLlistes = new GestorLlistes();

    private String carpetaUsuari;
    private int tipusCarpeta = 1; // 1 = usuario, 2 = general

    public ProgramaPrincipal(String carpetaUsuari) {
        this.carpetaUsuari = carpetaUsuari;
    }

    public void menuUsuari() {
        int opcio;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("Treballant amb: " + (tipusCarpeta == 1 ? "USUARI" : "GENERAL"));
            System.out.println("1. Canviar a carpeta USUARI");
            System.out.println("2. Canviar a carpeta GENERAL");
            System.out.println("3. Veure llistats");
            System.out.println("4. Afegir elements");
            System.out.println("0. Eixir");
            System.out.print("Opció: ");
            opcio = Integer.parseInt(sc.nextLine());

            switch (opcio) {
                case 1 -> tipusCarpeta = 1;
                case 2 -> tipusCarpeta = 2;
                case 3 -> menuLlistats();
                case 4 -> menuAfegir();
                case 0 -> System.out.println("Adéu!");
                default -> System.out.println("Opció incorrecta");
            }

        } while (opcio != 0);
    }

    public void menuLlistats() {
        int opcio;

        do {
            System.out.println("\n--- VEURE LLISTATS ---");
            System.out.println("1. Pel·lícules");
            System.out.println("2. Actors");
            System.out.println("3. Directors");
            System.out.println("0. Tornar");
            System.out.print("Opció: ");
            opcio = Integer.parseInt(sc.nextLine());

            switch (opcio) {
                case 1 -> mostrarLlista("pelicules");
                case 2 -> mostrarLlista("actors");
                case 3 -> mostrarLlista("directors");
                case 0 -> {}
                default -> System.out.println("Opció incorrecta");
            }

        } while (opcio != 0);
    }

    private void mostrarLlista(String nomBase) {

        if (tipusCarpeta == 1) {
            // USUARIO → .llista
            String ruta = carpetaUsuari + "/" + nomBase + ".llista";
            var llista = gestorLlistes.carregarLlistaUsuario(ruta);

            if (llista.isEmpty()) {
                System.out.println("La llista està buida.");
                return;
            }

            System.out.println("\n--- LLISTA USUARI ---");
            for (int i = 0; i < llista.size(); i++) {
                System.out.println((i + 1) + ". " + llista.get(i));
            }

        } else {
            // GENERAL → .dades
            String fitxer = nomBase + ".dades";
            var llista = gestorDades.carregarLlistaGeneral(fitxer);

            if (llista.isEmpty()) {
                System.out.println("La llista està buida.");
                return;
            }

            System.out.println("\n--- LLISTA GENERAL ---");
            for (int i = 0; i < llista.size(); i++) {
                System.out.println((i + 1) + ". " + llista.get(i));
            }
        }
    }

    public void menuAfegir() {
        int opcio;

        do {
            System.out.println("\n--- AFEGIR ELEMENTS ---");
            System.out.println("1. Afegir pel·lícula");
            System.out.println("2. Afegir actor");
            System.out.println("3. Afegir director");
            System.out.println("0. Tornar");
            System.out.print("Opció: ");
            opcio = Integer.parseInt(sc.nextLine());

            switch (opcio) {
                case 1 -> afegirPelicula();
                case 2 -> afegirActor();
                case 3 -> afegirDirector();
                case 0 -> {}
                default -> System.out.println("Opció incorrecta");
            }

        } while (opcio != 0);
    }

    private void afegirPelicula() {
        System.out.print("Títol: ");
        String titol = sc.nextLine();
        System.out.print("Any: ");
        int any = Integer.parseInt(sc.nextLine());
        System.out.print("Gènere: ");
        String genere = sc.nextLine();

        if (tipusCarpeta == 1) {
            gestorLlistes.afegirPelicula(new Pelicula(titol, any, genere), carpetaUsuari);
        } else {
            gestorDades.afegirPelicula(new Pelicula(titol, any, genere));
        }

        System.out.println("Pel·lícula afegida.");
    }

    private void afegirActor() {
        System.out.print("Nom: ");
        String nom = sc.nextLine();
        System.out.print("Cognoms: ");
        String cognoms = sc.nextLine();
        System.out.print("Data naixement (YYYY-MM-DD): ");
        String data = sc.nextLine();

        LocalDate dataNaixement = LocalDate.parse(data);

        if (tipusCarpeta == 1) {
            gestorLlistes.afegirActor(new Actor(nom, dataNaixement, cognoms), carpetaUsuari);
        } else {
            gestorDades.afegirActor(new Actor(nom, dataNaixement, cognoms));
        }

        System.out.println("Actor afegit.");
    }

    private void afegirDirector() {
        System.out.print("Nom: ");
        String nom = sc.nextLine();
        System.out.print("Cognoms: ");
        String cognoms = sc.nextLine();
        System.out.print("Data naixement (YYYY-MM-DD): ");
        String data = sc.nextLine();

        LocalDate dataNaixement = LocalDate.parse(data);

        if (tipusCarpeta == 1) {
            gestorLlistes.afegirDirector(new Director(nom, cognoms, dataNaixement), carpetaUsuari);
        } else {
            gestorDades.afegirDirector(new Director(nom, cognoms, dataNaixement));
        }

        System.out.println("Director afegit.");
    }
}