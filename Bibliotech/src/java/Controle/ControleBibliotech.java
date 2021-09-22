/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import dao.LivroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Livro;
import modelo.Secretario;

/**
 * @author Jefferson
 */
@WebServlet(name = "ControleBibliotech", urlPatterns = {"/ControleBibliotech","/CListar","/listarLivro", "/AcervoBiblioteca","/Alterar","/delete",
 "/ValidarDados", "/inserir", "/acervoSecretario", "/emprestar", "/PesquisaLivro","/PesquisaAluno","/devolver","/listarEmprestimo","/consultaEmprestimos"})
public class ControleBibliotech extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String acao = request.getServletPath();
            if (acao.equals("/AcervoBiblioteca")) {
                mtdAcessarLivrosAluno(request, response);
            } else if (acao.equals("/PesquisaAluno")) {
                mtdPesquisaLivroAluno(request, response);
            }else if (acao.equals("/ValidarDados")) {
                mtdValidarDados(request, response);
            } else if (acao.equals("/inserir")) {
                mtdCadastrarLivro(request, response);
            } else if (acao.equals("/acervoSecretario")) {
                mtdAcessarLivrosSecretario(request, response);
            }else if (acao.equals("/emprestar")) {
                mtdEmprestarLivro(request, response);
            }else if (acao.equals("/PesquisaLivro")) {
                mtdPesquisaLivroSecretario(request, response);
            }else if (acao.equals("/listarEmprestimo")) {
                mtdPesquisaEmprestimo(request, response);
            }else if (acao.equals("/listarLivro")) {
                mtdlistarLivro(request, response);
            }else if (acao.equals("/consultaEmprestimos")) {
                mtdlistarEmprestimos(request, response);
            }else if (acao.equals("/devolver")) {
                mtdDevolverLivro(request, response);
            }else if (acao.equals("/delete")) {
                mtdRemoverLivro(request, response);
            }else if (acao.equals("/CListar")) {
                mtdCaracterizar(request, response);
            }else if (acao.equals("/Alterar")) {
                mtdAlterarLivro(request, response);
            }  else {
                response.sendRedirect("index.html");
            }
        } catch (Exception e) {
            request.setAttribute("erro", e);
            request.getRequestDispatcher("PesquisaAluno.jsp").forward(request, response);
        }
        }
    
    //PAGINA PesquisaAluno. Lista todos os livros
    protected void mtdAcessarLivrosAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        LivroDAO lDAO = new LivroDAO();

        ArrayList<Livro> lista = lDAO.ListarLivros();

        request.setAttribute("acervo", lista);
        request.getRequestDispatcher("PesquisaAluno.jsp").forward(request, response);
    }
    
    //PAGINA PesquisaAluno. Pesquisa por título
    protected void mtdPesquisaLivroAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
    
        modelo.Livro titulo = new modelo.Livro();
        titulo.setTitulo(request.getParameter("txtTitulo"));
        LivroDAO lDAO = new LivroDAO();
        
            List<Livro> lista = lDAO.selecionarLivros(titulo);
        
      
        request.setAttribute("acervopesquisa", lista);
        request.getRequestDispatcher("PesquisaAluno.jsp").forward(request, response);
        
        
    
    }

    // PAGINA Login. Valida Cpf e Data de nascimento.  
    protected void mtdValidarDados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException  {

        int r;
        modelo.Secretario secretario = new Secretario();
        secretario.setCpf(request.getParameter("cpf"));
        secretario.setDn(Integer.parseInt(request.getParameter("dn")));

        dao.SecretarioDAO cdao = new dao.SecretarioDAO();
        r = cdao.validarDados(secretario);
        if (r == 1) {
            request.getRequestDispatcher("Cadastrar.jsp").forward(request, response);
        } else {
             request.setAttribute("mensagem", "Login ou Senha inválidos!");
        request.getRequestDispatcher("ErroLogin.jsp").forward(request, response);
        }

    }
    
    // PAGINA Cadastrar. Recebe como parametros dados dos text box, cria objt livro e invoca metodo cadastrar da LivroDAO
    protected void mtdCadastrarLivro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        
        
        modelo.Livro livro = new modelo.Livro();
        
        livro.setTitulo(request.getParameter("txtTitulo"));
        livro.setAutor(request.getParameter("txtAutor"));
        livro.setAnopublicacao(Integer.parseInt(request.getParameter("txtAno")));
        livro.setNumpaginas(Integer.parseInt(request.getParameter("txtNumPaginas")));
        livro.setDescricao(request.getParameter("txtDescricao"));
        livro.setEditora(request.getParameter("txtEditora"));
        String situacao = "Disponível";
        livro.setSituacao(situacao);
        //livro.setSituacao(request.getParameter("txtSituacao"));
        dao.LivroDAO livroDAO = new dao.LivroDAO();
        livroDAO.cadastrar(livro);
        System.out.println(System.getProperty("file.encoding"));
        response.sendRedirect("acervoSecretario"); 
        

    }
    
    //PAGINA PesquisaSecretario. Lista todos os livros
    protected void mtdAcessarLivrosSecretario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        LivroDAO lDAO = new LivroDAO();

        ArrayList<Livro> lista = lDAO.ListarLivros();

        request.setAttribute("acervo", lista);
        request.getRequestDispatcher("PesquisaSecretario.jsp").forward(request, response);
    }
    
    //PAGINA PesquisaSecretario. Pesquisa por título
    protected void mtdPesquisaLivroSecretario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
    
        modelo.Livro titulo = new modelo.Livro();
        titulo.setTitulo(request.getParameter("txtTitulo"));
        LivroDAO lDAO = new LivroDAO();
        List<Livro> lista = lDAO.selecionarLivros(titulo);
        request.setAttribute("acervopesquisa", lista);
        request.getRequestDispatcher("PesquisaSecretario.jsp").forward(request, response);
    
    }
    
    //PAGINA Emprestar. Recebe o idexemplar e invoca o metodo selecinarLivro da classe LivroDAO.
    protected void mtdlistarLivro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        
        String idexemplar = request.getParameter("txtNumExemplar");
        modelo.Livro livro = new modelo.Livro();
        livro.setIdexemplar(Integer.parseInt(idexemplar));
        
        dao.LivroDAO ldao = new dao.LivroDAO();
        ldao.selecionarLivro(livro);
        //livro.setSituacao(request.getParameter("txtSituacao"));
        request.setAttribute("idexemplar", livro.getIdexemplar());
        request.setAttribute("titulo", livro.getTitulo());
        request.setAttribute("autor", livro.getAutor());
        request.setAttribute("editora", livro.getEditora());
        request.setAttribute("anopublicacao", livro.getAnopublicacao());
        request.setAttribute("numpaginas", livro.getNumpaginas());;
        request.setAttribute("descricao", livro.getDescricao());
        request.setAttribute("situacao", livro.getSituacao());
        request.getRequestDispatcher("Emprestar.jsp").forward(request, response);
    }
    
    //PAGINA Emprestar. Recebe como parametros dados dos text box, cria objt livro e invoca metodo alterarLivro da LivroDAO
    protected void mtdEmprestarLivro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        String situacao = "Indisponível";
        modelo.Livro livro = new modelo.Livro();
        livro.setIdexemplar(Integer.parseInt(request.getParameter("txtNumExemplar")));
        livro.setTitulo(request.getParameter("txtTitulo"));
        livro.setAutor(request.getParameter("txtAutor"));
        livro.setEditora(request.getParameter("txtEditora"));
        livro.setAnopublicacao(Integer.parseInt(request.getParameter("txtAno")));
        livro.setNumpaginas(Integer.parseInt(request.getParameter("txtNumPaginas")));
        livro.setDescricao(request.getParameter("txtDescricao"));
        livro.setSituacao(situacao);
        livro.setCarteirinha(Integer.parseInt(request.getParameter("txtCarteirinha")));
        dao.LivroDAO lDAO = new dao.LivroDAO();
        lDAO.alterarLivro(livro);
        
        request.setAttribute("mensagem", "Empréstimo realizado com sucesso!");
        request.getRequestDispatcher("Sucesso.jsp").forward(request, response); 
        
        
    }
    
    //PAGINA Devolver. Recebe o idexemplar e invoca o metodo selecinarEmprestimo da classe LivroDAO.
    protected void mtdPesquisaEmprestimo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        
        String idexemplar = request.getParameter("txtNumExemplar");
        modelo.Livro livro = new modelo.Livro();
        livro.setIdexemplar(Integer.parseInt(idexemplar));
        
        dao.LivroDAO ldao = new dao.LivroDAO();
        ldao.selecionarEmprestimo(livro);
        //livro.setSituacao(request.getParameter("txtSituacao"));
        request.setAttribute("idexemplar", livro.getIdexemplar());
        request.setAttribute("titulo", livro.getTitulo());
        request.setAttribute("autor", livro.getAutor());
        request.setAttribute("editora", livro.getEditora());
        request.setAttribute("anopublicacao", livro.getAnopublicacao());
        request.setAttribute("numpaginas", livro.getNumpaginas());;
        request.setAttribute("descricao", livro.getDescricao());
        request.setAttribute("situacao", livro.getSituacao());
        request.setAttribute("carteirinha", livro.getCarteirinha());
        
        request.getRequestDispatcher("Devolver.jsp").forward(request, response);
    }
    
    //PAGINA Devolver. Recebe como parametros dados dos text box, cria objt livro e invoca metodo alterarLivro da LivroDAO
    protected void mtdDevolverLivro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        String situacao = "Disponível";
        int carteirinha = 0;
        modelo.Livro livro = new modelo.Livro();
        livro.setIdexemplar(Integer.parseInt(request.getParameter("txtNumExemplar")));
        livro.setTitulo(request.getParameter("txtTitulo"));
        livro.setAutor(request.getParameter("txtAutor"));
        livro.setEditora(request.getParameter("txtEditora"));
        livro.setAnopublicacao(Integer.parseInt(request.getParameter("txtAno")));
        livro.setNumpaginas(Integer.parseInt(request.getParameter("txtNumPaginas")));
        livro.setDescricao(request.getParameter("txtDescricao"));
        livro.setSituacao(situacao);
        livro.setCarteirinha(carteirinha);
        dao.LivroDAO lDAO = new dao.LivroDAO();
        lDAO.alterarLivro(livro);
        response.sendRedirect("acervoSecretario");
        //request.setAttribute("mensagem", "Devolução realizada com sucesso!");
        //request.getRequestDispatcher("Sucesso.jsp").forward(request, response); 
        
        
    }
    
    //PAGINA Visualizar. Recebe como parametro nº da carteirinha, cria objt lista e invoca metodo listarEmprestimos da LivroDAO  
    protected void mtdlistarEmprestimos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        modelo.Livro carteirinha = new modelo.Livro();
        carteirinha.setCarteirinha(Integer.parseInt(request.getParameter("txtCarteirinha")));
        LivroDAO lDAO = new LivroDAO();
        List<Livro> lista = lDAO.listarEmprestimos(carteirinha);
        request.setAttribute("acervo", lista);
        request.getRequestDispatcher("Visualizar.jsp").forward(request, response);
    
    }
    
    //PAGINA Caracterizar. Recebe como parametro idexemplar, cria objt livro e invoca metodo selecionarEmprestimo da LivroDAO
    protected void mtdCaracterizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        modelo.Livro livro = new modelo.Livro();
        livro.setIdexemplar(Integer.parseInt(request.getParameter("idexemplar")));
        //livro.setIdexemplar(Integer.parseInt(request.getParameter("txtNumExemplar")));
        
        dao.LivroDAO ldao = new dao.LivroDAO();
        ldao.Caracterizar(livro);
        //livro.setSituacao(request.getParameter("txtSituacao"));
        request.setAttribute("idexemplar", livro.getIdexemplar());
        request.setAttribute("titulo", livro.getTitulo());
        request.setAttribute("autor", livro.getAutor());
        request.setAttribute("editora", livro.getEditora());
        request.setAttribute("anopublicacao", livro.getAnopublicacao());
        request.setAttribute("numpaginas", livro.getNumpaginas());;
        request.setAttribute("descricao", livro.getDescricao());
        
        
        
        request.getRequestDispatcher("Caracterizar.jsp").forward(request, response);      
    }
    
    //PAGINA Caracterizar. Recebe como parametros dados dos text box radiobutton, cria objt livro e invoca metodo CaracterizarLivro da LivroDAO
    protected void mtdAlterarLivro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String situacao ="";
        String rdSituacao = request.getParameter("rdSituacao");
        if (rdSituacao.equals("1")) {

            situacao = "Disponível";

        } else {
            situacao = "Indsponivel";
        }
        
        modelo.Livro livro = new modelo.Livro();
        livro.setIdexemplar(Integer.parseInt(request.getParameter("txtNumExemplar")));
        livro.setTitulo(request.getParameter("txtTitulo"));
        livro.setAutor(request.getParameter("txtAutor"));
        livro.setEditora(request.getParameter("txtEditora"));
        livro.setAnopublicacao(Integer.parseInt(request.getParameter("txtAno")));
        livro.setNumpaginas(Integer.parseInt(request.getParameter("txtNumPaginas")));
        livro.setDescricao(request.getParameter("txtDescricao"));
        livro.setSituacao(situacao);
        dao.LivroDAO lDAO = new dao.LivroDAO();
        lDAO.CaracterizarLivro(livro);
        

        request.setAttribute("mensagem", "Alteração realizada com sucesso!");
        request.getRequestDispatcher("Sucesso.jsp").forward(request, response);
    }

    protected void mtdRemoverLivro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

              
        modelo.Livro livro = new modelo.Livro();
        
        livro.setIdexemplar(Integer.parseInt(request.getParameter("idexemplar")));
        
        dao.LivroDAO lDAO = new dao.LivroDAO();
        lDAO.deletarLivro(livro);
        

        response.sendRedirect("acervoSecretario");
        //request.getRequestDispatcher("PesquisaSecretario.jsp").forward(request, response);
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
