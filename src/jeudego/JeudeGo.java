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
        int k=8;
      PlateauJeu plateau= new PlateauJeu(k);
     plateau.partie();
    }
}
