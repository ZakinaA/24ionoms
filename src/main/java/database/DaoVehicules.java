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
import model.Vehicules;
import model.Caserne;

/**
 *
 * @author ts1sio
 */
public class DaoVehicules {
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Vehicules> listerVehicules(Connection cnx){
        
        ArrayList<Vehicules> lesVehicules = new ArrayList<Vehicules>();
        try{
            if(requeteSql == null) requeteSql = cnx.prepareStatement("select * from fonction");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Vehicules v = new Vehicules();
                    v.setId(resultatRequete.getInt("id"));
                    v.setImmat(resultatRequete.getString("immat"));
                    v.setDateOrigin(resultatRequete.getDate("dateOrigin"));
                    v.setDateRevision(resultatRequete.getDate("dateRevision"));
                    
                Caserne c = new Caserne();
                    c.setId(resultatRequete.getInt("id"));
                    c.setNom(resultatRequete.getString("nom"));
                    
                v.setUneCaserne(c);
                lesVehicules.add(v);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return lesVehicules;
    }
}
