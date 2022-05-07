package com.teste.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.api.domain.Livro;

/**
 * @author Kalleo
 *
 */

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>
{
	
}
