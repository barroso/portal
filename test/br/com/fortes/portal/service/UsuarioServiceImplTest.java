package br.com.fortes.portal.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import base.dbunit.DbUnitManager;
import br.com.fortes.portal.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:./WebContent/WEB-INF/config/spring/applicationContext.xml",
								   "file:./WebContent/WEB-INF/config/spring/applicationContext-persistence-test.xml"})
@Transactional
public class UsuarioServiceImplTest {

	private static final String dbUnitDataSet = "test/base/dbunit/xml/UsuarioServiceImplTest.xml";
	
	@Autowired
	DbUnitManager dbUnitManager;
	@Autowired
	UsuarioService service;
	
	@Before
	public void setup() {
		dbUnitManager.cleanAndInsert(dbUnitDataSet);
	}
	
	@Test
	public void deveriaBuscarPorId() {
		Usuario usuario = service.buscaPorId(10L);
		
		assertNotNull("Deveria encontrar usuario", usuario);
		assertEquals("Deveria encontrar usuario 'admin'", "admin", usuario.getLogin());
	}
	
	@Test
	public void deveriaBuscarPorLogin() {
		Usuario tibira = service.buscaPorLogin("tibira");
		
		assertNotNull("Deveria encontrar usuario", tibira);
		assertEquals("id", new Long(40L), tibira.getId());
		assertEquals("Deveria encontrar usuario 'admin'", "tibira", tibira.getLogin());
	}
	
	@Test
	public void deveriaInserirUsuario() {
		
		Usuario novo = new Usuario();
		novo.setLogin("rponte");
		novo.setSenha("secreto");
		
		service.adiciona(novo);
		
		Usuario rponte = service.buscaPorLogin("rponte");
		
		assertNotNull("Deveria inserir um novo usuario", rponte);
	}
	
	@Test
	public void deletarUsuario() {

		service.remove(40L);
		
		Usuario usuarioBuscado = service.buscaPorId(40L);
		
		assertNull(usuarioBuscado);
	}
	
}
