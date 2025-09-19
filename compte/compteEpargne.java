package compte;

import Service.Retrait;

public class compteEpargne extends compte {
   private double tauxInteret;

   public compteEpargne(String code,double montant,double tauxInteret){
       super(code,montant);
       this.tauxInteret = tauxInteret;
   }

    @Override
    public void retirer(Retrait r) {
       try{
           if(solde >= r.getMontant()){
               this.solde -= r.getMontant();
               ajouterOperation(r);
           }else{
               System.out.println("⚠\uFE0F Retrait refusé : solde insuffisant.");
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
       }

    }

    @Override
    public  double calculerInteret(){
     return solde * tauxInteret;
    }

    @Override
    public void afficherDetails(){
        System.out.println("-------------------------------");
        System.out.println("code :"+this.code);
        System.out.println("solde :"+this.solde+"DH");
        System.out.println("Taux d'intérêt: " + tauxInteret);
    }
}
