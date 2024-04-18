/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import database.DaoFonction;
import database.DaoVehicules;
import database.DaoCaserne;
import database.DaoPompier;
import form.FormPompier;
import form.FormCaserne;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.ArrayList;
import model.Caserne;

/**
 *
 * @author Dan
 */
public class ServletCaserne extends HttpServlet {

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
        
        switch (args[3]) {
            
            //Pages Casernes
            case "listercasernes":
                ArrayList LesCasernes = DaoCaserne.getLesCasernes(cnx);
                request.setAttribute("LesCasernes", LesCasernes);
                getServletContext().getRequestDispatcher("/vues/caserne/listerCasernes.jsp").forward(request, response);
                break;
                
            case "consultercaserne":
                int id = Integer.parseInt(request.getParameter("id"));
                Caserne uneCaserne = DaoCaserne.getCaserneById(cnx, id);
                request.setAttribute("uneCaserne", uneCaserne);
                getServletContext().getRequestDispatcher("/vues/caserne/consulterCaserne.jsp").forward(request, response);
                break;
                
            case "ajouter":
                Caserne addCaserne = DaoCaserne.addCaserne(cnx);
                request.setAttribute("addCaserne", addCaserne);
                this.getServletContext().getRequestDispatcher("/vues/pompier/ajouterCaserne.jsp" ).forward( request, response );
                break;
                
            default:
                System.out.println("Page web non trouvé : " + url);
                throw new AssertionError();
        }
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCaserne</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCaserne at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         FormCaserne form = new FormCaserne();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Caserne c = form.ajouterCaserne(request);
        
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "uneCaserne", c );
		
        if (form.getErreurs().isEmpty()){
            Caserne caserneInsere =  DaoCaserne.addCaserne(cnx, c);
            if (caserneInsere != null ){
                request.setAttribute( "uneCaserne", caserneInsere );
                this.getServletContext().getRequestDispatcher("/vues/caserne/consulterCaserne.jsp" ).forward( request, response );
            }
            else 
            {
                // Cas où l'insertion en bdd a échoué
                //renvoyer vers une page d'erreur 
            }
           
        }
        else
        { 
            // il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs
            ArrayList<Caserne> LesCasernes = DaoCaserne.getLesCasernes(cnx);
            request.setAttribute("addCaserne", LesCasernes);
            this.getServletContext().getRequestDispatcher("/vues/caserne/ajouterCaserne.jsp" ).forward( request, response );
        }
           
    }
    
}

