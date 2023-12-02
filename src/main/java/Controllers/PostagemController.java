package Beans;

import Postagem.Postagem;
import Postagem.PostagemServiceLocal;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PostagemController {

    @Inject
    private PostagemServiceLocal postagemService;

    private List<Postagem> postagens;

    @PostConstruct
    public void init() {
        // Carregar as postagens ao iniciar o bean
        postagens = postagemService.findPostagens();
    }

    // Getter para postagens
    public List<Postagem> getPostagens() {
        return postagens;
    }
}
