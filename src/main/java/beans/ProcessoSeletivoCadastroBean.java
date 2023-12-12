package beans;

import usuario.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import processoseletivo.ProcessoSeletivo;
import processoseletivo.ProcessoSeletivoServiceLocal;
import usuario.UsuarioServiceLocal;

@Named
@RequestScoped
public class ProcessoSeletivoCadastroBean implements Serializable {
    
    @Inject
    private ProcessoSeletivoServiceLocal processoSeletivoService;
    
    @Inject
    private UsuarioServiceLocal usuarioService;
    
    @Inject
    private UsuarioSessionBean usuarioSessionBean;
    
    @Inject
    private FacesContext facesContext;
    
    private String dataInicio;
    private String dataFim;
    private String titulo;
    private boolean ativo;
    private Usuario criador;
    private String dataProva;
    private String dataGabarito;
    private String dataResultado;
    private String linkEdital;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public ProcessoSeletivoServiceLocal getProcessoSeletivoService() {
        return processoSeletivoService;
    }

    public void setProcessoSeletivoService(ProcessoSeletivoServiceLocal processoSeletivoService) {
        this.processoSeletivoService = processoSeletivoService;
    }

    public UsuarioServiceLocal getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioServiceLocal usuarioService) {
        this.usuarioService = usuarioService;
    }

    public UsuarioSessionBean getUsuarioSessionBean() {
        return usuarioSessionBean;
    }

    public void setUsuarioSessionBean(UsuarioSessionBean usuarioSessionBean) {
        this.usuarioSessionBean = usuarioSessionBean;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataProva() {
        return dataProva;
    }

    public void setDataProva(String dataProva) {
        this.dataProva = dataProva;
    }

    public String getDataGabarito() {
        return dataGabarito;
    }

    public void setDataGabarito(String dataGabarito) {
        this.dataGabarito = dataGabarito;
    }

    public String getDataResultado() {
        return dataResultado;
    }

    public void setDataResultado(String dataResultado) {
        this.dataResultado = dataResultado;
    }

   

    public String getLinkEdital() {
        return linkEdital;
    }

    public void setLinkEdital(String linkEdital) {
        this.linkEdital = linkEdital;
    }
    //</editor-fold>

    public void cadastrar() throws IOException {
        // Lógica para cadastrar o processo seletivo
        if (criador == null) {
            // Obtenha o criador a partir da sessão do usuário, se não estiver definido
            criador = usuarioSessionBean.getUsuario();
        }

        ProcessoSeletivo novoProcessoSeletivo = new ProcessoSeletivo(LocalDate.parse(dataInicio), LocalDate.parse(dataFim), titulo, ativo, criador, LocalDate.parse(dataProva),LocalDate.parse( dataGabarito), LocalDate.parse(dataResultado), linkEdital, null);
        processoSeletivoService.persist(novoProcessoSeletivo);

        ExternalContext externalContext = facesContext.getExternalContext();
        String path = externalContext.getApplicationContextPath();
        externalContext.redirect(path + "/index.xhtml"); // ajuste o caminho conforme necessário
    }
}
