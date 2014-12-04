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

    public PlateauJeu(int hauteur) {
        this.hauteur = hauteur;
        for (int i=0; i<(hauteur*hauteur); i++){
            plateau.add("Libre");
        }          
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public ArrayList<String> getPlateau() {
        return plateau;
    }

    public void setPlateau(ArrayList<String> plateau) {
        this.plateau = plateau;
    }
    
    public void setposition(int i, int j, String couleur) {
        this.plateau.set(i*hauteur+j, couleur);
        // this.verifierPrise()
    }
    
    public boolean placeLibre (int i, int j) {
        if(i <= this.hauteur && j <= this.hauteur && this.plateau.get(i*hauteur+j).equals("Libre") && i>0 && j>0){
            return true;
        } else {
            return false;
        }
    }
    
    public void verifierPriseAux(ArrayList<String> plateau, int i, int j, String couleur) {
        if (i==0) {
            if (j==0) {
                if (!plateau.get(i*hauteur+j+1).equals("Libre") || !plateau.get(i*hauteur+j+1).equals("Non Pris")) {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j+1).equals(couleur)){
                    verifierPriseAux(plateau,i,j+1,couleur);
                    }
                }
                if (!plateau.get((i+1)*hauteur+j).equals("Libre") || !plateau.get((i+1)*hauteur+j).equals("Non Pris")) {
                    plateau.set(0, "En attente");
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
          else if (j==hauteur-1) {
                if (!plateau.get(i*hauteur+j-1).equals("Libre") || !plateau.get(i*hauteur+j-1).equals("Non Pris")) {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j-1).equals(couleur)){
                    verifierPriseAux(plateau,i,j-1,couleur);
                    }
                }
                if (!plateau.get((i+1)*hauteur+j).equals("Libre") || !plateau.get((i+1)*hauteur+j).equals("Non Pris")) {
                    plateau.set(0, "En attente");
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
              if (!plateau.get(i*hauteur+j-1).equals("Libre") || !plateau.get(i*hauteur+j-1).equals("Non Pris")) {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j-1).equals(couleur)){
                    verifierPriseAux(plateau,i,j-1,couleur);
                    }
                }
                if (!plateau.get((i+1)*hauteur+j).equals("Libre") || !plateau.get((i+1)*hauteur+j).equals("Non Pris")) {
                    plateau.set(0, "En attente");
                    if (plateau.get((i+1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i+1,j,couleur);
                    }
                }
                if (!plateau.get(i*hauteur+j+1).equals("Libre") || !plateau.get(i*hauteur+j+1).equals("Non Pris")) {
                    plateau.set(0, "En attente");
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
    }
    if (i==hauteur-1) {
            if (j==0) {
                if (!plateau.get(i*hauteur+j+1).equals("Libre") || !plateau.get(i*hauteur+j+1).equals("Non Pris")) {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j+1).equals(couleur)){
                    verifierPriseAux(plateau,i,j+1,couleur);
                    }
                }
                if (!plateau.get((i-1)*hauteur+j).equals("Libre") || !plateau.get((i-1)*hauteur+j).equals("Non Pris")) {
                    plateau.set(0, "En attente");
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
            else if (j==hauteur-1) {
                if (!plateau.get(i*hauteur+j-1).equals("Libre") || !plateau.get(i*hauteur+j-1).equals("Non Pris")) {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j-1).equals(couleur)){
                    verifierPriseAux(plateau,i,j-1,couleur);
                    }
                }
                if (!plateau.get((i-1)*hauteur+j).equals("Libre") || !plateau.get((i-1)*hauteur+j).equals("Non Pris")) {
                    plateau.set(0, "En attente");
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
                if (!plateau.get(i*hauteur+j-1).equals("Libre") || !plateau.get(i*hauteur+j-1).equals("Non Pris")) {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j-1).equals(couleur)){
                    verifierPriseAux(plateau,i,j-1,couleur);
                    }
                }
                if (!plateau.get((i-1)*hauteur+j).equals("Libre") || !plateau.get((i-1)*hauteur+j).equals("Non Pris")) {
                    plateau.set(0, "En attente");
                    if (plateau.get((i-1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i-1,j,couleur);
                    }
                }
                if (!plateau.get(i*hauteur+j+1).equals("Libre") || !plateau.get(i*hauteur+j+1).equals("Non Pris")) {
                    plateau.set(0, "En attente");
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
            }
            }
    }
   else if (j==0) {
                if (!plateau.get(i*hauteur+j+1).equals("Libre") || !plateau.get(i*hauteur+j+1).equals("Non Pris")) {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j+1).equals(couleur)){
                    verifierPriseAux(plateau,i,j+1,couleur);
                    }
                }
                if (!plateau.get((i+1)*hauteur+j).equals("Libre") || !plateau.get((i+1)*hauteur+j).equals("Non Pris")) {
                    plateau.set(0, "En attente");
                    if (plateau.get((i+1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i+1,j,couleur);
                    }
                if (!plateau.get((i-1)*hauteur+j).equals("Libre") || !plateau.get((i-1)*hauteur+j).equals("Non Pris")) {
                    plateau.set(0, "En attente");
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
        } }
           if (j==hauteur-1) {
                if (!plateau.get(i*hauteur+j-1).equals("Libre") || !plateau.get(i*hauteur+j-1).equals("Non Pris")) {
                    plateau.set(0, "En attente");
                    if (plateau.get(i*hauteur+j-1).equals(couleur)){
                    verifierPriseAux(plateau,i,j-1,couleur);
                    }
                }
                if (!plateau.get((i+1)*hauteur+j).equals("Libre") || !plateau.get((i+1)*hauteur+j).equals("Non Pris")) {
                    plateau.set(0, "En attente");
                    if (plateau.get((i+1)*hauteur+j).equals(couleur)){
                    verifierPriseAux(plateau,i+1,j,couleur);
                    }
                }
                if (!plateau.get((i-1)*hauteur+j).equals("Libre") || !plateau.get((i-1)*hauteur+j).equals("Non Pris")) {
                    plateau.set(0, "En attente");
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
}    
    
    
    }    
}
