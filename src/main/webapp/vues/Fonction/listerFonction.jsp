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
                    <th>id</th>
                    <th>libellé</th>                
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Fonction f : lesFonctions)
                        {              
                            out.println("<tr><td><a>");
                            out.println(f.getId());
                            out.println("</a></td>");

                            out.println("<td>");
                            out.println(f.getLibelle());
                            out.println("</td>");
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
