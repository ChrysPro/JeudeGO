/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas
 */
public class PlateauJeuTest {
    
    public PlateauJeuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getHauteur method, of class PlateauJeu.
     */
    @Test
    public void testGetHauteur() {
        System.out.println("getHauteur");
        PlateauJeu instance = new PlateauJeu(3);
        int result = instance.getHauteur();
        assertEquals(3, result);
    }

    /**
     * Test of setHauteur method, of class PlateauJeu.
     */
    @Test
    public void testSetHauteur() {
        System.out.println("setHauteur");
        int hauteur = 6;
        PlateauJeu instance = new PlateauJeu(0);
        instance.setHauteur(6);
        int value = instance.getHauteur();
        Assert.assertTrue("Error", value==hauteur);
    }

    /**
     * Test of getPlateau method, of class PlateauJeu.
     */
    @Test
    public void testGetPlateau() {
        System.out.println("getPlateau");
        PlateauJeu instance = new PlateauJeu(5);
        ArrayList<String> expResult = new ArrayList<String>();
        for (int i = 0; i < (5 * 5); i++) {
            expResult.add("Libre");
        }
        ArrayList<String> result = instance.getPlateau();
        assertEquals(expResult, result);
    }

    /**
     * Test of setposition method, of class PlateauJeu.
     */
    @Test
    public void testSetposition() {
        System.out.println("setposition");
        int i = 0;
        int j = 0;
        String couleur = "";
        PlateauJeu instance = new PlateauJeu(10);
        ArrayList<String> expResult= new ArrayList<String>();
        for (int k = 0; k < (10 * 10); k++) {
            expResult.add("Libre");
        }
        instance.setposition(0, 0, "Blanc");
        expResult.set(0, "Blanc");
        assertEquals(expResult,instance.getPlateau());
        instance.setposition(1, 0, "Noir ");
        instance.setposition(0, 1, "Noir ");
        expResult.set(0, "Pris");
        expResult.set(1, "Noir ");
        expResult.set(10, "Noir ");
        assertEquals(expResult,instance.getPlateau());
        instance.setposition(2, 0, "Blanc");
        instance.setposition(1, 1, "Blanc");
        instance.setposition(0, 2, "Blanc");
        instance.setposition(0, 0, "Blanc");
        expResult.set(0, "Blanc");
        expResult.set(1, "Pris");
        expResult.set(10, "Pris");
        expResult.set(2, "Blanc");
        expResult.set(11, "Blanc");
        expResult.set(20, "Blanc");
        assertEquals(expResult,instance.getPlateau());
        instance.setposition(9, 9, "Blanc");
        expResult.set(99, "Blanc");
        assertEquals(expResult,instance.getPlateau());
        instance.setposition(8, 9, "Noir ");
        instance.setposition(9, 8, "Noir ");
        expResult.set(99, "Pris");
        expResult.set(98, "Noir ");
        expResult.set(89, "Noir ");
        assertEquals(expResult,instance.getPlateau());
        instance.setposition(7, 9, "Blanc");
        instance.setposition(8, 8, "Blanc");
        instance.setposition(9, 7, "Blanc");
        instance.setposition(9, 9, "Blanc");
        expResult.set(99, "Blanc");
        expResult.set(98, "Pris");
        expResult.set(89, "Pris");
        expResult.set(97, "Blanc");
        expResult.set(88, "Blanc");
        expResult.set(79, "Blanc");
        assertEquals(expResult,instance.getPlateau());
        instance.setposition(0, 9, "Blanc");
        expResult.set(9, "Blanc");
        assertEquals(expResult,instance.getPlateau());
        instance.setposition(0, 8, "Noir ");
        instance.setposition(1, 9, "Noir ");
        expResult.set(9, "Pris");
        expResult.set(8, "Noir ");
        expResult.set(19, "Noir ");
        assertEquals(expResult,instance.getPlateau());
        instance.setposition(9, 0, "Blanc");
        expResult.set(90, "Blanc");
        assertEquals(expResult,instance.getPlateau());
        instance.setposition(8, 0, "Noir ");
        instance.setposition(9, 1, "Noir ");
        expResult.set(90, "Pris");
        expResult.set(80, "Noir ");
        expResult.set(91, "Noir ");
        assertEquals(expResult,instance.getPlateau());
        instance.setposition(5, 5, "Blanc");
        expResult.set(55, "Blanc");
        assertEquals(expResult,instance.getPlateau());
        instance.setposition(5, 4, "Noir ");
        instance.setposition(5, 6, "Noir ");
        instance.setposition(4, 5, "Noir ");
        instance.setposition(6, 5, "Noir ");
        expResult.set(55, "Pris");
        expResult.set(54, "Noir ");
        expResult.set(56, "Noir ");
        expResult.set(65, "Noir ");
        expResult.set(45, "Noir ");
        assertEquals(expResult,instance.getPlateau());
        
    }

    /**
     * Test of placeLibre method, of class PlateauJeu.
     */
    @Test
    public void testPlaceLibre() {
        System.out.println("placeLibre");
        int i = 0;
        int j = 0;
        PlateauJeu instance = new PlateauJeu(1);
        boolean expResult = true;
        boolean result = instance.placeLibre(i, j);
        assertEquals(expResult, result);
        expResult=false;
        i=1;
        result = instance.placeLibre(i, j);
        assertEquals(expResult, result);
        i=0;
        instance.setposition(0, 0, "Blanc");
        result = instance.placeLibre(i, j);
        assertEquals(expResult, result);
        j=1;
        instance.setposition(0, 0, "Libre");
        result = instance.placeLibre(i, j);
        assertEquals(expResult, result);
    }

    /**
     * Test of verifierPriseAux method, of class PlateauJeu.
     
    @Test
    public void testVerifierPriseAux() {
        System.out.println("verifierPriseAux");
        ArrayList<String> plateau = null;
        int i = 0;
        int j = 0;
        String couleur = "";
        PlateauJeu instance = null;
        instance.verifierPriseAux(plateau, i, j, couleur);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of verifierPrise method, of class PlateauJeu
     * Ce test est aussi vérifié par le test Setposition
     
    @Test
    public void testVerifierPrise() {
        System.out.println("verifierPrise");
        ArrayList<String> plateau = null;
        int i = 0;
        int j = 0;
        String couleur = "";
        PlateauJeu instance = null;
        instance.verifierPrise(plateau, i, j, couleur);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    /**
     * Test of afficher method, of class PlateauJeu.
     
    @Test
    public void testAfficher() {
        System.out.println("afficher");
        PlateauJeu instance = null;
        instance.afficher();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of clear method, of class PlateauJeu.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        PlateauJeu instance = new PlateauJeu(2);
        ArrayList<String> expResult= new ArrayList<String>();
        instance.setposition(0, 0, "Pris");
        instance.setposition(1, 1, "Pris");
        instance.clear();
        for (int k = 0; k < (2 * 2); k++) {
            expResult.add("Libre");
        }
       ArrayList<String> result=instance.getPlateau();
      assertEquals(expResult, result);
    }

    /**
     * Test of partie method, of class PlateauJeu.
     Nous ne savons pas comment tester cette methode (l'utilisateur doit intervenir)
    @Test
    public void testPartie() {
        System.out.println("partie");
        PlateauJeu instance = null;
        instance.partie();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
 */   
}
