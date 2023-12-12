package usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Stateless
public class UsuarioService implements Serializable, UsuarioServiceLocal{

    @PersistenceContext
    private EntityManager em;


    @Inject
    CredencialServiceLocal credencialService;


    @Override
    public void persist(Usuario usuario) {
        Credencial cr = usuario.getCredencial();
        usuario.setCredencial(credencialService.criarCredencial(cr));
        em.persist(usuario);
    }

    @Override
    public void remover(Usuario usuario) {

        em.remove(usuario);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.id = :id").setParameter("id", id);
        return (Usuario) q.getSingleResult();

    }

    @Override
    public Usuario buscarPorEmail(String email) {
        String consulta = "SELECT u FROM Usuario u JOIN u.credencial c WHERE c.email = :email";
        try {
            return (Usuario) em.createQuery(consulta)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Transactional
    public void atualizarUsuario(Usuario usuario) {
        em.merge(usuario);
    }
    
}
