package com.biblioteca.livrosResenhas.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.livrosResenhas.model.Livro;
import com.biblioteca.livrosResenhas.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
@CrossOrigin("*")
public class LivroController {

	@Autowired
	private LivroRepository livroR;
	
	@GetMapping("/all")
	public ResponseEntity<List<Livro>> GetAll(){
		return ResponseEntity.ok(livroR.findAll());
	}
	
	@GetMapping("/name/{nome}")
	public ResponseEntity<Livro> GetByNome(@PathVariable String nome){
		return livroR.findByNome(nome).map(livro -> ResponseEntity.ok(livro))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/autor/{autor}")
	public ResponseEntity<List<Livro>> GetByAutor(@PathVariable String autor){
		return ResponseEntity.ok(livroR.findAllByAutor(autor));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Livro>> GetById(@PathVariable Long id){
		return ResponseEntity.ok(livroR.findById(id));
	}
	
	
	
	
}
