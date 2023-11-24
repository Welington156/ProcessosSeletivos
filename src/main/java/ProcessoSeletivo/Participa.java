/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcessoSeletivo;

import Usuario.Usuario;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author welin
 */
@Entity
public class Participa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "processoSeletivo_id")
    private ProcessoSeletivo processoSeletivo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "candidato_id")
    private Usuario candidato;
    
    private LocalDate dataInscricao;
    
    @Column(nullable = false)
    private Float nota;

    
    public Participa(ProcessoSeletivo processoSeletivo, Usuario candidato, LocalDate dataInscricao, Float nota) {
        this.processoSeletivo = processoSeletivo;
        this.candidato = candidato;
        this.dataInscricao = dataInscricao;
        this.nota = nota;
    }

    public Participa() {
    }
      
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessoSeletivo getProcessoSeletivo() {
        return processoSeletivo;
    }

    public void setProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
        this.processoSeletivo = processoSeletivo;
    }

    public Usuario getUsuario() {
        return candidato;
    }

    public void setUsuario(Usuario candidato) {
        this.candidato = candidato;
    }

    public LocalDate getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(LocalDate dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }
   
}
