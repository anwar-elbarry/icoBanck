package Service;

import java.util.ArrayList;
import java.util.List;

public abstract class compte {

 protected String code ;
 protected double solde ;
 private List<operation> listOperations = new ArrayList<>();

 public compte(String code,double montant){
   this.solde = montant;
   this.code = "CPT-"+code;
 }

 public String getCode(){return code;};
 public double getSolde(){return solde;};

 public abstract void retirer(String code,double montant);
 public abstract double calculerInteret();
 public abstract void afficherDetails();

 public void deposer(Versement v) {
  if (v.getMontant() <= 0) throw new IllegalArgumentException("Montant de versement doit être positif");
  this.solde += v.getMontant();
  ajouterOperation(v);
 }
 public void ajouterOperation(operation op){
  listOperations.add(op);
 }

 public List<operation> listOperations(){
   return this.listOperations;
 }
}
