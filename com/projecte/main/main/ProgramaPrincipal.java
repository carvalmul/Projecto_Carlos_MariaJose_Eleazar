package com.projecte.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.projecte.eleazar.Eleazar;
import com.projecte.mjose.Mjose;

public class ProgramaPrincipal {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //ESTA ES LA CLASE PRINCIPAL
        System.out.println("");
        String opcio;

        do {
            System.out.println("=====MENÚ ACCÉS=====");
            System.out.println("1. Iniciar sessió");
            System.out.println("2. Registrar-se");
            System.out.println("3. Eixir");
            opcio = sc.nextLine();

            switch (opcio) {
                case "1":
                    iniciarSessio();
                    break;
                case "2":
                    registrarse();
                    break;
                case "3":
                    System.out.println("\nHas eixit del menu");
                    break;
                default:
                    System.out.println("\nOpció no valida");
                    break;
            }
        } while (!"3".equals(opcio));
    }

    public static void iniciarSessio() {

    }

    public static void registrarse() {
        // Demanar dades
        System.out.println("====REGISTRE====");
        System.out.print("Introduix nom: ");
        String nom = sc.nextLine();
        System.out.print("Introdueix cognoms: ");
        String cognom = sc.nextLine();

        // La contrasenya ha de ser igual
        String contrasenya;
        String contrasenya2;

        do {
            System.out.print("Introdueix contrasenya: ");
            contrasenya = sc.nextLine();
            System.out.println("Tornala a introduir");
            contrasenya2 = sc.nextLine();

            if (!contrasenya.equals(contrasenya2)) {
                System.out.println("Les contrasenyes no coincidixen");
            }
        } while (!contrasenya.equals(contrasenya2));
        
        System.out.print("Introdueix població: ");
        String poblacio = sc.nextLine();
        System.out.print("Introdueix el Rol: [ROL_USUARIO, ROL_ADMIN]");
        String rol = sc.nextLine();
        System.out.print("Introduix data naixement: ");
        String fecha = sc.nextLine();

        //Afegir al fitxer de text
        try {
            File fitxer = new File("usuaris.txt");
            FileWriter fw = new FileWriter(fitxer, true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (fitxer.length() == 0) {
                bw.write("NOM | COGNOM | CONTRASENYA | POBLACIO | ROL | DATA_NAIXEMENT");
                bw.newLine();
            }
            bw.write(nom+" | "+cognom+" | "+contrasenya+" | "+poblacio+" | "+rol+" | "+fecha);
            bw.close();
            System.out.println("Registre guardat");
        } catch (IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }

        // Creació d'usuari (suposant que se el arrayList de usuaris)
        //usuaris.add(new Usuari(nom, cognom, contrasenya, poblacio, Rol.valueOf(Rol), LocalDate.parse(fecha)))
        
    }
    
}