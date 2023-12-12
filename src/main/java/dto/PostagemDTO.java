package dto;

import postagem.Postagem;
import postagem.Publicacao;
import java.io.Serializable;
import java.time.LocalDate;

public class PostagemDTO implements Serializable {

    private Long id;
    private String titulo;
    private LocalDate datapublicacao;
    private String conteudo;
    private LocalDate dataedicao;
    private Publicacao publicacao;

    // Construtor que aceita uma Postagem e cria um DTO
    public PostagemDTO(Postagem postagem) {
        this.id = postagem.getId();
        this.titulo = postagem.getTitulo();
        this.datapublicacao = postagem.getDatapublicacao();
        this.conteudo = postagem.getConteudo();
        this.dataedicao = postagem.getDataedicao();
        this.publicacao = postagem.getPublicacao();
    }

    // Getters e Setters

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
}
