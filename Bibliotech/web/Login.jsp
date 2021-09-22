<%-- 
    Document   : TelaLogin
    Created on : 6 de jun de 2021, 16:25:36
    Author     : Jefferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Tela Login</title>
        <link rel="stylesheet" href="css/styleLogin.css"/>
    </head>
    <body>
        <div class="divLogin">
            <form name="frmLogin"  method="POST" action="ValidarDados">
                <h1>Login</h1>
                <label>CPF</label>
                <br>
                <input type="text" name="cpf" placeholder="CPF" Class="cxTexto1">
                <br></br>
                <label>Data de Nascimento</label>
                <br>
                <input type="password" name="dn" placeholder="ddmmaaaa" Class="cxTexto1">
                <br></br>
                <input type="button" value="Acessar" Class="Botao1" onclick="valida()" >
            </form>
        </div>

        <script src="scripts/validador.js"></script>
    </body>
</html>
