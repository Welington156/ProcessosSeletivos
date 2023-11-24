/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Usuario;

/**
 *
 * @author welin
 */
public interface UsuarioServiceLocal {
    void persist(Usuario usuario);

    void remover(Usuario usuario);
    
    Usuario buscarUsuario(Long id);
    
    public Usuario buscarPorEmail(String email);
}
