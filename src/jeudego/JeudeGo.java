/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

/**
 *
 * @author nbrandt
 */
public class JeudeGo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      PlateauJeu plateau= new PlateauJeu(8);
      plateau.setposition(1, 0, "Blanc");
      plateau.afficher();
      plateau.setposition(0, 0, "Noir");
      plateau.afficher();
      plateau.setposition(0, 1, "Blanc");
      plateau.afficher();
      plateau.setposition(1, 1, "Noir");
      plateau.afficher();
      plateau.setposition(2, 1, "Noir");
      plateau.afficher();
      plateau.setposition(2, 0, "Blanc");
      plateau.afficher();
      plateau.setposition(3, 1, "Blanc");
      plateau.afficher();
      plateau.setposition(2, 2, "Blanc");
      plateau.afficher();
      plateau.setposition(1, 2, "Blanc");
      plateau.afficher();
    }
}
