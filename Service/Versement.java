package Service;

public class Versement extends operation {
   private String source ;
    public Versement(String code,double montant,String source) {
        super(montant);
        this.source = source;
    }

    @Override
    public String getType() {
        return "Versement";
    }

    public String getSource(){
        return this.source;
    }
}