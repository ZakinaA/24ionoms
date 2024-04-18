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
        <%
            Caserne c = (Caserne)request.getAttribute("cCaserne");
        %>
        <h1>Informations Caserne</h1>
        <div class="caserne">
            <main>
                <div class="info">
                    <div class="caserneInfo">
                            <label>Id :</label>
                        <tr><%= out.println(caserne.getId()) %></tr>
                    </div>                  
                </div>
            </main>
        </div>     
    </body>
</html>
