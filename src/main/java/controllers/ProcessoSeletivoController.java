package controllers;

import beans.UsuarioSessionBean;
import java.time.LocalDate;
import processoseletivo.ProcessoSeletivo;
import processoseletivo.ProcessoSeletivoServiceLocal;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import processoseletivo.Participa;
/**
 *
 * @author cauaq
 */
@Named
@RequestScoped
public class ProcessoSeletivoController {

    @Inject
    private ProcessoSeletivoServiceLocal processoSeletivoService;

    @Inject
    private UsuarioSessionBean usuarioSessionBean;
    
    private List<ProcessoSeletivo> processosSeletivos;
    
    private Long processoId;

    @PostConstruct
    public void init() {
        // Carregar os processos seletivos ao iniciar o bean
        processosSeletivos = processoSeletivoService.findProcessosSeletivos();
    }

    // Getter para processos seletivos
    public List<ProcessoSeletivo> getProcessosSeletivos() {
        return processosSeletivos;
    }
    
     public boolean isCadastrado(Long processoSeletivoId) {
        Long usuarioId = usuarioSessionBean.getUsuario().getId();
        return isParticipante(usuarioId, processoSeletivoId);
    }

    public void toggleCadastro(Long processoSeletivoId) {
        Long usuarioId = usuarioSessionBean.getUsuario().getId();

        if (isParticipante(usuarioId, processoSeletivoId)) {
            // Lógica para descadastrar o usuário do processo seletivo
            processoSeletivoService.descadastrarParticipacao(usuarioId, processoSeletivoId);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Descadastrado com sucesso!", null));
        } else {
            // Lógica para cadastrar o usuário no processo seletivo
            cadastrarParticipacao(usuarioId, processoSeletivoId);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", null));
        }
        // Atualize a lista de processos seletivos
        updateProcessosSeletivos();
    }

    private boolean isParticipante(Long usuarioId, Long processoSeletivoId) {
        // Aqui você deve implementar a lógica real de verificação no banco de dados
        // Retorne true se já estiver participando, false se não estiver
        return processoSeletivoService.isUsuarioParticipante(usuarioId, processoSeletivoId);
    }

    private void cadastrarParticipacao(Long usuarioId, Long processoSeletivoId) {
        // Aqui você deve implementar a lógica real de persistência no banco de dados
        ProcessoSeletivo processoSeletivo = findProcessoSeletivoById(processoSeletivoId);
        Participa participa = new Participa(processoSeletivo, usuarioSessionBean.getUsuario(), LocalDate.now(), 0.0f);
        processoSeletivoService.persistParticipacao(participa);
    }

    private void updateProcessosSeletivos() {
        // Atualize a lista de processos seletivos após cadastrar/descadastrar
        processosSeletivos = processoSeletivoService.findProcessosSeletivos();
    }

    private ProcessoSeletivo findProcessoSeletivoById(Long id) {
        // Simulação: Encontre o processo seletivo pelo ID
        // Aqui você deve implementar a lógica real de busca no banco de dados
        for (ProcessoSeletivo ps : processosSeletivos) {
            if (ps.getId().equals(id)) {
                return ps;
            }
        }
        return null; // Substitua pela lógica real
    }
}