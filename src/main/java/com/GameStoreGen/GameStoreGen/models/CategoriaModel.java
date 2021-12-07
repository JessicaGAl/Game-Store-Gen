package com.GameStoreGen.GameStoreGen.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tbl_Categoria")

public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@NotBlank
private String genero;


@Size (min =0,max = 250)
private String descricao;

	
	public Long getId() {
	return id;
	}
	
	public void setId(Long id) {
	this.id = id;
	}

	public String getGenero() {
	return genero;
	}

	public void setGenero(String genero) {	
	this.genero = genero;
	}
	
	public String getDescricao() {
	return descricao;
	}

	public void setDescricao(String descricao) {
	this.descricao = descricao;
	}




}
