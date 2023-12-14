package postagem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cauaq
 */

@Stateless
public class PostagemService implements PostagemServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Postagem> findPostagens() {
        return entityManager.createNamedQuery("findPostagens", Postagem.class).getResultList();
    }

    @Override
    public void persist(Postagem postagem) {
        entityManager.persist(postagem);
    }

    @Override
    public Postagem findPostagemById(Long id) {
        // Aqui você deve implementar a lógica real para buscar a postagem no banco de dados
        return entityManager.find(Postagem.class, id);
    }

}
