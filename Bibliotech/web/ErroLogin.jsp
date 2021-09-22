<%-- 
    Document   : ErroLogin
    Created on : 10 de jun de 2021, 18:34:52
    Author     : Jefferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
        <link rel="stylesheet" href="css/styleSecretario.css"/>
    </head>
    <body>
        <h1 style="color: red;"> <%= request.getAttribute("mensagem") %></h1>
        <p><a href="<%= request.getContextPath()%>/Login.jsp" class="Botao1">Tentar novamente</a></p>
    </body>
</html>
