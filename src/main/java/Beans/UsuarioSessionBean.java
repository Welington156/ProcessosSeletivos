package Beans;

import Usuario.Usuario;
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

    // <editor-fold  defaultstate="collapsed" desc="Getters/Setters" >
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // </editor-fold>

    private ExternalContext getExternalContext() {
        return facesContext.getExternalContext();
    }

}