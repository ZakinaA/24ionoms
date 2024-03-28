/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Caserne;
import model.Grade;

/**
 *
 * @author ts1sio
 */
public class DaoGrade {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Grade> getLesGrades(Connection cnx){
        
        ArrayList<Grade> grades = new ArrayList<Grade>();
        try{
            requeteSql = cnx.prepareStatement("select * from grade");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Grade g = new Grade();
                    g.setId(resultatRequete.getInt("id"));
                    g.setLibelle(resultatRequete.getString("libelle"));
                    g.setLibelle(resultatRequete.getString("libelle"));

                grades.add(g);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return grades;
    }
}
