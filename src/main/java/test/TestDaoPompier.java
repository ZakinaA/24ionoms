/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import database.ConnexionBdd;
import database.DaoPompier;
import java.sql.Connection;

/**
 *
 * @author zakina
 */
public class TestDaoPompier {
    
    public static void main (String args[]){
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        System.out.println ("nombre de pomipiers=" + DaoPompier.getLesPompiers(cnx).size());
        
        System.out.println ("Le pompier 1 s'appelle =" + DaoPompier.getPompierById(cnx,1).getNom());
        
    }
    
}
