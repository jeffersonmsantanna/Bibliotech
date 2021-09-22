<%-- 
    Document   : Visualizar
    Created on : 6 de jun de 2021, 21:25:46
    Author     : Jefferson
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Livro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta empréstimos</title>
        <link rel="stylesheet" href="css/styleSecretario.css"/>
        <link href="css/styleSecretario.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="img/iconelupa.png">
        <link rel="stylesheet" href="css/styleAluno.css">
        
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
            <br>
            
         <h1>Consulta de livros emprestados</h1>
        <br>
        <br>
        <% if (request.getAttribute("acervo") != null) {

                ArrayList<Livro> lista = (ArrayList<Livro>) request.getAttribute("acervo");

        %>
        <form name="FrmEmprestimos" action="consultaEmprestimos" method="POST">
            <input type="text" name="txtCarteirinha" placeholder="Carteirinha estudante..." class="txtBox">
            <input type="Submit" value="Buscar" class="btnBusca">
            </form>
        <table id="tabela">
            <thead>
                <tr>
                    <th>Nº exemplar</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Editora</th>
                    <th>Ano publicação</th>
                    <th>Nº páginas</th>
                    <th>Descrição</th>
                    <th>Situação</th>
                    <th>Carteirinha</th>
                </tr>
            </thead>
            <tbody>
                <% for (int i = 0; i < lista.size(); i++) {%>
                <tr>
                    <td><%=lista.get(i).getIdexemplar()%></td>
                    <td><%=lista.get(i).getTitulo()%></td>
                    <td><%=lista.get(i).getAutor()%></td>
                    <td><%=lista.get(i).getEditora()%></td>
                    <td><%=lista.get(i).getAnopublicacao()%></td>
                    <td><%=lista.get(i).getNumpaginas()%></td>
                    <td><%=lista.get(i).getDescricao()%></td>
                    <td><%=lista.get(i).getSituacao()%></td>
                    <td><%=lista.get(i).getCarteirinha()%></td>
                </tr>
                <%}%>

            </tbody>
        </table>
        <%} else {

            
        %>
        <form name="FrmEmprestimos" action="consultaEmprestimos" method="POST">
            <input type="text" name="txtCarteirinha" placeholder="Carteirinha estudante..." class="txtBox">
            <input type="Submit" value="Buscar" class="btnBusca">
            </form>
        <%}%>
    </body>
    </body>
</html>
