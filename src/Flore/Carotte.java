package Flore;

import java.util.HashMap;

public class Carotte extends Vegetal implements IRacePure{
    public Carotte() {
        super();
        dessins[3] = 'c';
        dessins[4] = 'C';
    }

    @Override
    public void seReproduire(HashMap<String, Integer> panier) {
        if (panier.get("Carotte") == null){
        panier.put("Carotte", 3);
        } else if (panier.get("Carotte") != null){
            panier.put("Carotte", panier.get("Carotte") + 3);
        }
    }
}
