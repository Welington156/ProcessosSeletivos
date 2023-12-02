package Beans;
import Postagem.Postagem;
import Postagem.PostagemServiceLocal;
import Postagem.Publicacao;
import Usuario.Usuario;
import Usuario.UsuarioServiceLocal;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PostagemCadastroBean implements Serializable {
    
    @Inject
    private PostagemServiceLocal postagemService;
    
    @Inject
    private UsuarioServiceLocal usuarioService;
    
    @Inject
    private UsuarioSessionBean usuarioSessionBean;
    
    @Inject
    private FacesContext facesContext;
    
    private String titulo;
    private String datapublicacao;
    private Usuario autor;
    private String conteudo;
    private LocalDate dataedicao;
    private Publicacao publicacao;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">

    public PostagemServiceLocal getPostagemService() {
        return postagemService;
    }

    public void setPostagemService(PostagemServiceLocal postagemService) {
        this.postagemService = postagemService;
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

    public String getDatapublicacao() {
        return datapublicacao;
    }

    public void setDatapublicacao(String datapublicacao) {
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
    
    
    
    //</editor-fold>

    public void cadastrar() throws IOException {
        // Lógica para cadastrar a postagem
        if (autor == null) {
            // Se o autor não foi definido, você pode obter o usuário atual da sessão
            // Isso depende de como você está gerenciando a autenticação e a sessão do usuário
            // Aqui, estou assumindo que você tem um bean de sessão para o usuário logado
            // chamado "usuarioSession". Adapte conforme necessário.
            autor = usuarioSessionBean.getUsuario();
        }

        Postagem novaPostagem = new Postagem(titulo, LocalDate.parse(datapublicacao), autor, conteudo, dataedicao, publicacao);
        System.out.println("Entrou aqui");
        postagemService.persist(novaPostagem);

        ExternalContext externalContext = facesContext.getExternalContext();
        String path = externalContext.getApplicationContextPath();
        externalContext.redirect(path + "/index.xhtml"); // ajuste o caminho conforme necessário
    }
}
