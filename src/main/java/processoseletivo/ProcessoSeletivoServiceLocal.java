/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package processoseletivo;

import java.util.List;

/**
 *
 * @author welin
 */
public interface ProcessoSeletivoServiceLocal {
    
    List<ProcessoSeletivo> findProcessosSeletivos();
    void persist(ProcessoSeletivo processoseletivo);
    public boolean isUsuarioParticipante(Long usuarioId, Long processoSeletivoId);
    public void persistParticipacao(Participa participa);
    public void descadastrarParticipacao(Long usuarioId, Long processoSeletivoId);
    public ProcessoSeletivo findProcessoSeletivoById(Long id);
}
