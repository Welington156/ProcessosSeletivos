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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
    
    @PersistenceContext
    private EntityManager entityManager;
    
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
    
    public List<Participa> getMinhasNotas() {
        Usuario usuarioAtual = usuarioSessionBean.getUsuario();

        TypedQuery<Participa> query = entityManager.createQuery(
                "SELECT p FROM Participa p WHERE p.candidato = :usuario", Participa.class);

        query.setParameter("usuario", usuarioAtual);

        return query.getResultList();
    }
    
}
