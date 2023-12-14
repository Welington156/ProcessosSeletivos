package controllers;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
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

    // Outros métodos conforme necessário, como atribuirNota, etc.
}