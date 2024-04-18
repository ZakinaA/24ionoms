/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import static database.DaoPompier.requeteSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Fonction;

/**
 *
 * @author ts1sio
 */
public class DaoFonction {
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Fonction> listerFonctions(Connection cnx){
        
        ArrayList<Fonction> lesFonctions = new ArrayList<Fonction>();
        try{
            if(requeteSql == null) requeteSql = cnx.prepareStatement("select * from fonction");
            resultatRequete = requeteSql.executeQuery();
            System.out.println(resultatRequete);
            
            while (resultatRequete.next()){
                
                Fonction f = new Fonction();
                    f.setId(resultatRequete.getInt("id"));
                    f.setLibelle(resultatRequete.getString("libelle"));

                lesFonctions.add(f);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return lesFonctions;
    }
    
    public static Fonction getFonctionById(Connection cnx, int idFonction){
        
        Fonction f = null ;
        try{
            if(requeteSql == null) requeteSql = cnx.prepareStatement("select fonction.id as f_id, fonction.libelle as f_libelle,  " +
                         " from fonction" +
                         " where fonction.id= ? ");
            System.out.println(requeteSql);
            requeteSql.setInt(1, idFonction);
            resultatRequete = requeteSql.executeQuery();
            
            if (resultatRequete.next()){
                
                    f = new Fonction();
                    f.setId(resultatRequete.getInt("p_id"));
                    f.setLibelle(resultatRequete.getString("p_nom")); 
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getPompierById  a généré une erreur");
        }
        return f ;
    }
    
    public static Fonction addFonction(Connection cnx, Fonction f){
        int idGenere = -1;
        try{
            requeteSql = cnx.prepareStatement("INSERT INTO fonction ( libelle ) VALUES (?)", requeteSql.RETURN_GENERATED_KEYS );
            requeteSql.setString(1, f.getLibelle());
            System.out.println(f.getLibelle());
            requeteSql.executeUpdate();
            System.out.println(requeteSql);
            resultatRequete = requeteSql.getGeneratedKeys();
            
            /*while ( resultatRequete.next() ) {
                idGenere = resultatRequete.getInt( 1 );
                f.setId(idGenere);
                
                f = DaoFonction.getFonctionById(cnx, f.getId());
            }*/
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return f;
    }
}
