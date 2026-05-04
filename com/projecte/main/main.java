package com.projecte.main;
import com.projecte.gestors.*;
import com.projecte.models.*;
import com.projecte.menus.*;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
    Usuario u = new Usuario(
        1,
        "Maria",
        "Jose",
        "mjose@example.com",
        "1234",
        "Novelda",
        LocalDate.of(2000, 1, 1),
        "ROL_USUARI"
    );

    // Simulem que ja ha fet login
    System.out.println("Benvinguda, " + u.getNom() + " " + u.getCognoms());

    ProgramaPrincipal programa = new ProgramaPrincipal("1maria");
    programa.menuUsuari();
}

}

