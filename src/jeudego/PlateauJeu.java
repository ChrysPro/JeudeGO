/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nbrandt
 */
public class PlateauJeu {

    private int hauteur;
    private List<String> plateau;
    private String b;
    private String n;
    /**
     *
     */
    private Scanner S;
    /**
     *
     */
    private String reponse;

    /**
     * Constructeur
     *     
* @param hauteur
     */
    public PlateauJeu(int hauteur) {
        this.hauteur = hauteur;
        b = "Blanc";
        n = "Noir ";
        S = new Scanner(System.in);
        List<String> plat = new ArrayList<String>();
        for (int i = 0; i < (hauteur * hauteur); i++) {
            plat.add("Libre");
        }
        plateau = plat;
    }

    /**
     * Permet d'obtenir la taille du plateau
     *     
* @return
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Permet de modifier la taille du plateau
     *     
* @param hauteur
     */
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    /**
     * Getter plateau
     *     
* @return
     */
    public List<String> getPlateau() {
        return plateau;
    }


    /**
     * Permet d'ajouter un pion de couleur couleur à la position (i,j)
     *     
* @param i
     * @param j
     * @param couleur
     */
    public void setposition(int i, int j, String couleur) {
        this.plateau.set(i * hauteur + j, couleur);
        if (couleur.equals(b)) {
            if (i != 0) {
                this.verifierPrise(this.plateau, i - 1, j, n);
            }
            if (i != hauteur - 1) {
                this.verifierPrise(this.plateau, i + 1, j, n);
            }
            if (j != 0) {
                this.verifierPrise(this.plateau, i, j - 1, n);
            }
            if (j != hauteur - 1) {
                this.verifierPrise(this.plateau, i, j + 1, n);
            }
        }
        if (couleur.equals(n)) {
             if (i != 0) {
                this.verifierPrise(this.plateau, i - 1, j, b);
            }
            if (i != hauteur - 1) {
                this.verifierPrise(this.plateau, i + 1, j, b);
            }
            if (j != 0) {
                this.verifierPrise(this.plateau, i, j - 1, b);
            }
            if (j != hauteur - 1) {
                this.verifierPrise(this.plateau, i, j + 1, b);
            }
        }
    }

