<%-- 
    Document   : Cadastrar
    Created on : 6 de jun de 2021, 16:18:14
    Author     : Jefferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de livros</title>
        <link rel="stylesheet" href="css/styleSecretario.css"/>
    </head>
    <body>
        <img src="img/logo.png" width="250" height="75">

        
        <nav id="menu">
            <ul>
                <li><a href="Cadastrar.jsp">CADASTRAR LIVRO</a></li>
                <li><a href="Emprestar.jsp">EMPRESTAR LIVRO</a></li>
                <li><a href="Devolver.jsp">DEVOLVER LIVRO</a></li>
                <li><a href="Visualizar.jsp">VISUALIZAR EMPRÉSTIMOS</a></li>
                <li><a href="Caracterizar.jsp">CARACTERIZAR SITUAÇÃO</a></li>
                <li><a href="acervoSecretario">PESQUISAR LIVRO</a></li>
             </ul>
        </nav>
        <p>
        
        <h1>Cadastro de livros</h1>
        <form name="frmCadastrar"  method="POST" action="inserir">
            <table id="tabela">
                <tr>
                    <td>Título do Livro </td>
                    <td><input type="text" name="txtTitulo" class="txtBox1"></td> 
                </tr>
                <tr>
                    <td>Autor:</td>
                    <td><input type="text" name="txtAutor" class="txtBox1"></td> 
                </tr>
                <tr>
                    <td>Editora:</td>
                    <td> <input type="text" name="txtEditora" class="txtBox1"></td> 
                </tr>
                <tr>
                    <td>Ano de publicação:</td>
                    <td><input type="text" name="txtAno" class="txtBox2"></td> 
                </tr>
                <tr>
                    <td>Número de páginas:</td>
                    <td><input type="text" name="txtNumPaginas" class="txtBox2"></td> 
                </tr>
                <tr>
                    <td>Descrição:</td>
                    <td><input type="text" name="txtDescricao" class="txtBox3"></td>  
                </tr>
                </table>
            <br>
            <input type="button" value="Cadastrar" class="Botao1" onclick="validarCadastro()">
        </form>   
        <script src="scripts/validadorCadastro.js"></script>
    </body>
</html>
