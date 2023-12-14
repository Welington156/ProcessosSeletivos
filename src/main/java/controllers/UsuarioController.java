package controllers;



import beans.UsuarioSessionBean;
import usuario.Usuario;
import usuario.UsuarioServiceLocal;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import processoseletivo.Participa;
import processoseletivo.ParticipaService;
import processoseletivo.ProcessoSeletivo;
import processoseletivo.ProcessoSeletivoService;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

    @Inject
    UsuarioServiceLocal usuarioService;
    private String email;

    @Inject
    private UsuarioSessionBean usuarioSessionBean;
    

    
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
