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
      plateau.setposition(5, 0, "Blanc");
      plateau.afficher();
      plateau.setposition(3, 0, "Noir");
      plateau.afficher();
      plateau.setposition(4, 5, "Blanc");
      plateau.afficher();
    }
}
