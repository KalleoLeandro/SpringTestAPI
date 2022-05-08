package com.teste.api.dtos;

import java.io.Serializable;

import com.teste.api.domain.Livro;

/**
 * @author Kalleo
 *
 */
public class LivrosDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	
	public LivrosDTO(Livro obj)
	{
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
	}
	
	public LivrosDTO()
	{
		
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	
	
}
