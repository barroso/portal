package br.com.fortes.portal.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fortes.portal.model.Usuario;
import br.com.fortes.portal.service.UsuarioService;

@Resource
public class UsuarioController {

	private final UsuarioService usuarioService;
	private final Result result;

	public UsuarioController(UsuarioService usuarioService, Result result) {
		this.usuarioService = usuarioService;
		this.result = result;
	}

	@Path("/usuario/form")
	@Get
	public void form() {
	}

	@Path("/usuario/novo")
	@Post
	public void adiciona(Usuario usuario) {
		usuarioService.adiciona(usuario);
		result.redirectTo(this).index();
	}

	@Path("/usuario")
	@Get
	public List<Usuario> index() {
		return usuarioService.listaTudo();
	}

	@Path("/usuario/edita/{id}")
	@Get
	public Usuario edita(Long id) {
		return usuarioService.buscaPorId(id);
	}

	@Path("/usuario/altera/{usuario.id}")
	@Put
	public void altera(Long id) {
//		Usuario usuario = usuarioService.buscaPorId(id);
//		usuarioService.atualiza(usuario);
		result.redirectTo(this).index();
	}

	@Path("/usuario/deleta/{id}")
	@Delete
	public void deleta(Long id) {
		usuarioService.remove(id);
		result.redirectTo(this).index();
	}
}
