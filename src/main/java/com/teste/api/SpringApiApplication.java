package com.teste.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.teste.api.domain.Categoria;
import com.teste.api.domain.Livro;
import com.teste.api.repositories.CategoriaRepository;
import com.teste.api.repositories.LivroRepository;

@SpringBootApplication
public class SpringApiApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		Categoria c1 = new Categoria(null, "Informática", "Livros de TI");
		
		Livro l1 = new Livro(null, "Java 8", "Deitel", "Lorem Ipsum",c1);
		
		c1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(c1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}

}
