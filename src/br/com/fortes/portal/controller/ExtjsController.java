package br.com.fortes.portal.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.fortes.portal.model.ExtUsuario;
import br.com.fortes.portal.model.Usuario;

@Resource
public class ExtjsController {
	
	private final Result result;
	
	public ExtjsController(Result result) {
		this.result   = result;
	}
	
	@Path("/extjs/crud")
	public void crud() {
		
	}
	
	@Path("/extjs/grid/dados.json")
	public void grid() {
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		Usuario usuario1 = new Usuario();
		usuario1.setEmail("email@email.com");
		usuario1.setLogin("login");
		usuario1.setSenha("12345");
		
		Usuario usuario2 = new Usuario();
		usuario2.setEmail("joao@gmail.com");
		usuario2.setLogin("joao");
		usuario2.setSenha("987987");
		
		lista.add(usuario1);
		lista.add(usuario2);

		ExtUsuario extUsuario = new ExtUsuario(lista);
		
		result.use(json()).withoutRoot().from(extUsuario).include("rows").serialize();
	}
//	
//	@Path("/extjs/form/{usuario.id}/dados.json")
//	public void formulario(Usuario usuario) {
//		if(usuario != null) {
//			usuario = (Usuario) dao.selectById(usuario);
//		}
//		result.use(ExtJSJson.class).from(usuario)
//			.success(usuario != null ? true : false).serialize();
//	}
//	
//	@Path("/extjs/form/salvar")
//	public void salvar(Usuario usuario) {
//		if(usuario != null) {
//			if(usuario.getId() == null) {
//				usuario = (Usuario) dao.insert(usuario);
//			} else {
//				usuario = (Usuario) dao.update(usuario);
//			}
//		}
//		result.use(ExtJSJson.class).from(usuario)
//			.success(usuario != null ? true : false).serialize();
//	}
//	
//	@Path("/extjs/form/excluir/{usuario.id}")
//	public void excluir(Usuario usuario) {
//		if(usuario != null && usuario.getId() != null) {
//			dao.remove(usuario);
//			usuario = null;
//		} 
//		result.use(ExtJSJson.class).from(usuario)
//			.success(usuario != null ? true : false)
//				.serialize();
//	}
//	
//	@Path("/extjs/combobox/grupos/dados.json")
//	public void combobox() {
//		List<BaseEntity> lista = dao.selectByNamedQuery("selectGrupos");
//		
//		int selectedItem = lista.size() != 0 ? lista.size() - 1 : 0;
//		
//		result.use(ExtJSJson.class).from(lista)
//			.selected(lista.get(selectedItem)
//					.getId()).serialize();
//	}
//	
}
