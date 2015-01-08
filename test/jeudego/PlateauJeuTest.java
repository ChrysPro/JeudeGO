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
        instance.setposition(0, 0, "Blanc");
        ArrayList<String> expResult= new ArrayList<String>();
        for (int k = 0; k < (10 * 10); k++) {
            expResult.add("Libre");
        }
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
    }

    /**
     * Test of placeLibre method, of class PlateauJeu.
     */
    @Test
    public void testPlaceLibre() {
        System.out.println("placeLibre");
        int i = 0;
        int j = 0;
        PlateauJeu instance = null;
        boolean expResult = false;
        boolean result = instance.placeLibre(i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifierPriseAux method, of class PlateauJeu.
     */
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

    /**
     * Test of verifierPrise method, of class PlateauJeu.
     */
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

    /**
     * Test of afficher method, of class PlateauJeu.
     */
    @Test
    public void testAfficher() {
        System.out.println("afficher");
        PlateauJeu instance = null;
        instance.afficher();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class PlateauJeu.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        PlateauJeu instance = null;
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of partie method, of class PlateauJeu.
     */
    @Test
    public void testPartie() {
        System.out.println("partie");
        PlateauJeu instance = null;
        instance.partie();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
