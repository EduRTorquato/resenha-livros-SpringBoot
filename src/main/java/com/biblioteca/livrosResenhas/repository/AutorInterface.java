package com.biblioteca.livrosResenhas.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.livrosResenhas.model.Autor;

@Repository
public interface AutorInterface extends JpaRepository<Autor, Long> {
	
	public Optional<Autor> findAllByNomeAutor(String nomeAutor);
}
