<%-- 
    Document   : lister_pompiers.jsp
    Created on : 15 mars 2024, 16:50:49
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Grade"%>
<%@page import="model.SurGrade"%>
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
        <h1>Liste des grades de la caserne du Calvados</h1>
            <%
                ArrayList<Grade> grades = (ArrayList)request.getAttribute("grades");
            %>
            <table>  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>libelle</th>
                    <th>surgrade id</th>
                    <th>surgrade libelle</th>                
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Grade g : grades)
                        {
                            out.println("<tr><td>");
                            out.println("" + g.getId());
                            out.println("</a></td>");

                            out.println("<td><a href ='../ServletGrade/consulterGrade?id="+ g.getId()+ "'>");
                            out.println(g.getLibelle());
                            out.println("</td>");;

                            out.println("<td>");
                            out.println("" + g.getSurGrade().getId());
                            out.println("</td>");
                           
                            out.println("<td>");
                            out.println(g.getSurGrade().getLibelle());
                            out.println("</td>");
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
    </body>
</html>
