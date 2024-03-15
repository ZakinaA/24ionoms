<%-- 
    Document   : lister_pompiers.jsp
    Created on : 15 mars 2024, 16:50:49
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pompier"%>
<%@page import="model.Caserne"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>APPLICATION DE GESTION SDIS CALVADOS</title>
    </head>
    <body>
        <h1>Liste des pompiers du Calvados</h1>
            <%
                ArrayList<Pompier> lesPompiers = (ArrayList)request.getAttribute("pLesPompiers");
            %>
            <table>  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>nom</th>
                    <th>prenom</th>
                    <th>caserne</th>                
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Pompier p : lesPompiers)
                        {              
                            out.println("<tr><td>");
                            out.println(p.getId());
                            out.println("</a></td>");

                            out.println("<td>");
                            out.println(p.getNom());
                            out.println("</td>");

                            out.println("<td>");
                            out.println(p.getPrenom());
                            out.println("</td>");
                           
                            out.println("<td>");
                            out.println(p.getUneCaserne().getNom());
                            out.println("</td>");
                               
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
    </body>
</html>
