/**
 * 
 */
package com.teste.api.domain;

import java.util.Objects;

/**
 * @author Kalleo
 *
 */

public class Livro 
{
	private Integer id;
	private String titulo;
	private String nomeAutor;
	private String texto;
	
	private Categoria categoria;

	public Livro(Integer id, String titulo, String nomeAutor, String texto, Categoria categoria) 
	{	
		this.id = id;
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
		this.categoria = categoria;
	}

	public Livro()
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

	public String getNomeAutor()
	{
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) 
	{
		this.nomeAutor = nomeAutor;
	}

	public String getTexto() 
	{
		return texto;
	}

	public void setTexto(String texto)
	{
		this.texto = texto;
	}

	public Categoria getCategoria() 
	{
		return categoria;
	}

	public void setCategoria(Categoria categoria) 
	{
		this.categoria = categoria;
	}
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}	
	
}
