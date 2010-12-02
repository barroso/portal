package br.com.fortes.portal.model;

import java.util.List;


public class ExtUsuario {
	private int total;
	private List<Usuario> rows;

	public ExtUsuario(List<Usuario> rows) 
	{
		this.rows = rows;
		this.total = rows.size();
	}
}
