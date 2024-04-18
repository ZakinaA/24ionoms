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
                         "from caserne ");
                         // "where caserne.id=1");
            
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
    
    public static Caserne getCaserneById(Connection cnx, int id) {
        
        Caserne uneCaserne = new Caserne();
        try{
            requeteSql = cnx.prepareStatement("select caserne.id as c_id, caserne.nom as c_nom, caserne.rue as c_rue, caserne.copos as c_copos, caserne.ville as c_ville " +
                         " from caserne " +
                         " where caserne.id= ? ");
            
            requeteSql.setInt(1, id);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                Caserne c = new Caserne();
                c.setId(resultatRequete.getInt("c_id"));
                c.setNom(resultatRequete.getString("c_nom"));
                c.setRue(resultatRequete.getString("c_rue"));
                c.setCopos(resultatRequete.getInt("c_copos"));
                c.setVille(resultatRequete.getString("c_ville"));
                
                return c;
            }
        
        System.out.println("Aucune caserne trouvé avec l'Id : " + id);
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getCaseneById a généré une erreur");
        }
        
        return uneCaserne;
    }
    
    public static Caserne addCaserne(Connection connection, Caserne c){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requeteSql=connection.prepareStatement("INSERT INTO caserne ( nom, rue, copos, ville)\n" +
                    "VALUES (?,?,?,?)", requeteSql.RETURN_GENERATED_KEYS );
            requeteSql.setString(1, c.getNom());
            requeteSql.setString(2, c.getRue());
            requeteSql.setInt(3, c.getCopos());
            requeteSql.setString(4, c.getVille());

           /* Exécution de la requête */
            requeteSql.executeUpdate();
            
             // Récupération de id auto-généré par la bdd dans la table client
            resultatRequete = requeteSql.getGeneratedKeys();
            while ( resultatRequete.next() ) {
                idGenere = resultatRequete.getInt( 1 );
                c.setId(idGenere);
                
                c = DaoCaserne.getCaserneById(connection, c.getId());
            }
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return c ;    
    }
}
