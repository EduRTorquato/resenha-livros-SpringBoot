package com.biblioteca.livrosResenhas.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long livroId;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String resenha;
	
	private String autor;
	
	@NotNull
	private Date dataLeitura;

	public long getLivroId() {
		return livroId;
	}

	public void setLivroId(long livroId) {
		this.livroId = livroId;
	}

	public String getNome() {
		return nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResenha() {
		return resenha;
	}

	public void setResenha(String resenha) {
		this.resenha = resenha;
	}

	public Date getDataLeitura() {
		return dataLeitura;
	}

	public void setDataLeitura(Date dataLeitura) {
		this.dataLeitura = dataLeitura;
	}
	
}
