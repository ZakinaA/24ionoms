<%-- 
    Document   : consulterPompier
    Created on : 18 mars 2024, 12:03:07
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pompier"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <%
            Pompier p = (Pompier)request.getAttribute("pPompier");
            if(p == null) out.println("Pompier est null");
        %>
        <h1>Bienvenue
        <%
            out.println(p.getPrenom());
            out.println(p.getNom());
        %>
        </h1>
        <table>
            <tr>             
                    <th>id</th>
                    <th>bip</th>
                    <th>nom</th>
                    <th>prenom</th>
                    <th>caserne</th>
            </tr>
            <tr>
                <%
                    out.println("<td><b>");
                    out.println(p.getId());
                    out.println("</b></td>");
                    
                    out.println("<td>");
                    if(p.getBip() == null){
                        out.println("Non défini");
                    } else out.println(p.getBip());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(p.getNom());
                    out.println("</td>");;
                    
                    out.println("<td>");
                    out.println(p.getPrenom());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(p.getUneCaserne().getNom());
                    out.println("</td>");
                %>
            </tr>
        </table>
    </body>
</html>
