package compte;

import Service.Retrait;

public class compteCourant extends compte {

 private double decouvert;

     public compteCourant(String code , double montant,double decouvert){
         super(code,montant);
         this.decouvert = decouvert;
     }

     @Override
    public void retirer(Retrait r){
         try {
             if (solde - r.getMontant() >= -decouvert) {
                 this.solde -= r.getMontant();
                 ajouterOperation(r);
                 System.out.println("votre retraita ete effectuer avec success");
             } else {
                 System.out.println("⚠\uFE0F Retrait refusé : dépassement du découvert autorisé.");
             }
         }catch (Exception e){
             System.out.println(e.getMessage());
         }
    }
    @Override
    public  double calculerInteret(){
        return 0;
    }

    @Override
    public void afficherDetails(){
        System.out.println("-------------------------------");
        System.out.println("code : "+code);
        System.out.println("solde : "+solde+"DH");
        System.out.println("Découvert autorisé : " + decouvert);
    }
}
