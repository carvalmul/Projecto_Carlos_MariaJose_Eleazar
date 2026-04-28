
package mjose;
import java.io.Serializable;
import java.time.LocalDate;


public class Usuario implements Serializable {

    private int id;
    private String nom;
    private String cognoms;
    private String email;
    private String contrasenya;
    private String poblacio;
    private LocalDate dataNaixement;
    private String rol;

    public Usuario(int id, String nom, String cognoms, String email,
            String contrasenya, String poblacio,
            LocalDate dataNaixement, String rol) {

        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
        this.email = email;
        this.contrasenya = contrasenya;
        this.poblacio = poblacio;
        this.dataNaixement = dataNaixement;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public String getEmail() {
        return email;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public String toString() {
        return nom + " " + cognoms + " (" + email + ")";
    }
}
