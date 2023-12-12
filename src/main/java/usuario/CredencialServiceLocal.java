/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package usuario;

/**
 *
 * @author welin
 */
public interface CredencialServiceLocal {
    Credencial criarCredencial(String email, String senha, Perfil perfil);
    Credencial criarCredencial(Credencial credencial);
    
}
