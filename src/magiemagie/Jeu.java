/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magiemagie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Formation
 */
public class Jeu {

    private ArrayList<Joueur> joueurs = new ArrayList<>();
    private Joueur joueurEnCours;

    public void lancerSort() {
        //1. affiche les sorts possibles pour joueurEnCours
        Carte carteCorneLicorne = new Carte();
        Carte carteBaveCrapaud = new Carte();
        Carte carteMandragore = new Carte();
        Carte carteAileCS = new Carte();
        Carte carteLapisLazuli = new Carte();

        carteCorneLicorne.setType(Carte.TypeCarte.CORNE_DE_LICORNE);
        carteBaveCrapaud.setType(Carte.TypeCarte.BAVE_DE_CRAPAUD);
        carteMandragore.setType(Carte.TypeCarte.MANDRAGORE);
        carteAileCS.setType(Carte.TypeCarte.AILE_DE_CHAUVE_SOURIS);
        carteLapisLazuli.setType(Carte.TypeCarte.LAPIS_LAZULI);

        if (this.joueurEnCours.getCartes().contains(carteBaveCrapaud) && this.joueurEnCours.getCartes().contains(carteCorneLicorne)) {
            System.out.println("[1] Sort INVICIBILITE");
        }
        if (this.joueurEnCours.getCartes().contains(carteCorneLicorne) && this.joueurEnCours.getCartes().contains(carteMandragore)) {
            System.out.println("[2] Sort PHILTRE D'AMOUR");
        }
        if (this.joueurEnCours.getCartes().contains(carteBaveCrapaud) && this.joueurEnCours.getCartes().contains(carteLapisLazuli)) {
            System.out.println("[3] Sort HYPNOSE");
        }
        if (this.joueurEnCours.getCartes().contains(carteLapisLazuli) && this.joueurEnCours.getCartes().contains(carteAileCS)) {
            System.out.println("[4] Sort DIVINATION");
        }
        if (this.joueurEnCours.getCartes().contains(carteMandragore) && this.joueurEnCours.getCartes().contains(carteAileCS)) {
            System.out.println("[5] Sort SOMMEIL PROFOND");
        }
        //2. saisie sort à lancer  

        boolean Finir = false;
       do{

            Scanner scanner = new Scanner(System.in);
            String choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    if (this.joueurEnCours.getCartes().contains(carteBaveCrapaud) && this.joueurEnCours.getCartes().contains(carteCorneLicorne))
                    System.out.println("Invincibilité est lancé");
                    sortInvisibilite();
                    Finir=true;
                    else System.out.println("Commande Invalide");
                    break;
                case "2":
                    System.out.println("Philtre d'Amour est lancé");
                    sortPhiltreAmour();
                    Finir=true;
                    break;
                case "3":
                    System.out.println("Hypnose est lancé");
                    sortHypnose();
                    Finir=true;
                    break;
                case "4":
                    System.out.println("Divination est lancé");
                    sortDivination();
                    Finir=true;
                    break;
                case "5":
                    System.out.println("Sommeil profond est lancé");
                    sortSommeilProfond();
                    Finir = true;
                    break;
                default:
                    System.out.println("Ce sort n'existe pas");
                    return;
            }
         } while (Finir == false);
 }

public void sortInvisibilite(){
}
public void sortPhiltreAmour(){
}
public void sortHypnose(){
}
public void sortDivination(){
}
public void sortSommeilProfond(){
}

         //3. supprime 2 cartes ayant permis de lancer le sort
    public void passerTour() {

    }

    //////////Menu Principal//////////////////
    public void afficherMenuPrincipal() {

        boolean quitter = false;
        while (quitter == false) {

            /////////affiche menu////////////
            System.out.println(" MENU PRINCIPAL ");
            System.out.println(" ************** ");
            System.out.println("1. Nouveau joueur");
            System.out.println("2. Démarrer Partie");
            System.out.println("3. Quitter");
            System.out.println("4. Liste des joueurs : ");
            System.out.println("Votre choix : ");

            ////////Saisie Claier//////////////
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.nextLine();
            switch (choix) {
                case "4":
                    System.out.println(this.joueurs);// afficher liste des joueurs
                    break;
                case "1":
                    afficherMenuNouveauJoueur();
                    break;
                case "2":
                    demarrerPartie();
                    break;
                case "3":
                    quitter = true;
                    break;
                default:
                    System.out.println("Sélectionner à nouveau");
            }
        }

    }

    ////////////Joueurs///////////////
//    String J1 = new Joueur("Joueur A");
    ////////////cartes à distribuer///////////
    ////////////menu nouveau joueur//////////
    public void afficherMenuNouveauJoueur() {

        System.out.print("Nom du nouveau joueur : ");

        Scanner s1 = new Scanner(System.in); // Saisie
        String choix = s1.nextLine();

        Joueur joueurNouveau = new Joueur();// Crée joueur
        joueurNouveau.setNom(choix);// selection joueur
        joueurs.add(joueurNouveau);//ajout nouveau joueur dans la liste Array

        System.out.println("Votre nom de joueur : " + choix);

    }

    /////////// partie en cours///////////////
    public void demarrerPartie() {

        //1. Distribue 7 cartes par joueur
        for (Joueur joueur : joueurs) {

            for (int i = 0; i < 7; i++) {
                Carte carte = new Carte();

                // Disribue 7 cartes  pour joueur actuel
                Random random = new Random();
                int nb = random.nextInt(5);
                switch (nb) {
                    case 0:
                        carte.setType(Carte.TypeCarte.MANDRAGORE);
                        break;
                    case 1:
                        carte.setType(Carte.TypeCarte.AILE_DE_CHAUVE_SOURIS);
                        break;
                    case 2:
                        carte.setType(Carte.TypeCarte.BAVE_DE_CRAPAUD);
                        break;
                    case 3:
                        carte.setType(Carte.TypeCarte.CORNE_DE_LICORNE);
                        break;
                    case 4:
                        carte.setType(Carte.TypeCarte.LAPIS_LAZULI);
                        break;
                    default:
                        System.out.println("Fin distribution cartes");
                        break;

                }
                joueur.getCartes().add(carte);
            }
        }

        //2. Doonne la main au 1er joueur
        this.joueurEnCours = this.joueurs.get(0);

        // 3. afficher menu action////////
        this.menuAction();

    }

    public void menuAction() {

        boolean Terminer = false;
        do {

            // 1. afficher menu
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("MENU ACTION");
            System.out.println("---------");
            System.out.println("A vous de jouer: " + joueurEnCours.getNom());
            System.out.println("Vos cartes: " + joueurEnCours.getCartes());
            System.out.println("Actions possibles: [1] lancer un sort [2] passer dson tour. Votre choix: ");

            Scanner scan = new Scanner(System.in);
            String choix = scan.nextLine();
            System.out.println(" ");
            System.out.println(" ");

            // 2. Lancer sort ou passer tour
            switch (choix) {
                case "1":
                    this.lancerSort();
                    Terminer = true;
                    break;
                case "2":
                    this.passerTour();
                    Terminer = true;
                    break;
                default:
                    System.out.println("Commande Invalide");
                    break;
            }
        } while (Terminer == false);
    } //////////get set /////////////////////////

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

}
