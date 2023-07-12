package entities;

import Flore.Vegetal;

import java.util.Arrays;
import java.util.HashMap;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Voici notre jardin :\n");
        for (int i = 0; i < longueur; ++i) {
            for(int j = 0; j < largeur; ++j) {
                if (emplacements[i][j] == null){
                    sb.append("O");
                } else{
                    sb.append("X");
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
}
