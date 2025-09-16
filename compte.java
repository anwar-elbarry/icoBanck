import java.util.ArrayList;

public abstract class compte {
 protected String code ;
 protected double solde ;
 protected ArrayList<String> listeOperations;

 public abstract void retirer(double montant);
 public abstract double calculerInteret();
 public abstract void afficherDetails();
}