    /**
     * Vérifie si l'on peut jouer à un endroit
     *     
* @param i
     * @param j
     * @return
     */
    public boolean placeLibre(int i, int j) {
        if (i < this.hauteur && j < this.hauteur && "Libre".equals(this.plateau.get(i * hauteur + j)) && i >= 0 && j >= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Vérifie si un groupe de pion de couleur couleur est entouré
     * Empeche de jouer à une position qui vient d'être prise -> Pris
     * @param plateau
     * @param i
     * @param j
     * @param couleur
     */
    public void verifierPriseAux(int i, int j, String couleur) {
// On verifie d'abord la prise sur les côtés du plateau
        if (plateau.get(i * hauteur + j).equals(couleur) || "En attente".equals(plateau.get(i * hauteur + j)) || "Non Pris".equals(plateau.get(i * hauteur + j))) {
            if (i == 0) {
// On verifie la prise aux coins (1er coin)
                if (j == 0) {
                    if ((!("Libre".equals(plateau.get(i * hauteur + j + 1))) && !("Non Pris".equals(plateau.get(i * hauteur + j + 1))))
                            && (!("Libre".equals(plateau.get((i + 1) * hauteur + j))) && !("Non Pris".equals(plateau.get((i + 1) * hauteur + j))))) {
                        plateau.set(i * hauteur + j, "En attente");
                        if (plateau.get(i * hauteur + j + 1).equals(couleur)) {
                            verifierPriseAux(i, j + 1, couleur);
                        }
                        if (plateau.get((i + 1) * hauteur + j).equals(couleur)) {
                            verifierPriseAux(i + 1, j, couleur);
                        }
                    }
                    if ("Libre".equals(plateau.get(i * hauteur + j + 1)) || "Libre".equals(plateau.get((i + 1) * hauteur + j))
                            || "Non Pris".equals(plateau.get(i * hauteur + j + 1)) || "Non Pris".equals(plateau.get((i + 1) * hauteur + j))) {
                        plateau.set(i * hauteur + j, "Non Pris");
                        if ("En attente".equals(plateau.get(i * hauteur + j + 1))) {
                            verifierPriseAux(i, j + 1, couleur);
                        }
                        if ("En attente".equals(plateau.get((i + 1) * hauteur + j))) {
                            verifierPriseAux(i + 1, j, couleur);
                        }
                    }
                } else if (j == hauteur - 1) { // On verifie la prise aux coins (2eme coin)
                    if ((!("Libre".equals(plateau.get(i * hauteur + j - 1))) && !("Pris".equals(plateau.get(i * hauteur + j - 1))) && !("Non Pris".equals(plateau.get(i * hauteur + j - 1))))
                            && (!("Libre".equals(plateau.get((i + 1) * hauteur + j)) && !("Pris".equals(plateau.get((i + 1) * hauteur + j))) && !("Non Pris".equals(plateau.get((i + 1) * hauteur + j)))))) {
                        plateau.set(i * hauteur + j, "En attente");
                        if (plateau.get(i * hauteur + j - 1).equals(couleur)) {
                            verifierPriseAux(i, j - 1, couleur);
                        }
                        if (plateau.get((i + 1) * hauteur + j).equals(couleur)) {
                            verifierPriseAux(i + 1, j, couleur);
                        }
                    }
                    if ("Libre".equals(plateau.get(i * hauteur + j - 1)) || "Libre".equals(plateau.get((i + 1) * hauteur + j))
                            || "Pris".equals(plateau.get(i * hauteur + j - 1)) || "Pris".equals(plateau.get((i + 1) * hauteur + j))
                            || "Non Pris".equals(plateau.get(i * hauteur + j - 1)) || "Non Pris".equals(plateau.get((i + 1) * hauteur + j))) {
                        plateau.set(i * hauteur + j, "Non Pris");
                        if ("En attente".equals(plateau.get(i * hauteur + j - 1))) {
                            verifierPriseAux(i, j - 1, couleur);
                        }
                        if ("En attente".equals(plateau.get((i + 1) * hauteur + j))) {
                            verifierPriseAux(i + 1, j, couleur);
                        }
                    }
                } else {
                    if ((!("Libre".equals(plateau.get(i * hauteur + j - 1))) && !("Non Pris".equals(plateau.get(i * hauteur + j - 1))))
                            && (!("Libre".equals(plateau.get((i + 1) * hauteur + j))) && !("Non Pris".equals(plateau.get((i + 1) * hauteur + j))))
                            && (!("Libre".equals(plateau.get(i * hauteur + j + 1))) && !("Non Pris".equals(plateau.get(i * hauteur + j + 1))))) {
                        plateau.set(i * hauteur + j, "En attente");
                        if (plateau.get(i * hauteur + j - 1).equals(couleur)) {
                            verifierPriseAux(i, j - 1, couleur);
                        }
                        if (plateau.get((i + 1) * hauteur + j).equals(couleur)) {
                            verifierPriseAux(i + 1, j, couleur);
                        }
                        if (plateau.get(i * hauteur + j + 1).equals(couleur)) {
                            verifierPriseAux(i, j + 1, couleur);
                        }
                    }
                    if ("Libre".equals(plateau.get(i * hauteur + j - 1)) || "Libre".equals(plateau.get((i + 1) * hauteur + j))
                            || "Pris".equals(plateau.get(i * hauteur + j - 1)) || "Pris".equals(plateau.get((i + 1) * hauteur + j))
                            || "Non Pris".equals(plateau.get(i * hauteur + j - 1)) || "Non Pris".equals(plateau.get((i + 1) * hauteur + j))
                            || "Libre".equals(plateau.get(i * hauteur + j + 1)) || "Non Pris".equals(plateau.get(i * hauteur + j + 1))) {
                        plateau.set(i * hauteur + j, "Non Pris");
                        if ("En attente".equals(plateau.get(i * hauteur + j - 1))) {
                            verifierPriseAux(i, j - 1, couleur);
                        }
                        if ("En attente".equals(plateau.get((i + 1) * hauteur + j))) {
                            verifierPriseAux(i + 1, j, couleur);
                        }
                        if ("En attente".equals(plateau.get(i * hauteur + j + 1))) {
                            verifierPriseAux(i, j + 1, couleur);
                        }
                    }
                }
            } else if (i == hauteur - 1) {
// On verifie la prise aux coins (3eme coin)
                if (j == 0) {
                    if ((!("Libre".equals(plateau.get(i * hauteur + j + 1))) && !("Pris".equals(plateau.get(i * hauteur + j + 1))) && !("Non Pris".equals(plateau.get(i * hauteur + j + 1))))
                            && (!("Libre".equals(plateau.get((i - 1) * hauteur + j))) && !("Pris".equals(plateau.get((i - 1) * hauteur + j))) && !("Non Pris".equals(plateau.get((i - 1) * hauteur + j))))) {
                        plateau.set(i * hauteur + j, "En attente");
                        if (plateau.get(i * hauteur + j + 1).equals(couleur)) {
                            verifierPriseAux(i, j + 1, couleur);
                        }
                        if (plateau.get((i - 1) * hauteur + j).equals(couleur)) {
                            verifierPriseAux(i - 1, j, couleur);
                        }
                    }
                    if ("Libre".equals(plateau.get(i * hauteur + j + 1)) || "Libre".equals(plateau.get((i - 1) * hauteur + j))
                            || "Non Pris".equals(plateau.get(i * hauteur + j + 1)) || "Non Pris".equals(plateau.get((i - 1) * hauteur + j))) {
                        plateau.set(i * hauteur + j, "Non Pris");
                        if ("En attente".equals(plateau.get(i * hauteur + j + 1))) {
                            verifierPriseAux(i, j + 1, couleur);
                        }
                        if ("En attente".equals(plateau.get((i - 1) * hauteur + j))) {
                            verifierPriseAux(i - 1, j, couleur);
                        }
                    }
                } else if (j == hauteur - 1) { // On verifie la prise aux coins (4eme coin)
                    if ((!("Libre".equals(plateau.get(i * hauteur + j - 1))) && !("Non Pris".equals(plateau.get(i * hauteur + j - 1))))
                            && (!("Libre".equals(plateau.get((i - 1) * hauteur + j))) && !("Non Pris".equals(plateau.get((i - 1) * hauteur + j))))) {
                        plateau.set(i * hauteur + j, "En attente");
                        if (plateau.get(i * hauteur + j - 1).equals(couleur)) {
                            verifierPriseAux(i, j - 1, couleur);
                        }
                        if (plateau.get((i - 1) * hauteur + j).equals(couleur)) {
                            verifierPriseAux(i - 1, j, couleur);
                        }
                    }
                    if ("Libre".equals(plateau.get(i * hauteur + j - 1)) || "Libre".equals(plateau.get((i - 1) * hauteur + j))
                            || "Non Pris".equals(plateau.get(i * hauteur + j - 1)) || "Non Pris".equals(plateau.get((i - 1) * hauteur + j))) {
                        plateau.set(i * hauteur + j, "Non Pris");
                        if ("En attente".equals(plateau.get(i * hauteur + j - 1))) {
                            verifierPriseAux(i, j - 1, couleur);
                        }
                        if ("En attente".equals(plateau.get((i - 1) * hauteur + j))) {
                            verifierPriseAux(i - 1, j, couleur);
                        }
                    }
                } else {
                    if ((!("Libre".equals(plateau.get(i * hauteur + j - 1))) && !("Pris".equals(plateau.get(i * hauteur + j - 1))) && !("Non Pris".equals(plateau.get(i * hauteur + j - 1))))
                            && (!("Libre".equals(plateau.get((i - 1) * hauteur + j))) && !("Pris".equals(plateau.get((i - 1) * hauteur + j))) && !("Non Pris".equals(plateau.get((i - 1) * hauteur + j))))
                            && (!("Libre".equals(plateau.get(i * hauteur + j + 1))) && !("Pris".equals(plateau.get(i * hauteur + j + 1))) && !("Non Pris".equals(plateau.get(i * hauteur + j + 1))))) {
                        plateau.set(i * hauteur + j, "En attente");
                        if (plateau.get(i * hauteur + j - 1).equals(couleur)) {
                            verifierPriseAux(i, j - 1, couleur);
                        }
                        if (plateau.get((i - 1) * hauteur + j).equals(couleur)) {
                            verifierPriseAux(i - 1, j, couleur);
                        }
                        if (plateau.get(i * hauteur + j + 1).equals(couleur)) {
                            verifierPriseAux(i, j + 1, couleur);
                        }
                    }
                    if ("Libre".equals(plateau.get(i * hauteur + j - 1)) || "Libre".equals(plateau.get((i - 1) * hauteur + j))
                            || "Non Pris".equals(plateau.get(i * hauteur + j - 1)) || "Non Pris".equals(plateau.get((i - 1) * hauteur + j))
                            || "Libre".equals(plateau.get(i * hauteur + j + 1)) || "Non Pris".equals(plateau.get(i * hauteur + j + 1))) {
                        plateau.set(i * hauteur + j, "Non Pris");
                        if ("En attente".equals(plateau.get(i * hauteur + j - 1))) {
                            verifierPriseAux(i, j - 1, couleur);
                        }
                        if ("En attente".equals(plateau.get((i - 1) * hauteur + j))) {
                            verifierPriseAux(i - 1, j, couleur);
                        }
                        if ("En attente".equals(plateau.get(i * hauteur + j + 1))) {
                            verifierPriseAux(i, j + 1, couleur);
                        }
                    }
                }
            } else if (j == 0) {
                if (!("Libre".equals(plateau.get(i * hauteur + j + 1))) && !("Pris".equals(plateau.get(i * hauteur + j + 1))) && !("Non Pris".equals(plateau.get(i * hauteur + j + 1)))
                        && (!("Libre".equals(plateau.get((i + 1) * hauteur + j))) && !("Pris".equals(plateau.get((i + 1) * hauteur + j))) && !("Non Pris".equals(plateau.get((i + 1) * hauteur + j)))
                        && (!("Libre".equals(plateau.get((i - 1) * hauteur + j))) && !("Pris".equals(plateau.get((i - 1) * hauteur + j))) && !("Non Pris".equals(plateau.get((i - 1) * hauteur + j)))))) {
                    plateau.set(i * hauteur + j, "En attente");
                    if (plateau.get(i * hauteur + j + 1).equals(couleur)) {
                        verifierPriseAux(i, j + 1, couleur);
                    }
                    if (plateau.get((i + 1) * hauteur + j).equals(couleur)) {
                        verifierPriseAux(i + 1, j, couleur);
                    }
                    if (plateau.get((i - 1) * hauteur + j).equals(couleur)) {
                        verifierPriseAux(i - 1, j, couleur);
                    }
                }
                if ("Libre".equals(plateau.get(i * hauteur + j + 1)) || "Libre".equals(plateau.get((i + 1) * hauteur + j))
                        || "Non Pris".equals(plateau.get(i * hauteur + j + 1)) || "Non Pris".equals(plateau.get((i + 1) * hauteur + j))
                        || "Non Pris".equals(plateau.get((i - 1) * hauteur + j)) || "Libre".equals(plateau.get((i - 1) * hauteur + j)) || "Pris".equals(plateau.get((i - 1) * hauteur + j))) {
                    plateau.set(i * hauteur + j, "Non Pris");
                    if ("En attente".equals(plateau.get(i * hauteur + j + 1))) {
                        verifierPriseAux(i, j + 1, couleur);
                    }
                    if ("En attente".equals(plateau.get((i + 1) * hauteur + j))) {
                        verifierPriseAux(i + 1, j, couleur);
                    }
                    if ("En attente".equals(plateau.get((i - 1) * hauteur + j))) {
                        verifierPriseAux(i - 1, j, couleur);
                    }
                }
            } else if (j == hauteur - 1) {
                if (!("Libre".equals(plateau.get(i * hauteur + j - 1))) && !("Non Pris".equals(plateau.get(i * hauteur + j - 1)))
                        && (!("Libre".equals(plateau.get((i + 1) * hauteur + j))) && !("Non Pris".equals(plateau.get((i + 1) * hauteur + j))))
                        && !("Libre".equals(plateau.get((i - 1) * hauteur + j)) && !("Non Pris".equals(plateau.get((i - 1) * hauteur + j))))) {
                    plateau.set(i * hauteur + j, "En attente");
                    if (plateau.get(i * hauteur + j - 1).equals(couleur)) {
                        verifierPriseAux(i, j - 1, couleur);
                    }
                    if (plateau.get((i + 1) * hauteur + j).equals(couleur)) {
                        verifierPriseAux(i + 1, j, couleur);
                    }
                    if (plateau.get((i - 1) * hauteur + j).equals(couleur)) {
                        verifierPriseAux(i - 1, j, couleur);
                    }
                }
                if ("Libre".equals(plateau.get(i * hauteur + j - 1)) || "Libre".equals(plateau.get((i + 1) * hauteur + j))
                        || "Pris".equals(plateau.get(i * hauteur + j - 1)) || "Pris".equals(plateau.get((i + 1) * hauteur + j))
                        || "Non Pris".equals(plateau.get(i * hauteur + j - 1)) || "Non Pris".equals(plateau.get((i + 1) * hauteur + j))
                        || "Libre".equals(plateau.get((i - 1) * hauteur + j)) || "Non Pris".equals(plateau.get((i - 1) * hauteur + j))) {
                    plateau.set(i * hauteur + j, "Non Pris");
                    if ("En attente".equals(plateau.get(i * hauteur + j - 1))) {
                        verifierPriseAux(i, j - 1, couleur);
                    }
                    if ("En attente".equals(plateau.get((i + 1) * hauteur + j))) {
                        verifierPriseAux(i + 1, j, couleur);
                    }
                    if ("En attente".equals(plateau.get((i - 1) * hauteur + j))) {
                        verifierPriseAux(i - 1, j, couleur);
                    }
                }
            } // On verifie la prise au centre du plateau
            else {
                if (!(("Libre".equals(plateau.get(i * hauteur + j - 1))) &&!("Pris".equals(plateau.get(i * hauteur + j - 1))) && !("Non Pris".equals(plateau.get(i * hauteur + j - 1))))
                        && !("Libre".equals(plateau.get((i + 1) * hauteur + j)) && !("Pris".equals(plateau.get((i + 1) * hauteur + j))) &&!( "Non Pris".equals(plateau.get((i + 1) * hauteur + j))))
                        && !("Libre".equals(plateau.get((i - 1) * hauteur + j)) && !("Pris".equals(plateau.get((i - 1) * hauteur + j))) && !("Non Pris".equals(plateau.get((i - 1) * hauteur + j))))
                        && !("Libre".equals(plateau.get(i * hauteur + j + 1)) && !("Pris".equals(plateau.get(i * hauteur + j + 1))) && !("Non Pris".equals(plateau.get(i * hauteur + j + 1))))) {
                    plateau.set(i * hauteur + j, "En attente");
                    if (plateau.get(i * hauteur + j - 1).equals(couleur)) {
                        verifierPriseAux(i, j - 1, couleur);
                    }
                    if (plateau.get((i + 1) * hauteur + j).equals(couleur)) {
                        verifierPriseAux(i + 1, j, couleur);
                    }
                    if (plateau.get((i - 1) * hauteur + j).equals(couleur)) {
                        verifierPriseAux(i - 1, j, couleur);
                    }
                    if (plateau.get(i * hauteur + j + 1).equals(couleur)) {
                        verifierPriseAux(i, j + 1, couleur);
                    }
                }
                if ("Libre".equals(plateau.get(i * hauteur + j - 1)) || "Libre".equals(plateau.get((i + 1) * hauteur + j))
                        ||"Non Pris".equals(plateau.get(i * hauteur + j - 1)) || "Non Pris".equals(plateau.get((i + 1) * hauteur + j))
                        ||"Libre".equals( plateau.get((i - 1) * hauteur + j)) || "Non Pris".equals(plateau.get((i - 1) * hauteur + j))
                        || "Libre".equals(plateau.get(i * hauteur + j + 1)) || "Non Pris".equals(plateau.get(i * hauteur + j + 1))) {
                    plateau.set(i * hauteur + j, "Non Pris");
                    if ("En attente".equals(plateau.get(i * hauteur + j - 1))) {
                        verifierPriseAux(i, j - 1, couleur);
                    }
                    if ("En attente".equals(plateau.get((i + 1) * hauteur + j))) {
                        verifierPriseAux(i + 1, j, couleur);
                    }
                    if ("En attente".equals(plateau.get((i - 1) * hauteur + j))) {
                        verifierPriseAux(i - 1, j, couleur);
                    }
                    if ("En attente".equals(plateau.get(i * hauteur + j + 1))) {
                        verifierPriseAux(i, j + 1, couleur);
                    }
                }
            }
        }
    }

    /**
     * Verifie si un groupe de pions de couleur couleur est pris
     *     
* @param plateau
     * @param i
     * @param j
     * @param couleur
     */
    public void verifierPrise(List<String> plateau, int i, int j, String couleur) {
        this.verifierPriseAux(i, j, couleur);
        for (int k = 0; k < plateau.size(); k++) {
            
            if ("En attente".equals(plateau.get(k))) {
                plateau.set(k, "Pris");
            }
            if ("Non Pris".equals(plateau.get(k))) {
                plateau.set(k, couleur);
            }
        }
    }
    
    

    /**
     * Affichage en mode texte
     *     
*/
    public void afficher() {
        int a = plateau.size();
        String b = "";
        for (int i = 0; i < this.hauteur; i++) {
            b = b + " _";
        }
        System.out.println(b);// NOSONAR
        b = "";
        for (int j = 0; j < a; j++) {
            b = b + "|" + plateau.get(j);
            if (j % this.hauteur == this.hauteur - 1) {
                b = b + "|";
                System.out.println(b);// NOSONAR
                b = "";
            }
        }
        for (int i = 0; i < this.hauteur; i++) {
            b = b + " _";
        }
        System.out.println(b);// NOSONAR
        b = "";
    }
/**
 * Redéfinit les cases prises en cases libres
 */
    public void clear() {
         for (int k = 0; k < plateau.size(); k++) {
            
            if ("Pris".equals(plateau.get(k))) {
                plateau.set(k, "Libre");
            }
        }
    }
    
    /**
     *Méthode pour jouer à 2 joueurs
     */

    public void partie() {
        int joueur = 1;
        int passe = 0;
        String i;
        String j;
        int k;
        int l;
        while (joueur != 0) {
            if (passe == 2) {
                joueur = 0;
            } else if (joueur == 1) {
                System.out.println("C'est au tour du joueur Noir de jouer");// NOSONAR
                System.out.println("Que voulez-vous faire ? Jouer(J) ou Passer(p)");// NOSONAR
                reponse = S.nextLine();
                if ("P".equals(reponse) || "p".equals(reponse)) {
                    joueur = 2;
                    passe = passe + 1;
                } else {
                    System.out.println("Ou voulez-vous jouer ? (position en i entre 1 et " + this.hauteur + "):");// NOSONAR
                    i = S.nextLine();
                    k = Integer.parseInt(i);
                    System.out.println("Ou voulez-vous jouer ? (position en j entre 1 et " + this.hauteur + "):");// NOSONAR
                    j = S.nextLine();
                    l = Integer.parseInt(j);
                    while (!this.placeLibre(k - 1, l - 1)) {
                        System.out.println("Désolé, la place n'est pas libre");// NOSONAR
                        System.out.println("Ou voulez-vous jouer ? (position en i entre 1 et " + this.hauteur + "):");// NOSONAR
                        i = S.nextLine();
                        k = Integer.parseInt(i);
                        System.out.println("Ou voulez-vous jouer ? (position en j entre 1 et " + this.hauteur + "):");// NOSONAR
                        j = S.nextLine();
                        l = Integer.parseInt(j);
                    }
                    this.clear();
                    this.setposition(k - 1, l - 1, n);
                    joueur = 2;
                    passe = 0;
                    this.afficher();
                }
            } else if (joueur == 2) {
                System.out.println("C'est au tour du joueur Blanc de jouer");// NOSONAR
                System.out.println("Que voulez-vous faire ? Jouer(J) ou Passer(p)");// NOSONAR
                reponse = S.nextLine();
                if ("P".equals(reponse) ||"p".equals(reponse)) {
                    joueur = 1;
                    passe = passe + 1;
                } else {
                    System.out.println("Ou voulez-vous jouer ? (position en i entre 1 et " + this.hauteur + "):");// NOSONAR
                    i = S.nextLine();
                    k = Integer.parseInt(i);
                    System.out.println("Ou voulez-vous jouer ? (position en j entre 1 et " + this.hauteur + "):");// NOSONAR
                    j = S.nextLine();
                    l = Integer.parseInt(j);
                    while (!this.placeLibre(k - 1, l - 1)) {
                        System.out.println("Désolé, la place n'est pas libre");// NOSONAR
                        System.out.println("Ou voulez-vous jouer ? (position en i entre 1 et " + this.hauteur + "):");// NOSONAR
                        i = S.nextLine();
                        k = Integer.parseInt(i);
                        System.out.println("Ou voulez-vous jouer ? (position en j entre 1 et " + this.hauteur + "):");// NOSONAR
                        j = S.nextLine();
                        l = Integer.parseInt(j);
                    }
                    this.clear();
                    this.setposition(k - 1, l - 1, b);
                    joueur = 1;
                    passe = 0;
                    this.afficher();
                }
            }
        }
        System.out.println("Merci d'avoir joué !");// NOSONAR
    }
}
