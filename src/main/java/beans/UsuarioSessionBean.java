package beans;

import usuario.Usuario;
import usuario.UsuarioService;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;

@Named
@SessionScoped
public class UsuarioSessionBean implements Serializable {
    
    @Inject
    FacesContext facesContext;

    @Inject
    SecurityContext securityContext;

    
    
    private Usuario usuario;

    public void conectar(Usuario u) {
        setUsuario(u);
    }

    public boolean isAuthenticated() {
        return usuario != null;
    }

    public void desconectar() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.invalidateSession();
        String path = externalContext.getApplicationContextPath();
        externalContext.redirect(path + "/login");
    }
    
    public void salvarAlteracoes() {
    // Lógica para obter o usuário atualizado com as alterações
    Usuario usuarioAtualizado = getUsuario();

    // Chama o serviço para atualizar o usuário no banco de dados
    // Agora, o serviço é acessado diretamente pela página minhaConta.xhtml
    // sem ser injetado no UsuarioSessionBean
    new UsuarioService().atualizarUsuario(usuarioAtualizado);

    // Atualiza o usuário na sessão (opcional, dependendo da sua implementação)
    setUsuario(usuarioAtualizado);
}

    // <editor-fold  defaultstate="collapsed" desc="Getters/Setters" >
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getNome(){
        return (usuario != null) ? usuario.getNome() : null;
    }
    
    public String getEmail() {
        return (usuario != null) ? usuario.getEmail() : null;
    }

    // </editor-fold>

    private ExternalContext getExternalContext() {
        return facesContext.getExternalContext();
    }

}