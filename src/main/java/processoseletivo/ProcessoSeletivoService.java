package processoseletivo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author welin
 */
@Stateless
public class ProcessoSeletivoService
        implements ProcessoSeletivoServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProcessoSeletivo> findProcessosSeletivos() {
        return entityManager.createNamedQuery("findProcessoSeletivo", ProcessoSeletivo.class).getResultList();
    }

    @Override
    public void persist(ProcessoSeletivo processoseletivo) {
        entityManager.persist(processoseletivo);
    }

    public boolean isUsuarioParticipante(Long usuarioId, Long processoSeletivoId) {
        // Implemente a lógica real para verificar se o usuário já está participando do processo seletivo
        // Você pode usar consultas JPQL ou outros meios de acesso ao banco de dados
        // Retorne true se já estiver participando, false se não estiver
        // Exemplo (usando JPQL):
        Long count = entityManager.createQuery("SELECT COUNT(p) FROM Participa p WHERE p.candidato.id = :usuarioId AND p.processoSeletivo.id = :processoSeletivoId", Long.class)
                .setParameter("usuarioId", usuarioId)
                .setParameter("processoSeletivoId", processoSeletivoId)
                .getSingleResult();
        return count > 0;
    }
    public void persistParticipacao(Participa participa) {
    // Implemente a lógica real para persistir a participação no banco de dados
    entityManager.persist(participa);
}
    public void descadastrarParticipacao(Long usuarioId, Long processoSeletivoId) {
    // Implemente a lógica real para descadastrar a participação do usuário no processo seletivo
    // Exemplo (usando JPQL):
    entityManager.createQuery("DELETE FROM Participa p WHERE p.candidato.id = :usuarioId AND p.processoSeletivo.id = :processoSeletivoId")
            .setParameter("usuarioId", usuarioId)
            .setParameter("processoSeletivoId", processoSeletivoId)
            .executeUpdate();
}
}
