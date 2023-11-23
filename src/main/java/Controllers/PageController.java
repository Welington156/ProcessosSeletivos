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

    public void goToHome() throws IOException {
        redirect("/");
    }

    public void goToLogin() throws IOException {
        redirect("/login");
    }

    public void goToCadastrar() throws IOException {
        redirect("/cadastrar");
    }
    
    public void redirect(String url) throws IOException {
        externalContext.redirect(
                externalContext.getApplicationContextPath() + url
        );
    }
}
