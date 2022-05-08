package com.teste.api.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.teste.api.domain.Livro;

/**
 * @author Kalleo
 *
 */
public class LivrosDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	
	@NotEmpty(message = "Campo título é requerido")
	@Length(min = 3, max = 100, message = "O campo título deve ter entre 3 e 100 caracteres")
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
