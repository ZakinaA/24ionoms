<%-- 
    Document   : ajouterFonction
    Created on : 18 avril 2024, 11:09:31
    Author     : Matys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Fonction"%>
<%@page import="form.FormFonction"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <h1>NOUVELLE FONCTION</h1>
            <%
                FormFonction form = (FormFonction)request.getAttribute("form");
            %>
        <form class="form-inline" action="" method="POST">
                <label for="libelle">LIBELLE : </label>
                <input id="libelle" type="text" name="libelle"  size="30" maxlength="30">
                </br>            
            <input type="submit" name="valider" id="valider" value="Valider"/>
        </form>    
    </body>
</html>
