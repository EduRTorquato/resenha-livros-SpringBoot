package com.biblioteca.livrosResenhas.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.biblioteca.livrosResenhas.model.Livro;
import com.biblioteca.livrosResenhas.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
@CrossOrigin("*")
public class LivroController {

	@Autowired
	private LivroRepository livroR;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Livro>> GetAll(){
		return ResponseEntity.ok(livroR.findAll());
	}
	
	@GetMapping("/nome/{nome}")
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
	
	@PostMapping("/salvar")
	public ResponseEntity<Livro> salvaResenha(@RequestBody Livro livro){
		return ResponseEntity.status(HttpStatus.OK).body(livroR.save(livro));
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<Livro> alteraResenha(@RequestBody Livro livro){
		return ResponseEntity.status(HttpStatus.OK).body(livroR.save(livro));
	}
	
	@DeleteMapping("/delete/{livroId}")
	public void delete(@PathVariable long livroId) {
		livroR.deleteById(livroId);
	}

}
