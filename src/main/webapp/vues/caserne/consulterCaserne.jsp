<%-- 
    Document   : consulterPompier
    Created on : 04 avril 2024, 08:58:07
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Caserne"%>
<%@page import="model.Pompier"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS - Consulter une caserne</title>
    </head>
    <body>
        <h1>Informations Caserne</h1>
        <%
            Caserne c = (Caserne)request.getAttribute("Caserne");
            ArrayList<uneCaserne> Caserne = (ArrayList)request.getAttribute("pompiers");
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
                        for (Caserne c : caserne)
                        {              
                            out.println("<tr><td>");
                            out.println(c.getId());
                            out.println("</a></td>");

                            out.println("<td>");
                            out.println(c.getNom());
                            out.println("</td>");;

                            out.println("<td>");
                            out.println(c.getRue());
                            out.println("</td>");
                           
                            out.println("<td>");
                            out.println("" + c.getCopos());
                            out.println("</td>");
                            
                            out.println("<td>");
                            out.println(c.getVille());
                            out.println("</td>");
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
    </body>
</html>