package Usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import java.util.HashMap;
import java.util.Map;

public class CredencialService implements CredencialServiceLocal {

    @PersistenceContext
    EntityManager em;

    @Inject
    Pbkdf2PasswordHash passwordHasher;

    @Override
    public Credencial criarCredencial(String email, String senha, Perfil perfil) {
        
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3071");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        passwordHasher.initialize(parameters);

        Credencial newCredential = new Credencial(
                email,
                passwordHasher.generate(senha.toCharArray()),
                perfil);
        
        em.persist(newCredential);
        return newCredential;
    }

    @Override
    public Credencial criarCredencial(Credencial credencial) {
        Credencial newCredential = criarCredencial(
                credencial.getEmail(),
                credencial.getSenha(),
                credencial.getPerfil());
        em.persist(newCredential);
        return newCredential;
    }

}
