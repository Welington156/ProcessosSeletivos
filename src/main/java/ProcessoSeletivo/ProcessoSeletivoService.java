package ProcessoSeletivo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author welin
 */

@Stateless
public class ProcessoSeletivoService implements ProcessoSeletivoServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProcessoSeletivo> findProcesso() {
        return entityManager.createNamedQuery("findProcessoSeletivo", ProcessoSeletivo.class).getResultList();
    }

    @Override
    public void persist(ProcessoSeletivo processoseletivo) {
        entityManager.persist(processoseletivo);
    }

    // Adicione outros métodos conforme necessário

}
