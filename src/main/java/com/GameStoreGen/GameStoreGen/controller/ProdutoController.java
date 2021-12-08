package com.GameStoreGen.GameStoreGen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GameStoreGen.GameStoreGen.models.ProdutoModel;
import com.GameStoreGen.GameStoreGen.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

	public @Autowired ProdutoRepository repository;

	public @GetMapping("/all") List<ProdutoModel> findAll() {

		return repository.findAll();
	}

	@PostMapping("/save")
	public ResponseEntity<ProdutoModel> save(@Valid @RequestBody ProdutoModel newProd) {
		return ResponseEntity.status(201).body(repository.save(newProd));
	}

	@PutMapping("/update")
	public ResponseEntity<ProdutoModel> put(@Valid @RequestBody ProdutoModel produto) {
		return ResponseEntity.status(200).body(repository.save(produto));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}