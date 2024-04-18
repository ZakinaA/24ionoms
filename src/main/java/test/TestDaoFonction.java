/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import database.ConnexionBdd;
import database.DaoCaserne;
import database.DaoFonction;
import java.sql.Connection;
import model.Fonction;

/**
 *
 * @author zakina
 */
public class TestDaoFonction {
    
      public static void main (String args[]){
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        System.out.println ("nombre de fonctions = " + DaoFonction.listerFonctions(cnx).size());
        
        Fonction f = new Fonction();
        f.setLibelle("CHAUVEL");
           
        DaoFonction.addFonction(cnx,f);
    }
    
}
