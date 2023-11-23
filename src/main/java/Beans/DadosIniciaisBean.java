/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import Postagem.Postagem;
import Postagem.Publicacao;
import ProcessoSeletivo.Participa;
import ProcessoSeletivo.ProcessoSeletivo;
import Usuario.Credencial;
import Usuario.Perfil;
import Usuario.Usuario;
import java.time.LocalDate;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cauaq
 */


@Startup
@Singleton
public class DadosIniciaisBean implements DadosIniciaisBeanLocal {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    @PostConstruct
    public void init() {
        carregarDados();
    }

    private void carregarDados() {
        Credencial credencial1 = new Credencial("email1@example.com", "senha1", Perfil.CANDIDATO);
        Usuario usuario1 = new Usuario("Nome1", LocalDate.of(1990, 1, 1), 123456789l,credencial1);
        
        
        Credencial credencial2 = new Credencial("email2@example.com", "senha2", Perfil.ADMINISTRADOR);
        Usuario usuario2 = new Usuario("Nome2",  LocalDate.of(1995, 5, 5), 987654321l,credencial2);
        

        entityManager.persist(usuario1);
        entityManager.persist(usuario2);
        
        // Criação de Processo Seletivo
        ProcessoSeletivo processo1 = new ProcessoSeletivo(
                LocalDate.of(2023, 1, 1), 
                LocalDate.of(2023, 2, 1),
                "Processo 1", 
                true, 
                usuario1,
                LocalDate.of(2023, 1, 15), 
                LocalDate.of(2023, 2, 1), 
                LocalDate.of(2023, 2, 15),
                "Edital 1", 
                null // membros serão adicionados posteriormente
        );
        ProcessoSeletivo processo2 = new ProcessoSeletivo(
                LocalDate.of(2023, 3, 1), 
                LocalDate.of(2023, 4, 1),
                "Processo 2", 
                true, 
                usuario2,
                LocalDate.of(2023, 3, 15), 
                LocalDate.of(2023, 4, 1), 
                LocalDate.of(2023, 4, 15),
                "Edital 2", 
                null // membros serão adicionados posteriormente
        );

        entityManager.persist(processo1);
        entityManager.persist(processo2);

        // Criação de Postagens
        Participa participa1 = new Participa(processo1, usuario1, LocalDate.now(), 0.0f);
        Participa participa2 = new Participa(processo2, usuario2, LocalDate.now(), 0.0f);


        processo1.setMembros(Arrays.asList(participa1));
        processo2.setMembros(Arrays.asList(participa2));
        
        entityManager.persist(processo1);
        entityManager.persist(processo2);
        
        // Criação de Postagens
        Postagem postagem1 = new Postagem(
                "Título da Postagem 1",
                LocalDate.of(2023, 1, 10),
                usuario1,
                "Conteúdo da Postagem 1",
                null,
                Publicacao.EDITAL
        );

        Postagem postagem2 = new Postagem(
                "Título da Postagem 2",
                LocalDate.of(2023, 2, 15),
                usuario2,
                "Conteúdo da Postagem 2",
                null,
                Publicacao.EDITAL
        );

        entityManager.persist(postagem1);
        entityManager.persist(postagem2);
    }
}
