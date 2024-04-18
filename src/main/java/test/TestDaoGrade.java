/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import database.ConnexionBdd;
import database.DaoGrade;
import database.DaoPompier;
import java.sql.Connection;
import model.Caserne;
import model.Grade;
import model.Pompier;
import model.SurGrade;

/**
 *
 * @author zakina
 */
public class TestDaoGrade {
    
    public static void main12 (String args[]){
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        System.out.println ("nombre de pomipiers=" + DaoPompier.getLesPompiers(cnx).size());
        
        System.out.println ("Le pompier 1 s'appelle =" + DaoPompier.getPompierById(cnx,1).getNom());
        
        Pompier p = new Pompier();
        p.setNom("CHAUVEL");
        p.setPrenom("Jules");
        p.setUneCaserne(new Caserne(1));
        
        p = DaoPompier.addPompier(cnx, p);
        System.out.println("le nouveau pompier a reçu l id = " + p.getId());
        
        
    }
    
    public static void main14 (String args[]){
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        for(Grade g : DaoGrade.getLesGrades(cnx)){
            SurGrade sg = g.getSurGrade();
            
            System.out.println("----------"
            + " \nID : " + g.getId()
            + "\nLibelle : " + g.getLibelle()
            + "\nSurGrade : "
            + "\n   ID : " + sg.getId()
            + "\n   Libelle : " + sg.getLibelle());
        }
    }
    
    public static void main (String args[]){
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        for(Grade g : DaoGrade.getLesGrades(cnx)){
            SurGrade sg = g.getSurGrade();
            
            System.out.println("----------"
            + " \nID : " + g.getId()
            + "\nLibelle : " + g.getLibelle()
            + "\nSurGrade : "
            + "\n   ID : " + sg.getId()
            + "\n   Libelle : " + sg.getLibelle());
        }
    }
}
