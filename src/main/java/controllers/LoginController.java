package controllers;


import beans.UsuarioSessionBean;
import usuario.Credencial;
import usuario.Perfil;
import usuario.Usuario;
import usuario.UsuarioServiceLocal;
import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import static javax.security.enterprise.AuthenticationStatus.SEND_FAILURE;
import static javax.security.enterprise.AuthenticationStatus.SUCCESS;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author welin
 */
@Named
@RequestScoped
public class LoginController {

    @Inject
    PageController pageController;

    @NotEmpty
    private String email ;

    @NotEmpty
    private String password ;

    @Inject
    FacesContext facesContext;

    @Inject
    SecurityContext securityContext;
    
    @Inject UsuarioServiceLocal usuarioService;

    @Inject UsuarioSessionBean usuarioSession;
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //</editor-fold>

    public void execute() throws IOException {
        switch (processAuthentication()) {
            case SEND_CONTINUE:
                saveUserInSession();
                facesContext.responseComplete();
                break;
            case SEND_FAILURE:
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Credentials", null));
                break;
            case SUCCESS:
                saveUserInSession();
                redirectToAppropriatePage();
                break;
        }
    }

private void redirectToAppropriatePage() throws IOException {
    Usuario usuario = usuarioService.buscarPorEmail(email);
    Credencial credencial = usuario.getCredencial(); 
    Perfil perfil = credencial.getPerfil();
    
    pageController.goToConta();
    
}


private void saveUserInSession() {
        usuarioSession.conectar(usuarioService.buscarPorEmail(email));
    }

    private AuthenticationStatus processAuthentication() {
        ExternalContext ec = getExternalContext();
        return securityContext.authenticate(
                (HttpServletRequest) ec.getRequest(),
                (HttpServletResponse) ec.getResponse(),
                AuthenticationParameters.withParams().credential(new UsernamePasswordCredential(email, password)));
    }

    private ExternalContext getExternalContext() {
        return facesContext.getExternalContext();
    }
}
