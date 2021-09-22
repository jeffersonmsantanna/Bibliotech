<%-- 
    Document   : Caracterizar
    Created on : 8 de jun de 2021, 20:21:32
    Author     : Jefferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Caracterizar livro</title>
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

        <h1>Alterar Dados</h1>

        <% if (request.getAttribute("titulo") != null) {

        %>

        <form name="frmAlterar"  method="POST" action="Alterar">
            <table id="tabela">
                <tr>
                    Número do Exemplar:  
                <input type="text" name="txtNumExemplar" class="txtBox2" readonly value="<%out.print(request.getAttribute("idexemplar"));%>"

                       <input type="Submit" name="btnBusca" value="Buscar"> 
                </tr>
                <tr>
                    <td>Título do Livro </td>
                    <td><input type="text" name="txtTitulo" class="txtBox1"  value="<%out.print(request.getAttribute("titulo"));%>" ></td> 
                </tr>
                <tr>
                    <td>Autor:</td>
                    <td><input type="text" name="txtAutor" class="txtBox1"  value="<%out.print(request.getAttribute("autor"));%>"></td> 
                </tr>
                <tr>
                    <td>Editora:</td>
                    <td> <input type="text" name="txtEditora" class="txtBox1"  value="<%out.print(request.getAttribute("editora"));%>"></td> 
                </tr>
                <tr>
                    <td>Ano de publicação:</td>
                    <td><input type="text" name="txtAno" class="txtBox2"  value="<%out.print(request.getAttribute("anopublicacao"));%>"></td> 
                </tr>
                <tr>
                    <td>Número de páginas:</td>
                    <td><input type="text" name="txtNumPaginas" class="txtBox2"  value="<%out.print(request.getAttribute("numpaginas"));%>"></td> 
                </tr>
                <tr>
                    <td>Descrição:</td>
                    <td><input type="text" name="txtDescricao" class="txtBox3"  value="<%out.print(request.getAttribute("descricao"));%>"></td>  
                </tr>
                <tr>
                    <td>Situação</td>
                    <td><input type="radio" name="rdSituacao" value="1"> Disponível <br>
                        <input type="radio" name="rdSituacao" value="2"> Indisponível<br>  </td>
                </tr>
            </table>
            <input type="Submit" value="Alterar" class="Botao1">
        </form>   

        <%} else {%>

               
        <form name="frmPesquisaLivro" action="CListar" method="POST">
            Número do Exemplar:
            <input type="text" name="idexemplar" class="txtBox2">
            <input type="Submit" value="Buscar" class="btnBusca">
            
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
                <script src="scripts/validador.js"></script>
                <%}%>
     </body>
</html>
