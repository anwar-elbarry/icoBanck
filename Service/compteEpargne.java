package Service;

public class compteEpargne extends compte {
   protected double tauxInteret;

   public compteEpargne(String code,double montant,double tauxInteret){
       super(code,montant);
       this.tauxInteret = tauxInteret;
   }

    @Override
    public void retirer(String code,double montant) {
       if(solde >= montant){
           this.solde -= montant ;
       }else{
           System.out.println("⚠\uFE0F Retrait refusé : solde insuffisant.");
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
    }
}
