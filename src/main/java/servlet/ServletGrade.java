/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import database.DaoFonction;
import database.DaoVehicules;
import database.DaoCaserne;
import database.DaoGrade;
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
public class ServletGrade extends HttpServlet {

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
        
        switch (url) {
            
            case "/sdisweb/servletgrade/listergrades":
                ArrayList grades = DaoGrade.getLesGrades(cnx);
                request.setAttribute("grades", grades);
                getServletContext().getRequestDispatcher("/vues/Grade/listerGrades.jsp").forward(request, response);
                break;
            
            case "/sdisweb/servletgrade/consultergrade":
                int id = Integer.parseInt(request.getParameter("id"));
                ArrayList pompiers = DaoPompier.getLesPompiers(cnx, id);
                request.setAttribute("pompiers", pompiers);
                getServletContext().getRequestDispatcher("/vues/Grade/consulterGrade.jsp").forward(request, response);
                break;
            
            case "/sdisweb/servletgrade/listersurgrades":
                ArrayList surgrades = DaoGrade.getLesGrades(cnx);
                request.setAttribute("surgrades", surgrades);
                getServletContext().getRequestDispatcher("/vues/Grade/listerSurGrades.jsp").forward(request, response);
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
            out.println("<title>Servlet ServletGrade</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPompier at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
