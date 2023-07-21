package Flore;

import java.util.AbstractMap;

public class Betterave extends Vegetal implements IOgm{
    public Betterave() {
        super();
        dessins[3] = 'b';
        dessins[4] = 'B';
    }


    @Override
    public AbstractMap.SimpleEntry<Integer, Integer> seDupliquer(int longueur, int largeur) {
        int max = longueur;
        int min = 1;
        int range = max - min + 1;

        int x = (int)(Math.random() * range) + min;
        --x;

        max = largeur;
        range = max - min + 1;

        int y = (int)(Math.random() * range) + min;
        --y;

        this.etat = Etat.GRAINE;

        return  new AbstractMap.SimpleEntry<>(x,y);
    }
}
