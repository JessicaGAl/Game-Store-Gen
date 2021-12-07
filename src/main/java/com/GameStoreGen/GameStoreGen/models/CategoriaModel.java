package com.GameStoreGen.GameStoreGen.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tbl_Categoria")

public class CategoriaModel {

	@Id
	@NotBlank
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
@NotBlank
private String genero;

@NotBlank
@Size (min =0,max = 250)
private String descricao;

@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
private List<ProdutoModel> produtosCriados = new ArrayList<>();

	
	public long getId() {
	return id;
	}
	
	public void setId(long id) {
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

	public List<ProdutoModel> getProdutosCriados() {
		return produtosCriados;
	}

	public void setProdutosCriados(List<ProdutoModel> produtosCriados) {
		this.produtosCriados = produtosCriados;
	}




}

