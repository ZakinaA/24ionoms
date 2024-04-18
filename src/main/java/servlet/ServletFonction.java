/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import static javax.swing.JOptionPane.showMessageDialog;
import database.DaoFonction;
import database.DaoVehicules;
import database.DaoCaserne;
import database.DaoPompier;
import form.FormPompier;
import form.FormFonction;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Caserne;
import model.Pompier;
import model.Fonction;

/**
 *
 * @author zakina
 */
public class ServletFonction extends HttpServlet {

     Connection cnx ;
            
    @Override
    public void init()
    {     
        ServletContext servletContext=getServletContext();
        cnx = (Connection)servletContext.getAttribute("connection");
    }

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String url = request.getRequestURI().toLowerCase();
        String[] args = url.split("/");
        
        // Pages Fonctions
        switch (args[3]) {
            
            //Pages Fonctions
            case "listerfonction":
                ArrayList lesFonctions = DaoFonction.listerFonctions(cnx);
                request.setAttribute("LesFonctions", lesFonctions);
                getServletContext().getRequestDispatcher("/vues/Fonction/listerFonction.jsp").forward(request, response);
                break;
                
            case "ajouterfonction":
                getServletContext().getRequestDispatcher("/vues/Fonction/ajouterFonction.jsp").forward(request, response);
                break;
                
            default:
                System.out.println("Page web non trouvé : " + url);
                throw new AssertionError();
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         FormFonction form = new FormFonction();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Fonction f = form.ajouterFonction(request);
        
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "fFonction", f );
		
        if (form.getErreurs().isEmpty()){
            Fonction FonctionInsere =  DaoFonction.addFonction(cnx, f);
            if (FonctionInsere != null ){
                request.setAttribute( "fFonction", FonctionInsere );
                ArrayList lesFonctions = DaoFonction.listerFonctions(cnx);
                System.out.println("NB FONCTIN="+ lesFonctions.size());
                request.setAttribute("LesFonctions", lesFonctions);
                this.getServletContext().getRequestDispatcher("/vues/Fonction/listerFonction.jsp" ).forward( request, response );
            }
            else 
            {
                // Cas oùl'insertion en bdd a échoué
                //renvoyer vers une page d'erreur 
            }
           
        }
        else
        { 
            // il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs
            // ArrayList<Caserne> lesCasernes = DaoCaserne.getLesCasernes(cnx);
            // request.setAttribute("pLesCasernes", lesCasernes);
            // this.getServletContext().getRequestDispatcher("/vues/pompier/ajouterPompier.jsp" ).forward( request, response );
        }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    }
}
