import Flore.Ail;
import Flore.Vegetal;
import entities.Jardin;

import java.util.Scanner;

public class Terre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Le Jardin Virtuel");
        boolean run = true;

        Jardin jardin = new Jardin(5,10);
        jardin.ajouterPanier("Tomate",5);
        jardin.ajouterPanier("Carotte",5);
        jardin.ajouterPanier("Ail",10);
        jardin.ajouterPanier("Betterave",5);
//        jardin.planter(2, 5, new Vegetal("Cana"));
        System.out.println(jardin);

        do {
            System.out.println("1. Semer une graine");
            System.out.println("2. Récolter toutes les plantes qui sont matures");
            System.out.println("3. Passer à la saison suivante");
            System.out.println("4. Quitter l’application");
            int res = scanner.nextInt();

            switch (res) {
                case 1 :
                    jardin.semer();
                    System.out.println(jardin);
                    break;
            case 2 :
                jardin.recolter();
                    System.out.println(jardin);
                break;
                case 3 :
                    jardin.saisonSuivante();
                    System.out.println(jardin);
                    break;
                default:
                    System.exit(0);
                    break;
            }

        } while (run);




    }
}