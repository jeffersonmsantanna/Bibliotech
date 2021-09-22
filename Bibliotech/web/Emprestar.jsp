<%-- 
    Document   : Emprestar
    Created on : 6 de jun de 2021, 16:19:49
    Author     : Jefferson
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Livro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emprestar livros</title>
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

        <h1>Empréstimo de livros</h1>
        
        <% if (request.getAttribute("titulo") != null) {

                

        %>
        
        <form name="frmEmprestar"  method="POST" action="emprestar">
            <table id="tabela">
                <tr>
                    Número do Exemplar:  
                    <input type="text" name="txtNumExemplar" class="txtBox2" readonly value="<%out.print(request.getAttribute("idexemplar"));%>"
                           
                    <input type="Submit" name="btnBusca" value="Buscar"> 
                    </tr>
                    <tr>
                        <td>Título do Livro </td>
                        <td><input type="text" name="txtTitulo" class="txtBox1" readonly value="<%out.print(request.getAttribute("titulo"));%>" ></td> 
                    </tr>
                    <tr>
                        <td>Autor:</td>
                        <td><input type="text" name="txtAutor" class="txtBox1" readonly value="<%out.print(request.getAttribute("autor"));%>"></td> 
                    </tr>
                    <tr>
                        <td>Editora:</td>
                        <td> <input type="text" name="txtEditora" class="txtBox1" readonly value="<%out.print(request.getAttribute("editora"));%>"></td> 
                    </tr>
                    <tr>
                        <td>Ano de publicação:</td>
                        <td><input type="text" name="txtAno" class="txtBox2" readonly value="<%out.print(request.getAttribute("anopublicacao"));%>"></td> 
                    </tr>
                    <tr>
                        <td>Número de páginas:</td>
                        <td><input type="text" name="txtNumPaginas" class="txtBox2" readonly value="<%out.print(request.getAttribute("numpaginas"));%>"></td> 
                    </tr>
                    <tr>
                        <td>Descrição:</td>
                        <td><input type="text" name="txtDescricao" class="txtBox3" readonly value="<%out.print(request.getAttribute("descricao"));%>"></td>  
                    </tr>
                    <tr>
                        <td>Situação</td>
                        <td><input type="text" name="txtSituacao" class="txtBox4" readonly value="<%out.print(request.getAttribute("situacao"));%>"></td>  
                    </tr>
                    <tr>
                        <td>N° Carteirinha</td>
                        <td><input type="text" name="txtCarteirinha" class="txtBox4"></td>  
                    </tr>
            </table>
            <input type="button" value="Emprestar Livro" class="Botao1" onclick="validarEmprestimo()">
        </form>   
        <script src="scripts/validadorEmprestimo.js"></script>
        <%} else {%>
         
        <form name="frmEmprestimo" action="listarLivro" method="POST">
            Número do Exemplar:  
            <input type="text" name="txtNumExemplar" class="txtBox2"> <span>
            <input type="Submit" name="btnBusca" value="Buscar"> 
          </form>
        <form name="frmEmprestar"  method="POST" action="atualizar">
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
                    <tr>
                        <td>Situação</td>
                        <td><input type="text" name="txtSituacao" class="txtBox2"></td>  
                    </tr>
                    <tr>
                        <td>N° Carteirinha</td>
                        <td><input type="text" name="txtCarteirinha" class="txtBox4"></td>  
                    </tr>
            </table>
            <br>
            <input type="button" value="Emprestar Livro" class="Botao1" onclick="validarEmprestimo()">
        </form>   
        <script src="scripts/validadorEmprestimo.js"></script>
        <%}%>
     </body>
</html>
