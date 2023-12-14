/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package processoseletivo;

import java.util.List;
import usuario.Usuario;

/**
 *
 * @author welin
 */
public interface ParticipaServiceLocal {
    
    public List<Participa> findParticipas();
    public void atribuirNota(Long participaId, Float novaNota);
     
    public void atualizarNota(Participa participacao);
}
