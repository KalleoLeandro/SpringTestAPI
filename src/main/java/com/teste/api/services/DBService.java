/**
 * 
 */
package com.teste.api.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.api.domain.Categoria;
import com.teste.api.domain.Livro;
import com.teste.api.repositories.CategoriaRepository;
import com.teste.api.repositories.LivroRepository;

/**
 * @author Kalleo
 *
 */

@Service
public class DBService 
{
	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instaciaDB()
	{
		Categoria c1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria c2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
		Categoria c3 = new Categoria(null, "Biografias", "Livros de Biografias");
		
		Livro l1 = new Livro(null, "Java 8", "Deitel", "Lorem Ipsum",c1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Sommerville", "Lorem Ipsum",c1);
		Livro l3 = new Livro(null, "A Gruta do Tempo", "Edward Packard", "Lorem Ipsum",c2);
		Livro l4 = new Livro(null, "Viagem Além do Espaço", "Edward Packard", "Lorem Ipsum",c2);
		Livro l5 = new Livro(null, "Biblia Sagrada", "Muitos Autores", "Lorem Ipsum",c3);
		
		
		c1.getLivros().addAll(Arrays.asList(l1,l2));
		c2.getLivros().addAll(Arrays.asList(l3,l4));
		c3.getLivros().addAll(Arrays.asList(l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(c1,c2,c3));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
	}
}
