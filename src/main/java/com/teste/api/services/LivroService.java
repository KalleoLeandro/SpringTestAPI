/**
 * 
 */
package com.teste.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.api.domain.Livro;
import com.teste.api.exception.ObjectNotFoundException;

import com.teste.api.repositories.LivroRepository;

/**
 * @author Kalleo
 *
 */

@Service
public class LivroService
{
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id)
	{
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat)
	{
		categoriaService.findById(id_cat);
		
		return livroRepository.findAllByCategoria(id_cat);
	}

	public Livro update(Integer id, Livro obj) 
	{
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return livroRepository.save(newObj);
		
	}

	private void updateData(Livro newObj, Livro obj) 
	{
		newObj.setTitulo(obj.getTitulo());		
		newObj.setNomeAutor(obj.getNomeAutor());
		newObj.setTexto(obj.getTexto());
	}
}
