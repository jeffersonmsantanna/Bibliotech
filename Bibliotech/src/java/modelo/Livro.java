/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jefferson
 */
public class Livro {
    
    private int idexemplar;
    private String titulo;
    private String autor;
    private  String editora;
    private int anopublicacao;
    private int numpaginas;
    private String descricao;
    private String situacao;
    private int carteirinha;

    public int getIdexemplar() {
        return idexemplar;
    }

    public void setIdexemplar(int idexemplar) {
        this.idexemplar = idexemplar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnopublicacao() {
        return anopublicacao;
    }

    public void setAnopublicacao(int anopublicacao) {
        this.anopublicacao = anopublicacao;
    }

    public int getNumpaginas() {
        return numpaginas;
    }

    public void setNumpaginas(int numpaginas) {
        this.numpaginas = numpaginas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(int carteirinha) {
        this.carteirinha = carteirinha;
    }
    
}
