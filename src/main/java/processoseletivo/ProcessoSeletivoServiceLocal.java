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
    
    List<ProcessoSeletivo> findProcesso();
    void persist(ProcessoSeletivo processoseletivo);
    
}
