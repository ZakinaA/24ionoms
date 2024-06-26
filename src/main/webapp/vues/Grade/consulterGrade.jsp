<%-- 
    Document   : lister_pompiers.jsp
    Created on : 15 mars 2024, 16:50:49
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Grade"%>
<%@page import="model.SurGrade"%>
<%@page import="model.Pompier"%>
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
        <h1>Grade de la caserne du Calvados</h1>
            <%
                Grade g = (Grade)request.getAttribute("grade");
                ArrayList<Pompier> pompiers = (ArrayList)request.getAttribute("pompiers");
                
                if(request.getParameter("id") == null){
                    out.println("<p>Veuillez préciser l'Id du grade à consulter</p>");
                    out.println("<a href='./listerGrades'>Retournes à la liste des Grades</a>");
                    return;
                }
            %>
            <table>
                <tr>             
                    <th>id</th>
                    <th>libelle</th>
                    <th>id surgrade</th>
                    <th>surgrade</th>
                </tr>
                <tr>
                    <%
                        out.println("<td>");
                        out.println(g.getId());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(g.getLibelle());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(g.getSurGrade().getId());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(g.getSurGrade().getLibelle());
                        out.println("</td>");
                    %>
                </tr>
            </table>
            <h2>Pompiers ayant ce grade :</h2>
            <table>
            <thead>
                <tr>             
                    <th>id</th>
                    <th>bip</th>
                    <th>nom</th>
                    <th>prenom</th>
                    <th>caserne</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Pompier p : pompiers)
                        {
                            out.println("<tr><td>");
                            out.println(p.getId());
                            out.println("</a></td>");

                            out.println("<td><a href ='../ServletPompier/consulter?idPompier=" + p.getId() + "'>");
                            if(p.getBip() == null){
                                out.println("Non défini");
                            } else out.println(p.getBip());
                            out.println("</td>");;
                            
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
