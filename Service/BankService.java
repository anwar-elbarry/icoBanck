package Service;
import java.util.*;

public class BankService {
private HashMap<String , compte> comptes = new HashMap<>();
    private String code;

    public void ajouterCompte(compte c){
      comptes.put(c.getCode(),c);
  }

  public void creerCompteCourant(String code,double montant,double decouvert){
    compte c = new compteCourant(code,montant,decouvert);
    comptes.put(c.getCode(),c);
    c.afficherDetails();
  }
  public void creerCompteEpargne(String code,double montant,double tauxInteret){
    compte c = new compteEpargne(code,montant,tauxInteret);
    comptes.put(c.getCode(),c);
      c.afficherDetails();
  }

  public void effectuerVersement(String code,double montant,String source){
      Versement ver = new Versement(code,montant,source);
        System.out.println("versement de "+montant + "de source("+source+")");
  }

  public void effectuerRetrait(double montant,String destination){
      Retrait ret = new Retrait(montant,destination);
  }

  public boolean trouverCompte(String code){
      compte c = comptes.get(code);
      return c != null;
  }
}
