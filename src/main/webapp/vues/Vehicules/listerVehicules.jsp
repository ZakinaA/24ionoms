<%-- 
    Document   : listerVehicules
    Created on : 4 avr. 2024, 09:03:19
    Author     : ts1sio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Vehicules"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Vehicules> lesVehicules = (ArrayList)request.getAttribute("LesVehicules");
        %>
        <table>  
            <thead>
                <tr>             
                    <th style='border:1px solid black'>id</th>
                    <th style='border:1px solid black'>Immatricule</th>  
                    <th style='border:1px solid black'>Date Origine</th>
                    <th style='border:1px solid black'>Date Révision</th>
                    <th style='border:1px solid black'>Caserne</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        out.println("<h1>Liste des Vehicules</h1>");
                        for (Vehicules v : lesVehicules)
                        {              
                            out.println("<tr><td style='border:1px solid black'><a>");
                            out.println(v.getId());
                            out.println("</a></td>");

                            out.println("<td style='border:1px solid black'>");
                            out.println(v.getImmat());
                            out.println("</td>");
                            
                            out.println("<td style='border:1px solid black'>");
                            out.println(v.getDateOrigin());
                            out.println("</td>");
                            
                            out.println("<td style='border:1px solid black'>");
                            out.println(v.getDateRevision());
                            out.println("</td>");
                            
                            
                            out.println("<td style='border:1px solid black'>");
                            out.println(v.getUneCaserne().getNom());
                            out.println("</td>");
                        } // Affichage des fonctions //
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
