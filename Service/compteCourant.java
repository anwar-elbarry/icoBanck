package Service;

public class compteCourant extends compte {

 protected double decouvert;

     public compteCourant(String code , double montant,double decouvert){
         super(code,montant);
         this.decouvert = decouvert;
     }

     @Override
    public void retirer(Retrait r) {
         if(solde - r.montant >= -decouvert){
             this.solde -= r.montant;
             ajouterOperation(r);
         }else{
             System.out.println("⚠\uFE0F Retrait refusé : dépassement du découvert autorisé.");
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
