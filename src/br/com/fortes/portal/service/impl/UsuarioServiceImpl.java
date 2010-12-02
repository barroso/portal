package br.com.fortes.portal.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import br.com.fortes.portal.model.Usuario;
import br.com.fortes.portal.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listaTudo() {
		return entityManager.createQuery("from Usuario").getResultList();
	}
	
	public Usuario buscaPorId(Long id) {
		return entityManager.find(Usuario.class, id);
	}

	public Usuario buscaPorLogin(String login) {
		Usuario usuario = (Usuario) entityManager
			.createQuery("from Usuario u where u.login = :login")
			.setParameter("login", login)
			.getSingleResult();
		return usuario;
	}

	public void adiciona(Usuario usuario) {
		entityManager.persist(usuario);
	}

	public void atualiza(Usuario usuario) {
		entityManager.merge(usuario);		
	}

	public void remove(Usuario usuario) {
		entityManager.remove(entityManager.merge(usuario));		
	}
	
	public void remove(Long id) {
		Usuario usuario = new Usuario(id);
		remove(usuario);		
	}

	

}
