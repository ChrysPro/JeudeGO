/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

/**
 *
 * @author ybellehigue, nbrandt, gguillart, cprocopi
 */
public class JeudeGo {

    /**
     *Taille du plateau
     */
    public static final int TAILLE=8;
    
    private JeudeGo() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlateauJeu plateau = new PlateauJeu(TAILLE);
        plateau.partie();
    }
}
