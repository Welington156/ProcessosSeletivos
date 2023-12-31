package controllers;

import postagem.Postagem;
import postagem.PostagemServiceLocal;

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
    
    public Postagem getPostagemById(Long id) {
        // Aqui você deve implementar a lógica real para obter a postagem pelo ID
        return postagemService.findPostagemById(id);
    }
    
}
