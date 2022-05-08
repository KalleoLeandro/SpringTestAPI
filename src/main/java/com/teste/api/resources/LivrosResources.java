package com.teste.api.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
