package postagem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cauaq
 */
@Local
public interface PostagemServiceLocal {
    
    List<Postagem> findPostagens();
    
    void persist(Postagem postagem);
    
    // Adicione outros métodos conforme necessário
}
