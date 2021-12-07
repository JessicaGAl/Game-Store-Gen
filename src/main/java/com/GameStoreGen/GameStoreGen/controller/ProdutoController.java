package com.GameStoreGen.GameStoreGen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GameStoreGen.GameStoreGen.models.ProdutoModel;
import com.GameStoreGen.GameStoreGen.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

	public @Autowired ProdutoRepository produto;

	public @GetMapping("/all") List<ProdutoModel> findAll() {

		return produto.findAll();
	}

	public @PostMapping("/save") ProdutoModel save(@Valid @RequestBody ProdutoModel newProd) {

		return produto.save(newProd);

	}
}