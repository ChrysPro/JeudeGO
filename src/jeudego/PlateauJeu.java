/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

import java.util.ArrayList;

/**
 *
 * @author nbrandt
 */
public class PlateauJeu {
    
    int hauteur;
    ArrayList<String> plateau;

    /**
     *Constructeur
     * @param hauteur
     */
    public PlateauJeu(int hauteur) {
        this.hauteur = hauteur;
        for (int i=0; i<(hauteur*hauteur); i++){
            plateau.add("Libre");
        }          
    }

    /**
     *Permet d'obtenir la taille du plateau
     * @return
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     *Permet de modifier la taille du plateau
     * @param hauteur
     */
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    /**
     *Getter plateau
     * @return
     */
    public ArrayList<String> getPlateau() {
        return plateau;
    }

    /**
     *Setter Plateau
     * @param plateau
     */
    public void setPlateau(ArrayList<String> plateau) {
        this.plateau = plateau;
    }
   
    /**
     *Permet d'ajouter un pion de couleur couleur à la position (i,j)
     * @param i
     * @param j
     * @param couleur
     */
    public void setposition(int i, int j, String couleur) {
        this.plateau.set(i*hauteur+j, couleur);
        this.verifierPrise(this.plateau, i, j ,couleur );
    }
    
    /**
     * Vérifie si l'on peut jouer à un endroit
     * @param i
     * @param j
     * @return
     */
    public boolean placeLibre (int i, int j) {
        if(i <= this.hauteur && j <= this.hauteur && this.plateau.get(i*hauteur+j).equals("Libre") && i>0 && j>0){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Vérifie si un groupe de pion de couleur couleur est entouré
     * @param plateau
     * @param i
     * @param j
     * @param couleur
     */
    public void verifierPriseAux(ArrayList<String> plateau, int i, int j, String couleur) {
        // On verifie d'abord la prise sur les côtés du plateau
        if (i==0) {
        // On verifie la prise aux coins (1er coin)
            if (j==0) {
                if ((!plateau.get(i*hauteur+j+1).equals("Libre") || !plateau.get(i*hauteur+j+1).equals("Non Pris"))&&
                        (!plateau.get((i+1)*hauteur+j).equals("Libre") || !plateau.get((i+1)*hauteur+j).equals("Non Pris"))) {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j+1).equals(couleur)){
                    verifierPriseAux(plateau,i,j+1,couleur);
                    }
                    if (plateau.get((i+1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i+1,j,couleur);
                    }
                }
                if (plateau.get(i*hauteur+j+1).equals("Libre") || plateau.get((i+1)*hauteur+j).equals("Libre") ||
                    plateau.get(i*hauteur+j+1).equals("Non Pris") || plateau.get((i+1)*hauteur+j).equals("Non Pris")) {
                  plateau.set(0, "Non pris");
                  if (plateau.get(i*hauteur+j+1).equals("En attente")){
                    verifierPriseAux(plateau,i,j+1,couleur);
                }
                  if (plateau.get((i+1)*hauteur+j).equals("En attente")){
                    verifierPriseAux(plateau,i+1,j,couleur);
                }
            }
        }
         // On verifie la prise aux coins (2eme coin)
          else if (j==hauteur-1) {
                if ((!plateau.get(i*hauteur+j-1).equals("Libre") || !plateau.get(i*hauteur+j-1).equals("Non Pris"))&&
                        (!plateau.get((i+1)*hauteur+j).equals("Libre") || !plateau.get((i+1)*hauteur+j).equals("Non Pris"))){
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j-1).equals(couleur)){
                    verifierPriseAux(plateau,i,j-1,couleur);
                    }
                    if (plateau.get((i+1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i+1,j,couleur);
                    }
                }
                if (plateau.get(i*hauteur+j-1).equals("Libre") || plateau.get((i+1)*hauteur+j).equals("Libre") ||
                    plateau.get(i*hauteur+j-1).equals("Non Pris") || plateau.get((i+1)*hauteur+j).equals("Non Pris")) {
                  plateau.set(0, "Non pris");
                  if (plateau.get(i*hauteur+j-1).equals("En attente")){
                    verifierPriseAux(plateau,i,j-1,couleur);
                }
                  if (plateau.get((i+1)*hauteur+j).equals("En attente")){
                    verifierPriseAux(plateau,i+1,j,couleur);
                }
            }
        } else {
              if ((!plateau.get(i*hauteur+j-1).equals("Libre") || !plateau.get(i*hauteur+j-1).equals("Non Pris"))&&
                 (!plateau.get((i+1)*hauteur+j).equals("Libre") || !plateau.get((i+1)*hauteur+j).equals("Non Pris"))&&
                 (!plateau.get(i*hauteur+j+1).equals("Libre") || !plateau.get(i*hauteur+j+1).equals("Non Pris"))) {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j-1).equals(couleur)){
                    verifierPriseAux(plateau,i,j-1,couleur);
                    }
                    if (plateau.get((i+1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i+1,j,couleur);
                    }
                    if (plateau.get(i*hauteur+j+1).equals(couleur)){
                    verifierPriseAux(plateau,i,j+1,couleur);
                  }
              }
                if (plateau.get(i*hauteur+j-1).equals("Libre") || plateau.get((i+1)*hauteur+j).equals("Libre") ||
                    plateau.get(i*hauteur+j-1).equals("Non Pris") || plateau.get((i+1)*hauteur+j).equals("Non Pris") ||
                    plateau.get(i*hauteur+j+1).equals("Libre") || plateau.get(i*hauteur+j+1).equals("Non Pris")) {
                  plateau.set(0, "Non pris");
                  if (plateau.get(i*hauteur+j-1).equals("En attente")){
                    verifierPriseAux(plateau,i,j-1,couleur);
                }
                  if (plateau.get((i+1)*hauteur+j).equals("En attente")){
                    verifierPriseAux(plateau,i+1,j,couleur);
                }
                  if (plateau.get(i*hauteur+j+1).equals("En attente")){
                    verifierPriseAux(plateau,i,j+1,couleur);
                }
          }
    }}
    if (i==hauteur-1) {
        // On verifie la prise aux coins (3eme coin)
            if (j==0) {
                if ((!plateau.get(i*hauteur+j+1).equals("Libre") || !plateau.get(i*hauteur+j+1).equals("Non Pris"))&&
                    (!plateau.get((i-1)*hauteur+j).equals("Libre") || !plateau.get((i-1)*hauteur+j).equals("Non Pris"))){
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j+1).equals(couleur)){
                    verifierPriseAux(plateau,i,j+1,couleur);
                    }
                    if (plateau.get((i-1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i-1,j,couleur);
                    }
                }
                if (plateau.get(i*hauteur+j+1).equals("Libre") || plateau.get((i-1)*hauteur+j).equals("Libre") ||
                    plateau.get(i*hauteur+j+1).equals("Non Pris") || plateau.get((i-1)*hauteur+j).equals("Non Pris")) {
                  plateau.set(0, "Non pris");
                  if (plateau.get(i*hauteur+j+1).equals("En attente")){
                    verifierPriseAux(plateau,i,j+1,couleur);
                }
                  if (plateau.get((i-1)*hauteur+j).equals("En attente")){
                    verifierPriseAux(plateau,i-1,j,couleur);
                }
            }
        }
        // On verifie la prise aux coins (4eme coin)
            else if (j==hauteur-1) {
                if ((!plateau.get(i*hauteur+j-1).equals("Libre") || !plateau.get(i*hauteur+j-1).equals("Non Pris"))&&
                   (!plateau.get((i-1)*hauteur+j).equals("Libre") || !plateau.get((i-1)*hauteur+j).equals("Non Pris"))){
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j-1).equals(couleur)){
                    verifierPriseAux(plateau,i,j-1,couleur);
                    }
                    if (plateau.get((i-1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i-1,j,couleur);
                    }
                }
                if (plateau.get(i*hauteur+j-1).equals("Libre") || plateau.get((i-1)*hauteur+j).equals("Libre") ||
                    plateau.get(i*hauteur+j-1).equals("Non Pris") || plateau.get((i-1)*hauteur+j).equals("Non Pris")) {
                  plateau.set(0, "Non pris");
                  if (plateau.get(i*hauteur+j-1).equals("En attente")){
                    verifierPriseAux(plateau,i,j-1,couleur);
                }
                  if (plateau.get((i-1)*hauteur+j).equals("En attente")){
                    verifierPriseAux(plateau,i-1,j,couleur);
                }
            }
        } else {
                if ((!plateau.get(i*hauteur+j-1).equals("Libre") || !plateau.get(i*hauteur+j-1).equals("Non Pris"))&&
                   (!plateau.get((i-1)*hauteur+j).equals("Libre") || !plateau.get((i-1)*hauteur+j).equals("Non Pris"))&&
                   (!plateau.get(i*hauteur+j+1).equals("Libre") || !plateau.get(i*hauteur+j+1).equals("Non Pris")))    {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j-1).equals(couleur)){
                    verifierPriseAux(plateau,i,j-1,couleur);
                    }
                    if (plateau.get((i-1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i-1,j,couleur);
                    }
                    if (plateau.get(i*hauteur+j+1).equals(couleur)){
                    verifierPriseAux(plateau,i,j+1,couleur);
                    }
                }
                if (plateau.get(i*hauteur+j-1).equals("Libre") || plateau.get((i-1)*hauteur+j).equals("Libre") ||
                    plateau.get(i*hauteur+j-1).equals("Non Pris") || plateau.get((i-1)*hauteur+j).equals("Non Pris") ||
                    plateau.get(i*hauteur+j+1).equals("Libre") || plateau.get(i*hauteur+j+1).equals("Non Pris")) {
                  plateau.set(0, "Non pris");
                  if (plateau.get(i*hauteur+j-1).equals("En attente")){
                    verifierPriseAux(plateau,i,j-1,couleur);
                }
                  if (plateau.get((i-1)*hauteur+j).equals("En attente")){
                    verifierPriseAux(plateau,i-1,j,couleur);
                }
                  if (plateau.get(i*hauteur+j+1).equals("En attente")){
                    verifierPriseAux(plateau,i,j+1,couleur);
                }
            }
            }
    }
   else if (j==0) {
                if ((!plateau.get(i*hauteur+j+1).equals("Libre") || !plateau.get(i*hauteur+j+1).equals("Non Pris"))&&
                    (!plateau.get((i+1)*hauteur+j).equals("Libre") || !plateau.get((i+1)*hauteur+j).equals("Non Pris")) &&
                    (!plateau.get((i-1)*hauteur+j).equals("Libre") || !plateau.get((i-1)*hauteur+j).equals("Non Pris")))    {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j+1).equals(couleur)){
                    verifierPriseAux(plateau,i,j+1,couleur);
                    }
                    if (plateau.get((i+1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i+1,j,couleur);
                    }
                    if (plateau.get((i-1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i-1,j,couleur);
                    }
                }
                if (plateau.get(i*hauteur+j+1).equals("Libre") || plateau.get((i+1)*hauteur+j).equals("Libre") ||
                    plateau.get(i*hauteur+j+1).equals("Non Pris") || plateau.get((i+1)*hauteur+j).equals("Non Pris") ||
                    plateau.get((i-1)*hauteur+j+1).equals("Non Pris") || plateau.get((i-1)*hauteur+j).equals("Libre")) {
                  plateau.set(0, "Non pris");
                  if (plateau.get(i*hauteur+j+1).equals("En attente")){
                    verifierPriseAux(plateau,i,j+1,couleur);
                }
                  if (plateau.get((i+1)*hauteur+j).equals("En attente")){
                    verifierPriseAux(plateau,i+1,j,couleur);
                }
                  if (plateau.get((i-1)*hauteur+j).equals("En attente")){
                    verifierPriseAux(plateau,i-1,j,couleur);
                }
            }
        }
   else if (j==hauteur-1) {
                if ((!plateau.get(i*hauteur+j-1).equals("Libre") || !plateau.get(i*hauteur+j-1).equals("Non Pris"))&&
                    (!plateau.get((i+1)*hauteur+j).equals("Libre") || !plateau.get((i+1)*hauteur+j).equals("Non Pris"))&&
                    (!plateau.get((i-1)*hauteur+j).equals("Libre") || !plateau.get((i-1)*hauteur+j).equals("Non Pris"))) {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j-1).equals(couleur)){
                    verifierPriseAux(plateau,i,j-1,couleur);
                    }
                    if (plateau.get((i+1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i+1,j,couleur);
                    }
                     if (plateau.get((i-1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i-1,j,couleur);
                    }
                }
                if (plateau.get(i*hauteur+j-1).equals("Libre") || plateau.get((i+1)*hauteur+j).equals("Libre") ||
                    plateau.get(i*hauteur+j-1).equals("Non Pris") || plateau.get((i+1)*hauteur+j).equals("Non Pris") ||
                    plateau.get((i-1)*hauteur+j).equals("Libre") || plateau.get((i-1)*hauteur+j).equals("Non Pris")) {
                  plateau.set(0, "Non pris");
                  if (plateau.get(i*hauteur+j-1).equals("En attente")){
                    verifierPriseAux(plateau,i,j-1,couleur);
                }
                  if (plateau.get((i+1)*hauteur+j).equals("En attente")){
                    verifierPriseAux(plateau,i+1,j,couleur);
                }
                   if (plateau.get((i-1)*hauteur+j).equals("En attente")){
                    verifierPriseAux(plateau,i-1,j,couleur);
                }
            }
        }
           // On verifie la prise au centre du plateau
 else {
       if ((!plateau.get(i*hauteur+j-1).equals("Libre") || !plateau.get(i*hauteur+j-1).equals("Non Pris"))&&
           (!plateau.get((i+1)*hauteur+j).equals("Libre") || !plateau.get((i+1)*hauteur+j).equals("Non Pris"))&&
           (!plateau.get((i-1)*hauteur+j).equals("Libre") || !plateau.get((i-1)*hauteur+j).equals("Non Pris"))&&
           (!plateau.get(i*hauteur+j+1).equals("Libre") || !plateau.get(i*hauteur+j+1).equals("Non Pris"))) {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j-1).equals(couleur)){
                    verifierPriseAux(plateau,i,j-1,couleur);
                    }
                    if (plateau.get((i+1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i+1,j,couleur);
                    }
                    if (plateau.get((i-1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i-1,j,couleur);
                    }
                    if (plateau.get(i*hauteur+j+1).equals(couleur)){
                    verifierPriseAux(plateau,i,j+1,couleur);
                    }
                }
       if (plateau.get(i*hauteur+j-1).equals("Libre") || plateau.get((i+1)*hauteur+j).equals("Libre") ||
           plateau.get(i*hauteur+j-1).equals("Non Pris") || plateau.get((i+1)*hauteur+j).equals("Non Pris") ||
           plateau.get((i-1)*hauteur+j).equals("Libre") || plateau.get((i-1)*hauteur+j).equals("Non Pris") ||
           plateau.get(i*hauteur+j+1).equals("Libre") || plateau.get(i*hauteur+j+1).equals("Non Pris")) {
                  plateau.set(0, "Non pris");
                  if (plateau.get(i*hauteur+j-1).equals("En attente")){
                    verifierPriseAux(plateau,i,j-1,couleur);
                }
                  if (plateau.get((i+1)*hauteur+j).equals("En attente")){
                    verifierPriseAux(plateau,i+1,j,couleur);
                }
                  if (plateau.get((i-1)*hauteur+j).equals("En attente")){
                    verifierPriseAux(plateau,i-1,j,couleur);
                }
                  if (plateau.get(i*hauteur+j+1).equals("En attente")){
                    verifierPriseAux(plateau,i,j+1,couleur);
                }
            }
   }
}    

    /**
     * Verifie si un groupe de pions de couleur couleur est pris
     * @param plateau
     * @param i
     * @param j
     * @param couleur
     */
    public void verifierPrise(ArrayList<String> plateau, int i, int j, String couleur) {
     this.verifierPriseAux(plateau, i, j, couleur);
     for (int k=0; k<plateau.size(); k++) {
         if (plateau.get(k)=="En attente") {
             plateau.set(k, "Libre");
         }
         if (plateau.get(k)=="Non Pris") {
             plateau.set(k, couleur);
         }
     }
 }
    
    }    

