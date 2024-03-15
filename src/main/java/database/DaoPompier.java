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
import model.Pompier;

/**
 *
 * @author zakina
 */
public class DaoPompier {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Pompier> getLesPompiers(Connection cnx){
        
        ArrayList<Pompier> lesPompiers = new ArrayList<Pompier>();
        try{
            requeteSql = cnx.prepareStatement("select pompier.id as p_id, pompier.nom as p_nom, pompier.prenom as p_prenom, c.id as c_id, c.nom as c_nom " +
                         " from pompier inner join caserne c " +
                         " on pompier.caserne_id = c.id ");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Pompier p = new Pompier();
                    p.setId(resultatRequete.getInt("p_id"));
                    p.setNom(resultatRequete.getString("p_nom"));
                    p.setPrenom(resultatRequete.getString("p_prenom"));
                Caserne c = new Caserne();
                    c.setId(resultatRequete.getInt("c_id"));
                    c.setNom(resultatRequete.getString("c_nom"));
                
                p.setUneCaserne(c);
                
                lesPompiers.add(p);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return lesPompiers;
    }
    
}
