package com.teste.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.teste.api.domain.Categoria;
import com.teste.api.dtos.CategoriaDTO;
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
	
	public List<Categoria> findAll()
	{
		return categoriaRepository.findAll();		
	}
	
	public Categoria create(Categoria obj)
	{
		obj.setId(null);
		return categoriaRepository.save(obj);
		
	}

	public Categoria update(Integer id, CategoriaDTO objDto) 
	{
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return categoriaRepository.save(obj);
	}

	public void delete(Integer id) 
	{
		findById(id);
		try
		{
			categoriaRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) 
		{
			throw new com.teste.api.exception.DataIntegrityViolationException("Objeto não pode ser deletado, pois está vinculado a outro elemento");
		}
	}
	
	
}
