/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Livro;
import util.ConectaBanco;

/**
 *
 * @author Jefferson
 */
public class LivroDAO {
    //idexemplar, titulo, autor, editora, anopublicacao, numpaginas, descricao, situacao
    public static final String INSERT = "INSERT INTO livros (titulo, autor, editora,"
            + " anopublicacao, numpaginas, descricao, situacao) VALUES (?,?,?,?,?,?,?)";
    public static final String SELECT_ALL = "SELECT idexemplar, titulo, autor, editora, anopublicacao, numpaginas, descricao, situacao FROM livros ORDER BY TITULO";
    public static final String SELECT_UM = "SELECT * FROM livros WHERE titulo LIKE ?";
    public static final String SELECT_UMLIVRO = "SELECT * FROM livros WHERE idexemplar = ?";
    public static final String CREATE = "UPDATE livros SET titulo=?, autor=?, editora=?, anopublicacao=?, numpaginas=?, descricao=?, situacao=?, carteirinha=? WHERE idexemplar=?";
    public static final String CARACTERIZAR = "UPDATE livros SET titulo=?, autor=?, editora=?, anopublicacao=?, numpaginas=?, descricao=?, situacao=? WHERE idexemplar=?";
    public static final String SELECT_EMPRESTIMO = "SELECT * FROM livros WHERE idexemplar = ?";
    public static final String SELECT_LISTA = "SELECT * FROM livros WHERE carteirinha = ?";
    public static final String DELETE = "DELETE FROM livros WHERE idexemplar = ?";
    public static final String SELECT_LIVRO = "SELECT * FROM livros WHERE idexemplar = ?";
    
    public ArrayList<Livro> ListarLivros() throws SQLException {

        ArrayList<Livro> alunoListaLivro = new ArrayList<Livro>();
        try {
            Connection conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Livro novoLivro = new Livro();
                novoLivro.setIdexemplar(rs.getInt("idexemplar"));
                novoLivro.setTitulo(rs.getString("titulo"));
                novoLivro.setAutor(rs.getString("autor"));
                novoLivro.setEditora(rs.getString("editora"));
                novoLivro.setAnopublicacao(rs.getInt("anopublicacao"));
                novoLivro.setNumpaginas(rs.getInt("numpaginas"));
                novoLivro.setDescricao(rs.getString("descricao"));
                novoLivro.setSituacao(rs.getString("situacao"));

                alunoListaLivro.add(novoLivro);
            }
            conexao.close();
            return alunoListaLivro;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }
    
    public ArrayList<Livro> listarEmprestimos(Livro carteirinha) {

        try {
            ArrayList<Livro> listaemprestimo = new ArrayList<>();
            Connection conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_LISTA);
            pstmt.setInt(1, carteirinha.getCarteirinha());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Livro novoLivro = new Livro();
                novoLivro.setIdexemplar(rs.getInt(1));
                novoLivro.setTitulo(rs.getString(2));
                novoLivro.setAutor(rs.getString(3));
                novoLivro.setEditora(rs.getString(4));
                novoLivro.setAnopublicacao(rs.getInt(5));
                novoLivro.setNumpaginas(rs.getInt(6));
                novoLivro.setDescricao(rs.getString(7));
                novoLivro.setSituacao(rs.getString(8));
                novoLivro.setCarteirinha(rs.getInt(9));
                
                listaemprestimo.add(novoLivro);
            }
            
