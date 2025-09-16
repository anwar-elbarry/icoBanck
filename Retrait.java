import java.util.ArrayList;
import java.util.Arrays;

public class Retrait extends operation {
   protected ArrayList<String> destination = new ArrayList<>(Arrays.asList("Distributeur ATM", "Chèque", "Virement sortant"));
    public Retrait(double montant){
        super(montant);
    }
}