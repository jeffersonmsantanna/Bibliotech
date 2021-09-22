<%-- 
    Document   : PesquisaSecretario
    Created on : 6 de jun de 2021, 16:23:02
    Author     : Jefferson
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Livro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    /**
     * teste for (int i=0; i< lista.size(); i++){
     *
     * out.println(lista.get(i).getIdexemplar());
     * out.println(lista.get(i).getTitulo());
     * out.println(lista.get(i).getAutor());
     * out.println(lista.get(i).getEditora());
     * out.println(lista.get(i).getAnopublicacao());
     * out.println(lista.get(i).getNumpaginas());
     * out.println(lista.get(i).getDescricao());
     * out.println(lista.get(i).getDisponibilidade()); }
     */

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa</title>
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
        <h1>Pesquisa de livros</h1>
        <br>

        <form name="frmPesquisaLivro" action="PesquisaLivro" method="POST">
            <input type="text" name="txtTitulo" placeholder="Titulo do livro..." class="txtBox">
            <input type="Submit" value="Buscar" class="btnBusca">
            
        </form>

        <br>
        <br>
        <% if (request.getAttribute("acervo") != null) {

                ArrayList<Livro> lista = (ArrayList<Livro>) request.getAttribute("acervo");

        %>
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
                    <th>Opções</th>
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
                    <td><a href="CListar?idexemplar=<%=lista.get(i).getIdexemplar()%>" class="Botao2"> Editar</a>
                    <a href="javascript: confirmar(<%=lista.get(i).getIdexemplar()%>)" class="Botao3"> Excluir</a></td>
                </tr>
                <%}%>

            </tbody>
        </table>
                <script src="scripts/confirmador.js"></script>
        <%} else if (request.getAttribute("acervopesquisa") != null) {

            ArrayList<Livro> listapesquisa = (ArrayList<Livro>) request.getAttribute("acervopesquisa");
        %>
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
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
                <% for (int i = 0; i < listapesquisa.size(); i++) {%>
                <tr>
                    <td><%=listapesquisa.get(i).getIdexemplar()%></td>
                    <td><%=listapesquisa.get(i).getTitulo()%></td>
                    <td><%=listapesquisa.get(i).getAutor()%></td>
                    <td><%=listapesquisa.get(i).getEditora()%></td>
                    <td><%=listapesquisa.get(i).getAnopublicacao()%></td>
                    <td><%=listapesquisa.get(i).getNumpaginas()%></td>
                    <td><%=listapesquisa.get(i).getDescricao()%></td>
                    <td><%=listapesquisa.get(i).getSituacao()%></td>
                    <td><a href="CListar?idexemplar=<%=listapesquisa.get(i).getIdexemplar()%>" class="Botao2"> Editar</a>
                    <a href="javascript: confirmar(<%=listapesquisa.get(i).getIdexemplar()%>" class="Botao3"> Excluir</a></td>
                </tr>
                <%}%>

            </tbody>
        </table>
                <script src="scripts/confirmador.js"></script>
        <%}%>
    </body>
</html>
