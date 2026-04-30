package mjose;
import java.util.Scanner;

public class ProgramaPrincipal {

    private Scanner sc = new Scanner(System.in);
    private GestorDades gestorDades = new GestorDades();
    private GestorLlistes gestorLlistes = new GestorLlistes();

    private String carpetaUsuari;

    public ProgramaPrincipal(String carpetaUsuari) {
        this.carpetaUsuari = carpetaUsuari;
    }

    public void menuUsuari() {
        int opcio;

        do {
            System.out.println("\n--- MENÚ 02: LLISTATS ---");
            System.out.println("1. Veure llistats");
            System.out.println("2. Afegir elements");
            System.out.println("0. Eixir");
            System.out.print("Opció: ");
            opcio = Integer.parseInt(sc.nextLine());

            switch (opcio) {
                case 1 -> menuLlistats();
                case 2 -> menuAfegir();
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
                case 1 -> mostrarLlista("pelicules.llista");
                case 2 -> mostrarLlista("actors.llista");
                case 3 -> mostrarLlista("directors.llista");
                case 0 -> {}
                default -> System.out.println("Opció incorrecta");
            }

        } while (opcio != 0);
    }

    private void mostrarLlista(String fitxer) {
        String ruta = carpetaUsuari + "/" + fitxer;

        var llista = gestorLlistes.carregarLlistaUsuario(ruta);

        if (llista.isEmpty()) {
            System.out.println("La llista està buida.");
            return;
        }

        System.out.println("\n--- LLISTA ---");
        for (int i = 0; i < llista.size(); i++) {
            System.out.println((i + 1) + ". " + llista.get(i));
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

        gestorDades.afegirPelicula(new Pelicula(titol, any, genere));
        System.out.println("Pel·lícula afegida.");
    }

    private void afegirActor() {
        System.out.print("Nom: ");
        String nom = sc.nextLine();
        System.out.print("Cognoms: ");
        String cognoms = sc.nextLine();
        System.out.print("Data naixement (YYYY-MM-DD): ");
        String data = sc.nextLine();

        gestorDades.afegirActor(new Actor(nom, cognoms, java.time.LocalDate.parse(data)));
        System.out.println("Actor afegit.");
    }

    private void afegirDirector() {
        System.out.print("Nom: ");
        String nom = sc.nextLine();
        System.out.print("Cognoms: ");
        String cognoms = sc.nextLine();
        System.out.print("Data naixement (YYYY-MM-DD): ");
        String data = sc.nextLine();

        gestorDades.afegirDirector(new Director(nom, cognoms, java.time.LocalDate.parse(data)));
        System.out.println("Director afegit.");
    }
}
 
    

