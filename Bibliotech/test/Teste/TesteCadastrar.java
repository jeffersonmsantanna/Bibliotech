/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import modelo.Livro;

/**
 *
 * @author Jefferson
 */
public class TesteCadastrar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Livro livro = new Livro ();
        livro.setTitulo("Padrões de projeto");
        livro.setAutor("Erich Gamma");
        livro.setAnopublicacao(2000);
        livro.setNumpaginas(368);
        livro.setDescricao("Programação");
        livro.setEditora("Bookman");
        livro.setSituacao("Disponível");
        dao.LivroDAO livroDAO = new dao.LivroDAO();
        livroDAO.cadastrar(livro);
        System.out.println("Cadastrado com sucesso");
        System.out.println(System.getProperty("file.encoding"));
    }
    
}
