package com.biblioteca.livrosResenhas.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	
	@NotNull
	private Date dataInicioLeitura;
	
	private Date dataFinalLeitura;
	
	public Long numPag;	
	
	public Long numTotal;
	
	@ManyToOne()
	@JsonIgnoreProperties("livro")
	private Autor autor;

	public Long getNumPag() {
		return numPag;
	}

	public void setNumPag(Long numPag) {
		this.numPag = numPag;
	}

	public Date getDataInicioLeitura() {
		return dataInicioLeitura;
	}

	public void setDataInicioLeitura(Date dataInicioLeitura) {
		this.dataInicioLeitura = dataInicioLeitura;
	}

	public Date getDataFinalLeitura() {
		return dataFinalLeitura;
	}

	public void setDataFinalLeitura(Date dataFinalLeitura) {
		this.dataFinalLeitura = dataFinalLeitura;
	}

	public long getLivroId() {
		return livroId;
	}

	public void setLivroId(long livroId) {
		this.livroId = livroId;
	}

	public String getNome() {
		return nome;
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


	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
}
