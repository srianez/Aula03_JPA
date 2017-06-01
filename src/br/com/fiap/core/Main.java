package br.com.fiap.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Forum;
import br.com.fiap.entity.Usuario;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("aula3"); 
		
		EntityManager em = entityManagerFactory.createEntityManager();
		
		ForumHelper fHelper = new ForumHelper(em);
		
		Forum forum = new Forum();
		forum.setAssunto("Java Persistence");
		forum.setDescricao("Descrição de JPA");
		
		Usuario usuario = new Usuario();
		usuario.setNome("Silas");
        usuario.setEmail("silaskt@yahoo.com.br");
		
		//System.out.println(fHelper.salvar(forum));
        fHelper.salvar(forum);
		fHelper.adicionarUsuario(forum.getId(), usuario);

	}

}
