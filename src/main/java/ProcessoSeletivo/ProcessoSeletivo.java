/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcessoSeletivo;

import Usuario.Usuario;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author welin
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "findProcessoSeletivo",
            query = "SELECT p FROM ProcessoSeletivo p"
    )
})
public class ProcessoSeletivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate dataInicio;
    
    private LocalDate dataFim;
    
    @Column(length = 100)
    private String titulo;
    
    @Column(nullable = false)
    private boolean ativo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario criador;
    
    private LocalDate dataProva;
    
    private LocalDate dataGabarito;
    
    private LocalDate dataResultado;
    
    @Column(length = 100)
    private String linkEdital;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy= "candidato")
    private List<Participa> membros;

    public ProcessoSeletivo(LocalDate dataInicio, LocalDate dataFim, String titulo, boolean ativo, Usuario criador, LocalDate dataProva, LocalDate dataGabarito, LocalDate dataResultado, String linkEdital, List<Participa> membros) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.titulo = titulo;
        this.ativo = ativo;
        this.criador = criador;
        this.dataProva = dataProva;
        this.dataGabarito = dataGabarito;
        this.dataResultado = dataResultado;
        this.linkEdital = linkEdital;
        this.membros = membros;
    }

    public ProcessoSeletivo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public LocalDate getDataProva() {
        return dataProva;
    }

    public void setDataProva(LocalDate dataProva) {
        this.dataProva = dataProva;
    }

    public LocalDate getDataGabarito() {
        return dataGabarito;
    }

    public void setDataGabarito(LocalDate dataGabarito) {
        this.dataGabarito = dataGabarito;
    }

    public LocalDate getDataResultado() {
        return dataResultado;
    }

    public void setDataResultado(LocalDate dataResultado) {
        this.dataResultado = dataResultado;
    }

    public String getLinkEdital() {
        return linkEdital;
    }

    public void setLinkEdital(String linkEdital) {
        this.linkEdital = linkEdital;
    }

    public List<Participa> getMembros() {
        return membros;
    }

    public void setMembros(List<Participa> membros) {
        this.membros = membros;
    }
    
    
}
