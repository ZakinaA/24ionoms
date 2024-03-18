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
    
    public static Pompier getPompierById(Connection cnx, int idPompier){
        
        Pompier p = null ;
        try{
            requeteSql = cnx.prepareStatement("select pompier.id as p_id, pompier.nom as p_nom, pompier.prenom as p_prenom, c.id as c_id, c.nom as c_nom " +
                         " from pompier inner join caserne c " +
                         " on pompier.caserne_id = c.id "+
                         " where pompier.id= ? ");
            requeteSql.setInt(1, idPompier);
            resultatRequete = requeteSql.executeQuery();
            
            if (resultatRequete.next()){
                
                    p = new Pompier();
                    p.setId(resultatRequete.getInt("p_id"));
                    p.setNom(resultatRequete.getString("p_nom"));
                    p.setPrenom(resultatRequete.getString("p_prenom"));
                Caserne c = new Caserne();
                    c.setId(resultatRequete.getInt("c_id"));
                    c.setNom(resultatRequete.getString("c_nom"));
                
                p.setUneCaserne(c);
                
                
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getPompierById  a généré une erreur");
        }
        return p ;
    }
    
    
    public static Pompier addPompier(Connection connection, Pompier p){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requeteSql=connection.prepareStatement("INSERT INTO pompier ( nom, prenom, caserne_id)\n" +
                    "VALUES (?,?,?)", requeteSql.RETURN_GENERATED_KEYS );
            requeteSql.setString(1, p.getNom());
            requeteSql.setString(2, p.getPrenom());
            requeteSql.setInt(3, p.getUneCaserne().getId());

           /* Exécution de la requête */
            requeteSql.executeUpdate();
            
             // Récupération de id auto-généré par la bdd dans la table client
            resultatRequete = requeteSql.getGeneratedKeys();
            while ( resultatRequete.next() ) {
                idGenere = resultatRequete.getInt( 1 );
                p.setId(idGenere);
                
                p = DaoPompier.getPompierById(connection, p.getId());
            }
            
         
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return p ;    
    }
    
}
