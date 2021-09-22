<%-- 
    Document   : Sucesso
    Created on : 6 de jun de 2021, 16:26:41
    Author     : Jefferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucesso</title>
        <link rel="stylesheet" href="css/styleSecretario.css"/>
    </head>
    <body>
        <h1 style="color: blue;"> <%= request.getAttribute("mensagem") %></h1>
        <p><a href="<%= request.getContextPath()%>/Cadastrar.jsp" class="Botao1">Voltar para o início</a></p>
    </body>
</html>
