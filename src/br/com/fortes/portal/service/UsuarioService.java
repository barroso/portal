package br.com.fortes.portal.service;

import java.util.List;

import br.com.fortes.portal.model.Usuario;

public interface UsuarioService {

	public List<Usuario> listaTudo();
	public Usuario buscaPorId(Long id);
	public Usuario buscaPorLogin(String login);
	public void adiciona(Usuario usuario);
	public void atualiza(Usuario usuario);
	public void remove(Usuario usuario);
	public void remove(Long id);

}
