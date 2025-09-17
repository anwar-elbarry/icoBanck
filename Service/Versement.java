import Service.operation;

import java.util.ArrayList;
import java.util.Arrays;

public class Versement extends operation {
   protected ArrayList<String> source = new ArrayList<>(Arrays.asList( "Virement externe", "Dépôt espèces", "Salaire"));
    public Versement(double montant) {
        super(montant);
    }
}
