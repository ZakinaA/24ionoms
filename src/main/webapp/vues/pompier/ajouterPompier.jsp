<%-- 
    Document   : ajouterPompier
    Created on : 18 mars 2024, 13:30:47
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Caserne"%>
<%@page import="form.FormPompier"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <h1>NOUVEAU POMPIER</h1>
        
            <%
                FormPompier form = (FormPompier)request.getAttribute("form");
            %>
        
        <form class="form-inline" action="ajouter" method="POST">
                <label for="nom">NOM : </label>
                <input id="nom" type="text" name="nom"  size="30" maxlength="30">
                </br>
                
                <label for="prenom">PRENOM : </label>
                <input id="prenom"  type="text"  name="prenom" size="30" maxlength="30">      
                 </br>
               
                
                <%-- Champ Liste des casernes --%>
                <label for="caserne">Caserne : </label>
                <select name="idPompier">
                    <%
                        ArrayList<Caserne> lesCasernes= (ArrayList)request.getAttribute("pLesCasernes");
                        for (int i=0; i<lesCasernes.size();i++){
                            Caserne c = lesCasernes.get(i);
                            out.println("<option value='" + c.getId()+"'>" + c.getNom()+"</option>" );
                        }
                    %>
                </select>
                </br>            
                               
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
        
        
        
        
    </body>
</html>
