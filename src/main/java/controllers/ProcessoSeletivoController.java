package controllers;

import processoseletivo.ProcessoSeletivo;
import processoseletivo.ProcessoSeletivoServiceLocal;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
/**
 *
 * @author cauaq
 */
@Named
@RequestScoped
public class ProcessoSeletivoController {

    @Inject
    private ProcessoSeletivoServiceLocal processoSeletivoService;

    private List<ProcessoSeletivo> processosSeletivos;

    @PostConstruct
    public void init() {
        // Carregar os processos seletivos ao iniciar o bean
        processosSeletivos = processoSeletivoService.findProcessosSeletivos();
    }

    // Getter para processos seletivos
    public List<ProcessoSeletivo> getProcessosSeletivos() {
        return processosSeletivos;
    }
}