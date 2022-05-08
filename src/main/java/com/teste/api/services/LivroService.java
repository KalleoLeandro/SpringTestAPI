/**
 * 
 */
package com.teste.api.services;

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
	
	public Livro findById(Integer id)
	{
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Livro.class.getName()));
	}
}
