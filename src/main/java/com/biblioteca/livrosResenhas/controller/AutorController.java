package com.biblioteca.livrosResenhas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.livrosResenhas.model.Autor;
import com.biblioteca.livrosResenhas.repository.AutorInterface;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	AutorInterface autRep;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Autor>> GetAll(){
		return ResponseEntity.ok(autRep.findAll());
	}
	
	@GetMapping("/{nomeAutor}")
	public ResponseEntity<Autor> findAllByNomeAutor(@PathVariable String nomeAutor){
		return autRep.findAllByNomeAutor(nomeAutor).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/Cadastrar")
	public ResponseEntity<Autor> post(@RequestBody Autor autor){
		return ResponseEntity.status(HttpStatus.CREATED).body(autRep.save(autor));
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<Autor> put(@RequestBody Autor autor){
		return ResponseEntity.ok().body(autRep.save(autor));
	}
	
	@DeleteMapping("/apaga/{id}")
	public void delete (@PathVariable Long id) {
		autRep.deleteById(id);
	}
	
	
	
	
}
