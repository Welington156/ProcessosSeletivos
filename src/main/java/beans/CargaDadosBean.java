/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import postagem.Postagem;
import postagem.Publicacao;
import processoseletivo.Participa;
import processoseletivo.ProcessoSeletivo;
import usuario.Credencial;
import usuario.Perfil;
import usuario.Usuario;
import usuario.UsuarioServiceLocal;
import java.time.LocalDate;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cauaq
 */
@Startup
@Singleton
public class CargaDadosBean
        implements CargaDadosBeanLocal {

    @Inject
    UsuarioServiceLocal usuarioService;

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private UsuarioCadastroBean usuarioCadastroBean;

    @Override
    @PostConstruct
    public void init() {
        carregarDados();
    }

    private void carregarDados() {
        Usuario usuario1 = cadastrarUsuario("Emilly", "candidato@gmail.com", "1234", Perfil.CANDIDATO, LocalDate.of(1990, 1, 1), 123456789L);
        Usuario usuario2 = cadastrarUsuario("Caua", "admin@gmail.com", "1234", Perfil.ADMINISTRADOR, LocalDate.of(1995, 5, 5), 987654321L);
        Usuario usuario3 = cadastrarUsuario("Junio", "editor@gmail.com", "1234", Perfil.EDITOR, LocalDate.of(1999, 10, 5), 987654321L);
        
        // Criação de Processo Seletivo
        ProcessoSeletivo processo1 = new ProcessoSeletivo(
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 2, 1),
                "Processo Seletivo Ensino Médio 2023",
                true,
                usuario2,
                LocalDate.of(2023, 1, 15),
                LocalDate.of(2023, 2, 1),
                LocalDate.of(2023, 2, 15),
                "ifnmg.com/processo1/edital3",
                null // membros serão adicionados posteriormente
        );
        ProcessoSeletivo processo2 = new ProcessoSeletivo(
                LocalDate.of(2023, 3, 1),
                LocalDate.of(2023, 4, 1),
                "Processo Seletivo Superior 2023",
                true,
                usuario2,
                LocalDate.of(2023, 3, 15),
                LocalDate.of(2023, 4, 1),
                LocalDate.of(2023, 4, 15),
                "ifnmg.com/processo5/edital2",
                null // membros serão adicionados posteriormente
        );
        
        ProcessoSeletivo processo3 = new ProcessoSeletivo(
                LocalDate.of(2023, 4, 4),
                LocalDate.of(2023, 5, 6),
                "Processo Seletivo Integrado 2023",
                true,
                usuario2,
                LocalDate.of(2023, 1, 15),
                LocalDate.of(2023, 2, 1),
                LocalDate.of(2023, 2, 15),
                "ifnmg.com/processo8/edital7",
                null // membros serão adicionados posteriormente
        );
        Postagem postagem = new Postagem(
            "Título: Pesquisadores Anunciam Descoberta de Nova Espécie Marinha no Fundo do Oceano",
            LocalDate.now(),
            usuario3,
            "Numa expedição submarina recente, cientistas fizeram uma descoberta fascinante no fundo do oceano: uma nova espécie de vida marinha nunca antes catalogada. Os pesquisadores, pertencentes a uma equipe internacional de biólogos marinhos, encontraram a espécie a uma profundidade recorde de 3.000 metros.",
            null,
            Publicacao.NOTICIA
    );
        entityManager.persist(postagem);
        entityManager.persist(processo1);
        entityManager.persist(processo2);
        entityManager.persist(processo3);
 
 
        // Criação de Postagens
        Participa participa1 = new Participa(processo1, usuario1, LocalDate.now(), 100.0f);
        Participa participa2 = new Participa(processo2, usuario1, LocalDate.now(), 50.75f);
//
        processo1.setMembros(Arrays.asList(participa1));
        processo2.setMembros(Arrays.asList(participa2));
//
        entityManager.persist(processo1);
        entityManager.persist(processo2);

        // Criação de Postagens
        Postagem postagem1 = new Postagem(
                "IFNMG Anuncia Novo Edital de Processo Seletivo!",
                LocalDate.of(2023, 1, 10),
                usuario3,
                "O Instituto Federal do Norte de Minas Gerais (IFNMG) surpreendeu a comunidade acadêmica ao lançar oficialmente um novo edital de processo seletivo. Com oportunidades diversas, o edital promete movimentar o cenário educacional na região. Estudantes e profissionais já estão ansiosos para concorrer às vagas disponíveis.",
                null,
                Publicacao.EDITAL
        );

        Postagem postagem2 = new Postagem(
                "Edital Fresquinho: IFNMG Divulga Processo Seletivo",
                LocalDate.of(2023, 2, 15),
                usuario3,
                "Grandes expectativas cercam o lançamento do mais recente edital do Instituto Federal do Norte de Minas Gerais (IFNMG). Com oportunidades para diversas áreas, o edital abre portas para novos talentos e promete impulsionar a educação na região. Os interessados já podem começar os preparativos para concorrer às vagas.",
                null,
                Publicacao.EDITAL
        );

        entityManager.persist(postagem1);
        entityManager.persist(postagem2);
    }

    private Usuario cadastrarUsuario(String nome, String email, String password, Perfil perfil, LocalDate nascimento, long telefone) {
        Credencial credencial = new Credencial(email, password, perfil);
        Usuario usuario = new Usuario(nome, nascimento, telefone, credencial);
        
        // Chame o método cadastrar() do UsuarioCadastroBean
        usuarioCadastroBean.setEmail(email);
        usuarioCadastroBean.setPassword(password);
        usuarioCadastroBean.setPerfil(perfil);
        usuarioCadastroBean.setNome(nome);
        usuarioCadastroBean.setNascimento(nascimento.toString());
        usuarioCadastroBean.setTelefone(telefone);

        usuarioService.persist(usuario);

        return usuario;
    }
}
