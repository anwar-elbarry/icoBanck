package Service;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class operation {
    protected String numero ;
    protected LocalDateTime date;
    protected double montant;

    public operation(double montant) {
        this.numero = UUID.randomUUID().toString();
        this.date = LocalDateTime.now();
        this.montant = montant;
    }

    public String getNumero(){
        return numero;
    }

    public LocalDateTime getDate(){
        return date;
    }

    public double getMontant(){
        return  montant;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "[" + getType() + "] " + "nº=" + numero + ", date=" + date + ", montant=" + montant +"DH";
    }
}
