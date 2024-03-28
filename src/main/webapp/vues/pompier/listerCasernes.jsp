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
        <title>SDIS WEB</title>
    </head>
    <body>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>APPLICATION DE GESTION SDIS CALVADOS</title>
    </head>
    <body>
        <h1>Liste des casernes du Calvados</h1>
            <%
                ArrayList<Caserne> lesCasernes = (ArrayList)request.getAttribute("cLesCasernes");
            %>
            <table>  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>nom</th>
                    <th>rue</th>
                    <th>code postal</th>
                    <th>ville</th> 
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Caserne c : lesCasernes)
                        {              
                            out.println("<tr><td>");
                            out.println(c.getId());
                            out.println("</a></td>");

                            out.println("<td><a href ='../ServletPompier/consulter?idPompier=" + p.getId() + "'>");
                            out.println(c.getNom());
                            out.println("</td>");;

                            out.println("<td>");
                            out.println(p.getRue());
                            out.println("</td>");
                           
                            out.println("<td>");
                            out.println("" + p.getCopos());
                            out.println("</td>");
                            
                            out.println("<td>");
                            out.println(p.getVille());
                            out.println("</td>");
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
    </body>
</html>
