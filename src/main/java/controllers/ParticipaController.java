package controllers;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import processoseletivo.Participa;
import processoseletivo.ParticipaService;
import processoseletivo.ParticipaServiceLocal;

@Named
@RequestScoped
public class ParticipaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ParticipaServiceLocal participaService;

    private List<Participa> participacoes;

    @PostConstruct
    public void init() {
        participacoes = participaService.findParticipas();
    }

    public List<Participa> getParticipacoes() {
        return participacoes;
    }
    
    public void salvarNota(Participa participacao) {
        // Aqui você deve implementar a lógica real de atualização da nota no banco de dados
        // Certifique-se de substituir atualizarNota pelo método real em seu serviço
        participaService.atualizarNota(participacao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nota atualizada com sucesso!", null));
    }

    // Outros métodos conforme necessário, como atribuirNota, etc.
}