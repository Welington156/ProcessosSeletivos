package controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class PageController {

    private final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    //<editor-fold defaultstate="collapsed" desc="Paginas">
    public void goToHome() throws IOException {
        redirect("/");
    }

    public void goToLogin() throws IOException {
        redirect("/login");
    }

    public void goToCadastrar() throws IOException {
        redirect("/cadastrar");
    }
    
    public void goToConta() throws IOException {
        redirect("/usuario/minhaConta.xhtml");
    }
    
    public void goToAdminCadastro() throws IOException {
        redirect("/admin/cadastrar.xhtml");
    }

    public void goToCadastrarPostagem() throws IOException {
        redirect("/noticias/cadastrar.xhtml");
    }
    
    public void goToCadastrarProcesso() throws IOException{
        redirect("/processosseletivos/cadastrar.xhtml");
    }
    public void goToAtribuirNota() throws IOException{
        redirect("/processosseletivos/participa.xhtml");
    }
    
    
    public String getVisualizarPostagemUrl(Long postagemId) {
        return "noticias/view.xhtml?id=" + postagemId;
    }

    public String getVisualizarProcessoSeletivoUrl(Long processoSeletivoId) {
        return "processosseletivos/view.xhtml?id=" + processoSeletivoId;
        
    }
    
    //</editor-fold>

    public void redirect(String url) throws IOException {
        System.out.println("Redirecionando para: " + url);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.redirect(
                externalContext.getApplicationContextPath() + url
        );
    }
}