            conexao.close();
            return listaemprestimo;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    public ArrayList<Livro> selecionarLivros(Livro livro) {

        try {
            ArrayList<Livro> alunoListaLivro = new ArrayList<>();
            Connection conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_UM);
            pstmt.setString(1, livro.getTitulo()+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Livro novoLivro = new Livro();
                novoLivro.setIdexemplar(rs.getInt(1));
                novoLivro.setTitulo(rs.getString(2));
                novoLivro.setAutor(rs.getString(3));
                novoLivro.setEditora(rs.getString(4));
                novoLivro.setAnopublicacao(rs.getInt(5));
                novoLivro.setNumpaginas(rs.getInt(6));
                novoLivro.setDescricao(rs.getString(7));
                novoLivro.setSituacao(rs.getString(8));
                novoLivro.setCarteirinha(rs.getInt(9));
                
                alunoListaLivro.add(novoLivro);
            }
            System.out.println(alunoListaLivro.toString());
            conexao.close();
            return alunoListaLivro;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }
    
 
    public void selecionarLivro(Livro livro) {

        try {
            
            Connection conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_UMLIVRO);
            pstmt.setInt(1, livro.getIdexemplar());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                
                
                livro.setIdexemplar(rs.getInt(1));
                livro.setTitulo(rs.getString(2));
                livro.setAutor(rs.getString(3));
                livro.setEditora(rs.getString(4));
                livro.setAnopublicacao(rs.getInt(5));
                livro.setNumpaginas(rs.getInt(6));
                livro.setDescricao(rs.getString(7));
                livro.setSituacao(rs.getString(8));
                
                
              }
            conexao.close();
          } catch (SQLException e) {
            System.out.println(e);
          }
    }
    
    public void selecionarEmprestimo(Livro livro) {

        try {
            
            Connection conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_EMPRESTIMO);
            pstmt.setInt(1, livro.getIdexemplar());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ;
                
                livro.setIdexemplar(rs.getInt(1));
                livro.setTitulo(rs.getString(2));
                livro.setAutor(rs.getString(3));
                livro.setEditora(rs.getString(4));
                livro.setAnopublicacao(rs.getInt(5));
                livro.setNumpaginas(rs.getInt(6));
                livro.setDescricao(rs.getString(7));
                livro.setSituacao(rs.getString(8));
                livro.setCarteirinha(rs.getInt(9));
                
                
              }
            conexao.close();
          } catch (SQLException e) {
            System.out.println(e);
          }
    }
    
    public void Caracterizar(Livro livro) {

        try {
            
            Connection conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_LIVRO);
            pstmt.setInt(1, livro.getIdexemplar());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                
                livro.setIdexemplar(rs.getInt(1));
                livro.setTitulo(rs.getString(2));
                livro.setAutor(rs.getString(3));
                livro.setEditora(rs.getString(4));
                livro.setAnopublicacao(rs.getInt(5));
                livro.setNumpaginas(rs.getInt(6));
                livro.setDescricao(rs.getString(7));
                livro.setSituacao(rs.getString(8));
                livro.setCarteirinha(rs.getInt(9));
                
                
              }
            conexao.close();
          } catch (SQLException e) {
            System.out.println(e);
          }
    }

    public void cadastrar(Livro livro) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(INSERT);
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setString(3, livro.getEditora());
            pstmt.setInt(4, livro.getAnopublicacao());
            pstmt.setInt(5, livro.getNumpaginas());
            pstmt.setString(6, livro.getDescricao());
            pstmt.setString(7, livro.getSituacao());
            pstmt.execute();
            System.out.println(System.getProperty("file.encoding"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void alterarLivro(Livro livro) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(CREATE);
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setString(3, livro.getEditora());
            pstmt.setInt(4, livro.getAnopublicacao());
            pstmt.setInt(5, livro.getNumpaginas());
            pstmt.setString(6, livro.getDescricao());
            pstmt.setString(7, livro.getSituacao());
            pstmt.setInt(8, livro.getCarteirinha());
            pstmt.setInt(9, livro.getIdexemplar());
            pstmt.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void CaracterizarLivro(Livro livro) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(CARACTERIZAR);
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setString(3, livro.getEditora());
            pstmt.setInt(4, livro.getAnopublicacao());
            pstmt.setInt(5, livro.getNumpaginas());
            pstmt.setString(6, livro.getDescricao());
            pstmt.setString(7, livro.getSituacao());
            pstmt.setInt(8, livro.getIdexemplar());
            pstmt.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    
    
    public void deletarLivro (Livro livro){
        
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(DELETE);
            pstmt.setInt(1, livro.getIdexemplar());
            pstmt.execute();
            conexao.close();
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
