<%-- 
    Document   : PesquisaAluno
    Created on : 6 de jun de 2021, 16:21:10
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
        <link rel="icon" href="img/iconelupa.png">
        <link rel="stylesheet" href="css/styleAluno.css">
    </head>
    <body>
        <img src="img/logo.png" width="250" height="75">
        <h1>Pesquisa de livros</h1>
        <br>

        <form name="frmPesquisaLivro" action="PesquisaAluno" method="POST">
          
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
                </tr>
                <%}%>

            </tbody>
        </table>
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
                </tr>
                <%}%>

            </tbody>
        </table>
        <%}%>
    </body>
</html>
