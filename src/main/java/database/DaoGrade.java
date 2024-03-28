/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import static database.DaoPompier.requeteSql;
import static database.DaoPompier.resultatRequete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Caserne;
import model.Grade;
import model.Pompier;
import model.SurGrade;

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
            if(requeteSql == null) requeteSql = cnx.prepareStatement("select grade.id as g_id, grade.libelle as g_libelle, sg.id as sg_id, sg.libelle as sg_libelle " +
                         " from grade inner join surgrade sg " +
                         " on grade.surgrade_id = sg.id");
            
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                Grade g = new Grade();
                g.setId(resultatRequete.getInt("g_id"));
                g.setLibelle(resultatRequete.getString("g_libelle"));
                g.setSurGrade(new SurGrade(resultatRequete.getInt("sg_id"), resultatRequete.getString("sg_libelle")));
                
                grades.add(g);
            }
           
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesGrades a généré une erreur");
        }
        return grades;
    }
    
    public static Grade getGrade(Connection cnx, int id){
        
        Grade g = null;
        try{
            if(requeteSql == null) requeteSql = cnx.prepareStatement("select grade.id as g_id, grade.libelle as g_libelle, sg.id as sg_id, sg.libelle as sg_libelle " +
                         " from grade inner join surgrade sg " +
                         " on grade.surgrade_id = sg.id "+
                         " where grade.id= ? ");
            
            requeteSql.setInt(1, id);
            resultatRequete = requeteSql.executeQuery();
            
            if(resultatRequete.next()){
                g = new Grade();
                g.setId(resultatRequete.getInt("g_id"));
                g.setLibelle(resultatRequete.getString("g_libelle"));
                
                SurGrade sg = new SurGrade();
                sg.setId(resultatRequete.getInt("sg_id"));
                sg.setLibelle(resultatRequete.getString("sg_libelle"));
                g.setSurGrade(sg);
                
                return g;
            }
            
            System.out.println("Aucun Grade trouvé avec l'Id : " + id);
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getGrade a généré une erreur");
        }
        
        return g;
    }
}
