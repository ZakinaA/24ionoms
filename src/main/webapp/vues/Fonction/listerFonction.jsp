<%-- 
    Document   : listerFonction
    Created on : 28 mars 2024, 15:33:47
    Author     : ts1sio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="model.Fonction"%>
<%@page import="java.util.ArrayList"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS - lister les fonctions</title>
    </head>
    <body>
        <%
            ArrayList<Fonction> lesFonctions = (ArrayList)request.getAttribute("LesFonctions");
        %>
        <table>  
            <thead>
                <tr>             
                    <th style='border:1px solid black'>id</th>
                    <th style='border:1px solid black'>libellé</th>                
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        out.println("<h1>Liste des fonctions</h1>");
                        for (Fonction f : lesFonctions)
                        {              
                            out.println("<tr><td style='border:1px solid black'><a>");
                            out.println(f.getId());
                            out.println("</a></td>");

                            out.println("<td style='border:1px solid black'>");
                            out.println(f.getLibelle());
                            out.println("</td>");
                        } // Affichage fonctions //
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
