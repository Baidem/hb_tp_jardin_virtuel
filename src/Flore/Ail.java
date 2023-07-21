package Flore;

import java.util.HashMap;

public class Ail extends Vegetal implements IRacePure{
    public Ail() {
        super();
        dessins[3] = 'a';
        dessins[4] = 'A';
    }

    @Override
    public void seReproduire(HashMap<String, Integer> panier) {
        panier.put("Ail", panier.getOrDefault("Ail", 0)+3);
//        if (panier.get("Ail") == null){
//            panier.put("Ail", 3);
//        } else if (panier.get("Ail") != null){
//            panier.put("Ail", panier.get("Ail") + 3);
//        }
    }
}

