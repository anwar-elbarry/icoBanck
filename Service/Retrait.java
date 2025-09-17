package Service;


public class Retrait extends operation {
   private  String destination ;
    public Retrait(double montant,String destination){
        super(montant);
        this.destination = destination;
    }

    @Override
    public String getType() {
        return "Retrait";
    }

    public String getDestination(){
        return this.destination;
    }
}