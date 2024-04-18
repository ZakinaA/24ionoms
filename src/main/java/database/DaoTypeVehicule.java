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
import model.TypeVehicule;
import model.Caserne;

/**
 *
 * @author ts1sio
 */
public class DaoTypeVehicule {
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<TypeVehicule> listerTypeVehicule(Connection cnx){
        
        ArrayList<TypeVehicule> lesTypeVehicule = new ArrayList<TypeVehicule>();
        try{
            if(requeteSql == null) requeteSql = cnx.prepareStatement("SELECT * FROM type_vehicule");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                TypeVehicule v = new TypeVehicule();
                v.setId(resultatRequete.getInt("id"));
                v.setNom(resultatRequete.getString("nom"));
                v.setCaracteristique(resultatRequete.getString("caracteristique"));

                lesTypeVehicule.add(v);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return lesTypeVehicule;
    }
}
