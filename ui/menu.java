import java.io.InputStream;
import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean quitter = false;

        while(!quitter){
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Créer un compte");
            System.out.println("2. Effectuer un versement");
            System.out.println("3. Effectuer un retrait");
            System.out.println("4. Effectuer un virement");
            System.out.println("5. Consulter solde");
            System.out.println("6. Consulter opérations");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            int choix = sc.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("👉 Création d'un compte (exemple)");
                    break;
                case 2:
                    System.out.println("👉 Versement effectué (exemple)");
                    break;
                case 3:
                    System.out.println("👉 Retrait effectué (exemple)");
                    break;
                case 4:
                    System.out.println("👉 Votre solde est : ...");
                    break;
                case 0:
                    quitter = true;
                    System.out.println("✅ Programme terminé.");
                    break;
                default:
                    System.out.println("❌ Choix invalide !");
            }
        }
       sc.close();
    }
}
