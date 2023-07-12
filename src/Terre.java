import Flore.Vegetal;
import entities.Jardin;

public class Terre {
    public static void main(String[] args) {

        System.out.println("Le Jardin Virtuel");

        Jardin jardin = new Jardin(5,10);
        jardin.ajouterPanier("Tomate",5);
        jardin.ajouterPanier("Carotte",5);
        jardin.ajouterPanier("Ail",10);
        jardin.ajouterPanier("Betterave",5);
        jardin.planter(2, 5, new Vegetal("Cana"));

        System.out.println(jardin);

    }
}