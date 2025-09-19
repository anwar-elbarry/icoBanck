package Service;
import compte.compte;
import compte.compteCourant;
import compte.compteEpargne;

import java.util.*;

public class BankService {
private HashMap<String , compte> comptes = new HashMap<>();
    private String code;

  public void creerCompteCourant(String code,double montant,double decouvert){
      try{
          if (montant <= 0){
              System.out.println("Le montant doit être positif.");
          }else {
              compte c = new compteCourant(code,montant,decouvert);
              comptes.put(c.getCode(),c);
              c.afficherDetails();
          }
      }catch (Exception e){
          System.out.println("error lors du la création de compte");
      }

  }
  public void creerCompteEpargne(String code,double montant,double tauxInteret){
      try {
          if (montant <= 0){
              System.out.println("Le montant doit être positif.");
          }else {
          compte c = new compteEpargne(code,montant,tauxInteret);
          comptes.put(c.getCode(),c);
          c.afficherDetails();
          }
      }catch (Exception e){
          System.out.println("error lors du la création de compte");
      }
  }

  public void effectuerVersement(String code,double montant,String source){
      try {
          if (montant <= 0){
              System.out.println("Le montant doit être positif.");
          }else {
          Versement ver = new Versement(code,montant,source);
          System.out.println("versement de "+montant + "DH  de source("+source+")");
          compte c = comptes.get(code);
          c.deposer(ver);
          }
      }catch (Exception e){
          System.out.println("error lors du versement");
      }
  }

  public void effectuerRetrait(String code,double montant,String destination){
      try{
          if (montant <= 0){
              System.out.println("Le montant doit être positif.");
          }else {
          compte c = comptes.get(code);
          Retrait ret = new Retrait(montant,destination);
          c.retirer(ret);
          }
      }catch (Exception e){
          System.out.println("error lors du retrait");
      }
  }

  public boolean trouverCompte(String code){
    compte c = comptes.get(code);
    return c != null;
  }

  public double trouverSolde(String code){
      return comptes.get(code).getSolde();
  }

  public void showList() {
      try{
          ArrayList<compte> list = new ArrayList<>(comptes.values());
          if (list.isEmpty()){
              System.out.println("Aucun compte n'est enregistré pour le moment.");
          }else {
              for (compte c : list) {
                  c.afficherDetails();
              }
          }
      }catch (Exception e){
          System.out.println("error lors de afficher la liste");
      }

}

  public void effectuerVirment(String codeSource,String codeDestination,double montant) {
      try {
          compte src = comptes.get(codeSource);
          compte dis = comptes.get(codeDestination);
          if(src == null || dis == null){
              System.out.println("Compte source ou destination introuvable");
          }else{
              if(montant <= 0){
                  System.out.println("le montant doit étre positife");
              }else{
                  Retrait r = new Retrait(montant,"Virment vers :"+dis.getCode());
                  src.retirer(r);
                  Versement v = new Versement(dis.getCode(),montant,"Virment depuis"+src.getCode());
                  dis.deposer(v);
              }
          }
      }catch (Exception e){
          System.out.println("error lors du virment");
      }

  }
  public void ListOperations(String code){
      try {
          compte c = comptes.get(code);
          List<operation> operations = new ArrayList<>(c.listOperations());
          System.out.println("Opérations pour le compte " + code + ":");
          if (operations.isEmpty()){
              System.out.println("Aucune opération disponible pour ce compte.");
          }else {
              for (operation o :operations){
                  System.out.println(o.toString());
              }
          }
      }catch (Exception e){
          System.out.println("error lors de l'affichage des operations");
      }

  }
}
