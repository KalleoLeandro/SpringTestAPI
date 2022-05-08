package com.teste.api.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.teste.api.domain.Livro;
import com.teste.api.dtos.LivrosDTO;
import com.teste.api.services.LivroService;



/**
 * @author Kalleo
 *
 */

@RestController
@RequestMapping(value = "/livros")
public class LivrosResources
{
	@Autowired
	private LivroService livroService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id)
	{
		Livro obj = livroService.findById(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@GetMapping
	public ResponseEntity<List<LivrosDTO>> findAll(@RequestParam(value="categoria", defaultValue = "0") Integer id_cat)
	{
		List<Livro> lista = livroService.findAll(id_cat);
		List<LivrosDTO> listaDTO = lista.stream().map(obj -> new LivrosDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @Valid @RequestBody Livro obj)
	{
		Livro newObj = livroService.update(id, obj); 
		return ResponseEntity.ok().body(newObj);
	}
	
	@PatchMapping(value="/{id}")
	public ResponseEntity<Livro> updatePath(@PathVariable Integer id, @Valid @RequestBody Livro obj)
	{
		Livro newObj = livroService.update(id, obj); 
		return ResponseEntity.ok().body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value="categoria", defaultValue = "0") Integer id_cat,@Valid @RequestBody Livro obj)
	{
		Livro newObj = livroService.create(id_cat, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id)
	{
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
