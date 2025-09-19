package ui;
import Service.BankService;

import java.util.Objects;
import java.util.Scanner;

public class menu {
    public static Scanner sc = new Scanner(System.in);
    public static BankService bank = new BankService();
    public static void main(String[] args) throws Exception {

        boolean quitter = false;
        try {
        while(!quitter){

                uiMenu();
                int choix = sc.nextInt();
                switch (choix) {
                    case 1:
                        ajouterCompte();
                        break;
                    case 2:
                        effectuerVersement();
                        break;
                    case 3:
                        effectuerRetrait();
                        break;
                    case 4:
                        effectuearVirment();
                        break;
                    case 5:
                        getSolde();
                        break;
                    case 6 :
                        getOperations();
                        break;
                    case 7 :
                        bank.showList();
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
        }catch (Exception e){
            System.out.println("Erreur : " + e.getMessage());
        }

    }

    public static void uiMenu (){
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Créer un compte");
        System.out.println("2. Effectuer un versement");
        System.out.println("3. Effectuer un retrait");
        System.out.println("4. Effectuer un virement");
        System.out.println("5. Consulter solde");
        System.out.println("6. Consulter opérations");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    public static void ajouterCompte(){
        System.out.println("choiser le type de votre compte :(1)Courant / (2)Epargne");
        int type = sc.nextInt();
        if (type == 1){
            System.out.println("deposer un montant : ");
            double montant = sc.nextDouble();
            System.out.println("ecreer un code pour votre compte(5chiffre) : CPT-");
            String code = sc.next();
            if (!code.matches("\\d{5}")){
                System.out.println("Code invalide. Entrez exactement 5 chiffres (ex : 01234).");
            }else{
                System.out.println("ecreer votre decouvert : ");
                double decouvert = sc.nextDouble();
                boolean isCompte = bank.trouverCompte("CPT-"+code);
                if (isCompte){
                    System.out.println("ce code déja exister");
                }else{
                bank.creerCompteCourant(code,montant,decouvert);
                System.out.println("Votre compte a ete creer avec success");
                }
            }
        } else if (type == 2) {
            System.out.println("deposer un montant : ");
            double montant = sc.nextDouble();
            System.out.println("ecreer un code pour votre compte : CPT-");
            String code = sc.next();
            if (!code.matches("\\d{5}")) {
                System.out.println("Code invalide. Entrez exactement 5 chiffres (ex : 01234).");
            }else {
                System.out.println("ecreer votre tauxInteret : ");
                double tauxInteret = sc.nextDouble();
                bank.creerCompteEpargne(code,montant,tauxInteret);
                System.out.println("Votre compte a ete creer avec success");
            }

        }else {
            System.out.println("❌ Choix invalide !");
        }
    }

    public static void effectuerVersement(){
        System.out.println("veuiz entrez le code de votre compte (CPT-XXXXX):");
        String code = sc.next();
        boolean isCompte = bank.trouverCompte(code);
        if (isCompte){
            System.out.println("veuiez entrez le montant :");
            double montant = sc.nextDouble();
            System.out.println("veuiez entrez le source :");
            String source = sc.next();
            bank.effectuerVersement(code,montant,source);
        }else {
            System.out.println("Aucun compte trouvé avec ce code.");
        }
    }

    public static void getSolde(){
        System.out.println("veuiz entrez le code de votre compte (CPT-XXXXX):");
        String code = sc.next();
        boolean isCompte = bank.trouverCompte(code);
        if(isCompte){
            System.out.println("👉 Votre solde est : "+bank.trouverSolde(code)+" DH");
        }else{
            System.out.println("Aucun compte trouvé avec ce code.");
        }
    }

    public static void getOperations(){
        System.out.println("veuiz entrez le code de votre compte (CPT-XXXXX):");
        String code = sc.next();
        boolean isCompte = bank.trouverCompte(code);
        if(isCompte){
               bank.ListOperations(code);
        }else{
            System.out.println("Aucun compte trouvé avec ce code.");
        }
    }

    public static void effectuerRetrait(){
        System.out.println("veuiz entrez le code de votre compte (CPT-XXXXX):");
        String code = sc.next();
        boolean isCompte = bank.trouverCompte(code);
        if (isCompte){
            System.out.println("veuiez entrez le montant :");
            double montant = sc.nextDouble();
            System.out.println("veuiez entrez la destination :");
            String destination = sc.next();
            bank.effectuerRetrait(code,montant,destination);
        }else {
            System.out.println("Aucun compte trouvé avec ce code.");
        }
    }

    public static void effectuearVirment(){
        System.out.println("veuiz entrez le code de votre compte (CPT-XXXXX):");
        String src = sc.next();
        System.out.println("veuiz entrez le code de compte de destination  (CPT-XXXXX):");
        String dis = sc.next();
        if(Objects.equals(src, dis)){
            System.out.println("⚠️ Erreur : le compte source et le compte de destination ne peuvent pas être identiques.");
            return;
        }
            System.out.println("veuiez entrez le montant :");
        double montant = sc.nextDouble();
            bank.effectuerVirment(src,dis,montant);
        System.out.println("✅ Virement de " + montant + " effectué avec succès de " + src + " vers " + dis + ".");
    }
}
