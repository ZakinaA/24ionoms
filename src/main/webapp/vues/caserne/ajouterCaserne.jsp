<%-- 
    Document   : ajouterPompier
    Created on : 18 mars 2024, 13:30:47
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Caserne"%>
<%@page import="form.FormCaserne"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS - Ajouter une caserne</title>
    </head>
    <body>
        <h1>Nouvelle caserne</h1>
        
            <%
                FormCaserne form = (FormCaserne)request.getAttribute("form");
            %>
        
        <form class="form-inline" action="ajouter" method="POST">
                <label for="nom">Nom : </label>
                <input id="nom" type="text" name="nom"  size="30" maxlength="30">
                </br>
                
                <label for="prenom">Rue : </label>
                <input id="prenom"  type="text"  name="prenom" size="30" maxlength="30">      
                 </br>
                 
                 <label for="prenom">Code Postal : </label>
                <input id="prenom"  type="text"  name="prenom" size="30" maxlength="30">      
                 </br>
                 
                 <label for="prenom">Ville : </label>
                <input id="prenom"  type="text"  name="prenom" size="30" maxlength="30">      
                 </br>   
                               
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
    </body>
</html>
