package com.biblioteca.livrosResenhas.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String nomeAutor;
	
	@OneToMany(mappedBy = "autor")
	@JsonIgnoreProperties()
	private List<Livro> livro;
	
	private String origemAutor;
	
	private Date dataNasc;
	
	private Date dataFalesc;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public List<Livro> getLivro() {
		return livro;
	}

	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}

	public String getOrigemAutor() {
		return origemAutor;
	}

	public void setOrigemAutor(String origemAutor) {
		this.origemAutor = origemAutor;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Date getDataFalesc() {
		return dataFalesc;
	}

	public void setDataFalesc(Date dataFalesc) {
		this.dataFalesc = dataFalesc;
	}

	
	
}
