/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import database.ConnexionBdd;
import database.DaoCaserne;
import model.Caserne;
import java.sql.Connection;

/**
 *
 * @author zakina
 */
public class TestDaoCaserne {
    
      public static void main (String args[]){
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        for(Caserne c : DaoCaserne.getLesCasernes(cnx)){
            
            System.out.println("----------"
            + "\nID : " + c.getId()
            + "\nNom : " + c.getNom()
            + "\nRue : " + c.getRue()
            + "\nCoPos : " + c.getCopos()
            + "\nVille : " + c.getVille());
                    
        }
    }
}