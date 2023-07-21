package entities;

import Flore.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Jardin {
    private int longueur;
    private int largeur;
    private Emplacement[][] emplacements;
    private HashMap<String, Integer> panier;

    public Jardin(final int longueur, final int largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.panier = new HashMap<String, Integer>();
        this.emplacements = new Emplacement[this.longueur][this.largeur];
    }
    public void ajouterPanier(String nomDuVegetal, int quantite){
//        this.panier.put(nomDuVegetal, quantite);
        this.panier.put(nomDuVegetal, this.panier.getOrDefault(nomDuVegetal, 0) + quantite);
    }

    public void planter(int longueurIndex, int largeurIndex, Vegetal vegetal){
        Emplacement e = new Emplacement(vegetal);
        emplacements[longueurIndex][largeurIndex] = e;
    }

    public void semer(){
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int y = 0;

        do {
            System.out.println("Postion x (entre 0 et " + largeur + ")");
            int res = scanner.nextInt();
            if (res>0 && res <= largeur){
                x = res;
            }
        } while (x == 0);

        do {
            System.out.println("Postion y (entre 0 et " + longueur + ")");
            int res = scanner.nextInt();
            if (res>0 && res <= longueur){
                y = res;
            }
        } while (y == 0);
        x -= 1;
        y -= 1;

        int veg = 0;
        do {
            System.out.println("1. Ail");
            System.out.println("2. Betterave");
            System.out.println("3. Carotte");
            System.out.println("4. Tomate");
            int res = scanner.nextInt();
            if (res>0 && res <= 4){
                veg = res;
            }
        } while (veg == 0);

        if (veg == 1){
            int g = panier.get("Ail");
            if (g>0){
                this.emplacements[x][y] = new Emplacement(new Ail());
                panier.put("Ail", panier.get("Ail")-1);
            }
        } else if (veg == 2) {
            int g = panier.get("Betterave");
            if (g>0){
                this.emplacements[x][y] = new Emplacement(new Betterave());
                panier.put("Betterave", panier.get("Betterave")-1);
            }

        } else if (veg == 3) {
            int g = panier.get("Carotte");
            if (g>0){
                this.emplacements[x][y] = new Emplacement(new Carotte());
                panier.put("Carotte", panier.get("Carotte")-1);
            }
        } else if (veg == 4) {
            int g = panier.get("Tomate");
            if (g>0){
                this.emplacements[x][y] = new Emplacement(new Tomate());
                panier.put("Tomate", panier.get("Tomate")-1);
            }
        }


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Voici notre jardin :\n");
        for (int i = 0; i < longueur; ++i) {
            for(int j = 0; j < largeur; ++j) {
                if (emplacements[i][j] == null){
                    sb.append("O");
                } else{
                    sb.append((emplacements[i][j]));
                }
            }
                    sb.append("\n");
        }
        sb.append("Et notre panier contient :\n");

        panier.forEach((nomDuVegetal, quantite) -> {
            sb.append(nomDuVegetal + " : " + quantite + " graine(s)" + "\n");
        });

        return sb.toString();
    }

    public void saisonSuivante() {
        for (int i = 0; i < longueur; ++i) {
            for(int j = 0; j < largeur; ++j) {
                if (emplacements[i][j] != null){
                    this.emplacements[i][j].getVegetal().grandir();
                }
            }
        }
    }

    public void recolter() {
        for (int i = 0; i < longueur; ++i) {
            for(int j = 0; j < largeur; ++j) {
                if (emplacements[i][j] != null){
                    Emplacement e = emplacements[i][j];
                    if (e.getVegetal().getEtat() == Etat.FLEUR){
                        this.emplacements[i][j] = null;
                        if(e.getVegetal() instanceof IRacePure) {
                            IRacePure v = (IRacePure) e.getVegetal();
                            v.seReproduire(this.panier);
                        }

                        if(e.getVegetal() instanceof IOgm) {
                            IOgm v = (IOgm) e.getVegetal();

                            var sd = v.seDupliquer(longueur,largeur);
                            if (e.getVegetal() instanceof Betterave) {
                                if (this.emplacements[sd.getKey()][sd.getValue()] == null){
                                    this.emplacements[sd.getKey()][sd.getValue()] = new Emplacement(e.getVegetal());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
