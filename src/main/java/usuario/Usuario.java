/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

import processoseletivo.Participa;
import processoseletivo.ProcessoSeletivo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author welin
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 120, nullable = false)
    private String nome;
    
    private LocalDate dataNascimento;
    
    @Column(length = 15, nullable = false)
    private Long telefone;
    
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    private Credencial credencial;
    
    @OneToMany(mappedBy = "processoSeletivo")
    private List<Participa> processos;

    public Usuario(String nome, LocalDate dataNascimento, Long telefone, Credencial credencial) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.credencial = credencial;
    }
    

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    public List<Participa> getProcessos() {
        return processos;
    }

    public void setProcessos(List<Participa> processos) {
        this.processos = processos;
    }

    public String getEmail() {
        return credencial.getEmail();
    }


    
    
}
