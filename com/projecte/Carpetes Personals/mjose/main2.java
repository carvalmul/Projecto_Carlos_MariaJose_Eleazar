package mjose;
import java.time.LocalDate;
public class main2 {

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

