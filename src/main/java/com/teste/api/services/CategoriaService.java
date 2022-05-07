package com.teste.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.api.domain.Categoria;
import com.teste.api.exception.ObjectNotFoundException;
import com.teste.api.repositories.CategoriaRepository;

/**
 * @author Kalleo
 *
 */

@Service
public class CategoriaService 
{
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id)
	{
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
