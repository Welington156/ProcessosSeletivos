package controllers;



import Usuario.Usuario;
import Usuario.UsuarioServiceLocal;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

    @Inject
    UsuarioServiceLocal usuarioService;
    private String email;

    private Usuario usuario;


    public Usuario getUsuario() {
        if(usuario == null) usuario = usuarioService.buscarPorEmail(email);
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
