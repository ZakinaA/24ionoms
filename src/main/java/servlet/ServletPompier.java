
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
import model.Pompier;

/**
 *
 * @author zakina
 */
public class ServletPompier extends HttpServlet {

     Connection cnx ;
            
    @Override
    public void init()
    {     
        ServletContext servletContext=getServletContext();
        cnx = (Connection)servletContext.getAttribute("connection");     
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
            out.println("<title>Servlet ServletPompier</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPompier at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();
        String[] args = url.split("/");
        
        // Pages Pompiers
        switch (args[3]) {
            
            case "lister":
                ArrayList<Pompier> lesPompiers = DaoPompier.getLesPompiers(cnx);
                request.setAttribute("LesPompiers", lesPompiers);
                //System.out.println("lister eleves - nombres d'élèves récupérés" + lesEleves.size() );
                getServletContext().getRequestDispatcher("/vues/pompier/listerPompiers.jsp").forward(request, response);
                break;
            
            case "consulter":
                int idPompier = Integer.parseInt((String)request.getParameter("idPompier"));
                System.out.println( "pompier à afficher = " + idPompier);
                Pompier p= DaoPompier.getPompierById(cnx, idPompier);
                request.setAttribute("pPompier", p);
                getServletContext().getRequestDispatcher("/vues/pompier/consulterPompier.jsp").forward(request, response);
                break;

            case "ajouter":
                ArrayList<Caserne> lesCasernes = DaoCaserne.getLesCasernes(cnx);
                request.setAttribute("pLesCasernes", lesCasernes);
                this.getServletContext().getRequestDispatcher("/vues/pompier/ajouterPompier.jsp" ).forward( request, response );
                break;
            
            default:
                System.out.println("Page web non trouvé : " + url);
                throw new AssertionError();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         FormPompier form = new FormPompier();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Pompier p = form.ajouterPompier(request);
        
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "pPompier", p );
		
        if (form.getErreurs().isEmpty()){
            Pompier pompierInsere =  DaoPompier.addPompier(cnx, p);
            if (pompierInsere != null ){
                request.setAttribute( "pPompier", pompierInsere );
                this.getServletContext().getRequestDispatcher("/vues/pompier/consulterPompier.jsp" ).forward( request, response );
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
            ArrayList<Caserne> lesCasernes = DaoCaserne.getLesCasernes(cnx);
            request.setAttribute("pLesCasernes", lesCasernes);
            this.getServletContext().getRequestDispatcher("/vues/pompier/ajouterPompier.jsp" ).forward( request, response );
        }
           
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
