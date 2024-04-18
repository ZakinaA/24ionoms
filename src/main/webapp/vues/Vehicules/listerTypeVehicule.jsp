<%-- 
    Document   : listerVehicules
    Created on : 4 avr. 2024, 09:03:19
    Author     : ts1sio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.TypeVehicule"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<TypeVehicule> lesTypeVehicule = (ArrayList)request.getAttribute("LesTypeVehicule");
        %>
        <table>  
            <thead>
                <tr>             
                    <th style='border:1px solid black'>id</th>
                    <th style='border:1px solid black'>Nom</th>  
                    <th style='border:1px solid black'>caracteristique</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        out.println("<h1>Liste des Types de Vehicules</h1>");
                        for (TypeVehicule v : lesTypeVehicule)
                        {              
                            out.println("<tr><td style='border:1px solid black'><a>");
                            out.println(v.getId());
                            out.println("</a></td>");

                            out.println("<td style='border:1px solid black'>");
                            out.println(v.getNom());
                            out.println("</td>");
                            
                            out.println("<td style='border:1px solid black'>");
                            out.println(v.getCaracteristique());
                            out.println("</td>");
                        } // Affichage des fonctions //
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
