package com.teste.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.api.domain.Categoria;
import com.teste.api.services.CategoriaService;

/**
 * @author Kalleo
 *
 */

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasResources
{
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria>findById(@PathVariable Integer id)
	{
		Categoria obj = categoriaService.findById(id);
		return ResponseEntity.ok().body(obj);		
	}
}

//localhost:8080/endpoint de acesso/id
