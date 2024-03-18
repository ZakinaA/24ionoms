/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import database.DaoPompier;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.ArrayList;
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
       
        // Récup et affichage les eleves 
        if(url.equals("/sdisweb/ServletPompier/lister"))
        {              
            ArrayList<Pompier> lesPompiers = DaoPompier.getLesPompiers(cnx);
            request.setAttribute("pLesPompiers", lesPompiers);
            //System.out.println("lister eleves - nombres d'élèves récupérés" + lesEleves.size() );
           getServletContext().getRequestDispatcher("/vues/pompier/listerPompiers.jsp").forward(request, response);
        }
        
         // Récup et affichage des clients interessés par une certaine catégorie de ventes
        if(url.equals("/sdisweb/ServletPompier/consulter"))
        {  
            // tout paramètre récupéré de la request Http est de type String
            // Il est donc nécessaire de caster le paramètre idPompier en int
            int idPompier = Integer.parseInt((String)request.getParameter("idPompier"));
            System.out.println( "pompier à afficher = " + idPompier);
            Pompier p= DaoPompier.getPompierById(cnx, idPompier);
            request.setAttribute("pPompier", p);
            getServletContext().getRequestDispatcher("/vues/pompier/consulterPompier.jsp").forward(request, response);       
           
           
        }
        
        if(url.equals("/sdisweb/ServletPompier/ajouter"))
        {                   
           this.getServletContext().getRequestDispatcher("/vues/pompier/ajouterPompier.jsp" ).forward( request, response );
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
        processRequest(request, response);
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
