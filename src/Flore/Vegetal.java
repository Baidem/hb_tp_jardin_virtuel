package Flore;

public abstract class Vegetal {
    protected String name;
    protected Etat etat;
    protected char[] dessins;

    public Vegetal() {
        this.dessins = new char[6];
        this.dessins[0] = '_';
        this.dessins[1] = '.';
        this.dessins[2] = '|';
        this.dessins[5] = '#';
        this.etat = Etat.GRAINE;
    }


    @Override
    public String toString() {
        return String.valueOf(dessins[etat.ordinal()]);
    }

    public void grandir(){
        int nextIndex = etat.ordinal() + 1;
        if (nextIndex < Etat.values().length) {
            this.etat = Etat.values()[nextIndex];
        }
    }

    public Etat getEtat() {
        return etat;
    }
}


