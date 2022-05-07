package com.teste.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.api.domain.Categoria;

/**
 * @author Kalleo
 *
 */

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>
{
	
}
