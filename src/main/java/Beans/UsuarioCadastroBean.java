/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;


import Usuario.Credencial;
import Usuario.Perfil;
import Usuario.Usuario;
import Usuario.UsuarioServiceLocal;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cauaq
 */
@Named
@RequestScoped
public class UsuarioCadastroBean {
    
    @Inject UsuarioServiceLocal usuarioService;
    
    @Inject
    FacesContext facesContext;
    
    private String nome;
    private String email;
    private String password;
    private String nascimento;
    private Long telefone;
    private Perfil perfil;

    
    
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public UsuarioServiceLocal getUsuarioService(){
        return usuarioService;
        
    }

    public void setUsuarioService(UsuarioServiceLocal usuarioService) {
        this.usuarioService = usuarioService;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    
    public void setPerfil(Perfil perfil) {    
        this.perfil = perfil;
    }

    //</editor-fold>
    public void cadastrar() throws IOException {
        if(perfil == null){
            perfil = Perfil.CANDIDATO;
        }
        Credencial user = new Credencial(email, password,perfil);
        Usuario novo = new Usuario(nome,LocalDate.parse(nascimento), telefone, user);
        
        usuarioService.persist(novo);
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String path = externalContext.getApplicationContextPath();
        externalContext.redirect(path + "/login");
        externalContext.invalidateSession();
    }
    
}
