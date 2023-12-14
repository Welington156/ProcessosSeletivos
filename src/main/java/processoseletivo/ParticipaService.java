/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package processoseletivo;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import usuario.Usuario;

/**
 *
 * @author welin
 */
@Stateless
public class ParticipaService implements ParticipaServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;
    
    public ParticipaService(){
    }

    @Override
    public List<Participa> findParticipas() {
        return entityManager.createNamedQuery("Participa.findParticipa", Participa.class).getResultList();
    }
    
    
    @Override
    public void atribuirNota(Long participaId, Float novaNota) {
            Participa participa = entityManager.find(Participa.class, participaId);

            if (participa != null) {
                participa.setNota(novaNota);
                entityManager.merge(participa);
            } else {
                // Lógica para lidar com o participa não encontrado, se necessário
                throw new EntityNotFoundException("Participa não encontrado com ID: " + participaId);
            }
}
    public void atualizarNota(Participa participacao) {
    entityManager.merge(participacao);
}

    
    
   
    
}
