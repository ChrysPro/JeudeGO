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
    private Scanner s;
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
        s = new Scanner(System.in);
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
     * Retourne la couleur stockée en b
     *
     * @return
     */
    public String getb() {
        return b;
    }

    /**
     * retourne la couleur stockée en n
     *
     * @return
     */
    public String getn() {
        return n;
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
     * Vérifie si un groupe de pion de couleur couleur est entouré Empeche de
     * jouer à une position qui vient d'être prise -> Pris
     *
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
                } else if (j == hauteur - 1) {
// On verifie la prise aux coins (2eme coin)
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
                } else if (j == hauteur - 1) {
                    // On verifie la prise aux coins (4eme coin)
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
            } else {
                // On verifie la prise au centre du plateau
                if (!(("Libre".equals(plateau.get(i * hauteur + j - 1))) && !("Pris".equals(plateau.get(i * hauteur + j - 1))) && !("Non Pris".equals(plateau.get(i * hauteur + j - 1))))
                        && !("Libre".equals(plateau.get((i + 1) * hauteur + j)) && !("Pris".equals(plateau.get((i + 1) * hauteur + j))) && !("Non Pris".equals(plateau.get((i + 1) * hauteur + j))))
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
                        || "Non Pris".equals(plateau.get(i * hauteur + j - 1)) || "Non Pris".equals(plateau.get((i + 1) * hauteur + j))
                        || "Libre".equals(plateau.get((i - 1) * hauteur + j)) || "Non Pris".equals(plateau.get((i - 1) * hauteur + j))
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
        String aff = "";
        for (int i = 0; i < this.hauteur; i++) {
            aff = aff + " _";
        }
        System.out.println(aff);// NOSONAR
        aff = "";
        for (int j = 0; j < a; j++) {
            aff = aff + "|" + plateau.get(j);
            if (j % this.hauteur == this.hauteur - 1) {
                aff = aff + "|";
                System.out.println(aff);// NOSONAR
                aff = "";
            }
        }
        for (int i = 0; i < this.hauteur; i++) {
            aff = aff + " _";
        }
        System.out.println(aff);// NOSONAR
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
     * Méthode pour jouer à 2 joueurs
     */
    public void partie() {
        int joueur = 1;
        int passe = 0;
        String i;
        String j;
        int k;
        int l;
        while (joueur != 0) {
            passe=this.jouer(joueur, passe);
            if (passe==2){
                joueur=0;
            }
            else {
                joueur=(-1)*joueur+3;
            }
        }
        int p1 = this.points(this.b);
        int p2 = this.points(this.n);
        if (p1 >= p2) {
            System.out.println("Le joueur blanc a gagné"); //NOSONAR
        } else {
            System.out.println("Le joueur noir a gagné"); //NOSONAR
        }
        System.out.println("Merci d'avoir joué !");// NOSONAR
    }

    public int points(String couleur) {
        int k = 0;
        for (int i = 0; i < (hauteur * hauteur); i++) {
            if (couleur.equals(this.plateau.get(i))) {
                k = k + 1;
            }
        }
        return k;
    }

    public int jouer(int joueur, int passe) {
        String couleur = "";
        String i;
        int k;
        String j;
        int l;
        if (joueur == 1) {
            System.out.println("C'est au tour du joueur Noir de jouer");// NOSONAR
            couleur = this.getn();
        } else if (joueur == 2) {
            System.out.println("C'est au tour du joueur Blanc de jouer");// NOSONAR
            couleur = this.getb();
        }
        System.out.println("Que voulez-vous faire ? Jouer(J) ou Passer(p)");// NOSONAR
        reponse = s.nextLine();
        if ("P".equals(reponse) || "p".equals(reponse)) {
            // Quand joueur est à 2, il passe à 1 et vice-versa
            passe = passe + 1;
        } else {
            System.out.println("Ou voulez-vous jouer ? (position en i entre 1 et " + this.hauteur + "):");// NOSONAR
            i = s.nextLine();
            k = Integer.parseInt(i);
            System.out.println("Ou voulez-vous jouer ? (position en j entre 1 et " + this.hauteur + "):");// NOSONAR
            j = s.nextLine();
            l = Integer.parseInt(j);
            while (!this.placeLibre(k - 1, l - 1)) {
                System.out.println("Désolé, la place n'est pas libre");// NOSONAR
                System.out.println("Ou voulez-vous jouer ? (position en i entre 1 et " + this.hauteur + "):");// NOSONAR
                i = s.nextLine();
                k = Integer.parseInt(i);
                System.out.println("Ou voulez-vous jouer ? (position en j entre 1 et " + this.hauteur + "):");// NOSONAR
                j = s.nextLine();
                l = Integer.parseInt(j);
            }
            this.clear();
            this.setposition(k - 1, l - 1, couleur);
            passe = 0;
            this.afficher();
        }
    return passe;}
}
