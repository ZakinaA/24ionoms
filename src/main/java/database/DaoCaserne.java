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

public class DaoCaserne {

    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Caserne> getLesCasernes(Connection cnx){
        
        ArrayList<Caserne> lesCasernes= new ArrayList<Caserne>();
        try{
            if(requeteSql == null) requeteSql = cnx.prepareStatement("select caserne.id as c_id, caserne.nom as c_nom, caserne.rue as c_rue, caserne.copos as c_copos, caserne.ville as c_ville " +
                         "from caserne " +
                         "where caserne.id=1");
            
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                Caserne c = new Caserne();
                c.setId(resultatRequete.getInt("c_id"));
                c.setNom(resultatRequete.getString("c_nom"));
                c.setRue(resultatRequete.getString("c_rue"));
                c.setCopos(resultatRequete.getInt("c_copos"));
                c.setVille(resultatRequete.getString("c_ville"));

                lesCasernes.add(c);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesCasernes e généré une erreur");
        }
        return lesCasernes;
    }
    
    public static Caserne getCaserneById(Connection cnx, int c_id) {
        
        Caserne uneCaserne = new Caserne();
        try{
            if(requeteSql == null) requeteSql = cnx.prepareStatement("select caserne.Cas_id as c_id, caserne.Cas_Nom as c_nom " +
                         "from caserne " +
                         "where caserne.Cas_id=1");
            
            requeteSql.setInt(1, c_id);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Caserne c = new Caserne();
                c.setId(resultatRequete.getInt("c_id"));
                c.setNom(resultatRequete.getString("c_nom"));
                
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getCaserneById a généré une erreur");
        }
        return uneCaserne;
    }
}
