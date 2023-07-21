package entities;

import Flore.Etat;
import Flore.Vegetal;

public class Emplacement {
    private Vegetal vegetal;

    public Emplacement(Vegetal vegetal) {
        this.vegetal = vegetal;
    }

    public Vegetal getVegetal() {
        return vegetal;
    }

    @Override
    public String toString() {
        return vegetal.toString();
    }
}
