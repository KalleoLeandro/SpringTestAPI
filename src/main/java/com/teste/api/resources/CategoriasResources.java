package com.teste.api.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.teste.api.domain.Categoria;
import com.teste.api.dtos.CategoriaDTO;
import com.teste.api.services.CategoriaService;

/**
 * @author Kalleo
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriasResources
{
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id)
	{
		Categoria obj = categoriaService.findById(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll()
	{		
		List<Categoria> lista = categoriaService.findAll();
		List<CategoriaDTO> listaDTO = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria obj)
	{
		obj = categoriaService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<CategoriaDTO> update(@Valid @PathVariable Integer id, @RequestBody CategoriaDTO objDto)
	{
		Categoria newObj = categoriaService.update(id, objDto);
		return ResponseEntity.ok().body(new CategoriaDTO(newObj));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id)
	{
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

//localhost:8080/endpoint de acesso/id
