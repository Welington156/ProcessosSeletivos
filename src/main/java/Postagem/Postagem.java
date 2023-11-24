/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Postagem;

import Usuario.Usuario;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author welin
 */
@Entity
public class Postagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 100)
    private String titulo; 
    
    private LocalDate datapublicacao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario autor;
    
    @Column(length = 50000)
    private String conteudo;
    
    private LocalDate dataedicao;
    
    @Enumerated(EnumType.STRING)
    private Publicacao publicacao;

    public Postagem(String titulo, LocalDate datapublicacao, Usuario autor, String conteudo, LocalDate dataedicao, Publicacao publicacao) {
        this.titulo = titulo;
        this.datapublicacao = datapublicacao;
        this.autor = autor;
        this.conteudo = conteudo;
        this.dataedicao = dataedicao;
        this.publicacao = publicacao;
    }

    public Postagem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDatapublicacao() {
        return datapublicacao;
    }

    public void setDatapublicacao(LocalDate datapublicacao) {
        this.datapublicacao = datapublicacao;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDataedicao() {
        return dataedicao;
    }

    public void setDataedicao(LocalDate dataedicao) {
        this.dataedicao = dataedicao;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public String getDataPublicacao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
