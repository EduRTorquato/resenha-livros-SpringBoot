package com.biblioteca.livrosResenhas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.livrosResenhas.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	public List<Livro> findAll();
	public Optional<Livro> findByNome(String nome);
	public Optional<Livro> findById(Long id);
	
}
