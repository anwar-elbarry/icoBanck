
public class compteEpargne extends compte{
   protected double tauxInteret;

    @Override
    public void retirer(double montant) {
        return;
    }
    @Override
    public  double calculerInteret(){
     return 3;
    }
    @Override
    public void afficherDetails(){
        return;
    }
}
