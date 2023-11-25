package newpackage;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.IdentityStore;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author welin
 */
@Named
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:/ProcessosSeletivosDS",
        callerQuery = "select c.senha from usuario u LEFT JOIN credencial c ON c.id = u.credencial_id "
        + "where c.email = ?",
        groupsQuery = "select c.perfil from usuario u LEFT JOIN credencial c ON c.id = u.credencial_id "
        + "where c.email = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        hashAlgorithmParameters = {
            "Pbkdf2PasswordHash.Iterations=3071",
            "${applicationConfig.dyna}"
        }
)
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                errorPage = "",
                useForwardToLogin = false
        )
)
@FacesConfig
@ApplicationScoped
public class ApplicationConfig {
    public String[] getDyna() {
        return new String[]{
            "Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA512", 
            "Pbkdf2PasswordHash.SaltSizeBytes=64"};
    }
}
