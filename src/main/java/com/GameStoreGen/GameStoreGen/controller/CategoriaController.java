package com.GameStoreGen.GameStoreGen.controller;


	import java.util.List;

import javax.validation.Valid;

import com.GameStoreGen.GameStoreGen.models.CategoriaModel;
    import com.GameStoreGen.GameStoreGen.repository.CategoriaRepository;
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

	@RestController
	@RequestMapping("/api/v1/categoria")
	@CrossOrigin("*")
 
	
	public class CategoriaController {
		@Autowired
		private CategoriaRepository repository;
	    
		@GetMapping("/all")
		public ResponseEntity<List<CategoriaModel>> GetAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<CategoriaModel> GetById (@PathVariable long id) {
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
			
		}
		@GetMapping("/descricao/{descricao}")
		public ResponseEntity<List<CategoriaModel>> GetByTitulo (@PathVariable String descricao) {
			return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao)); 
			
		}
		
		@PostMapping("/save")
		public ResponseEntity<CategoriaModel> save(@Valid @RequestBody CategoriaModel newCategoria){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(newCategoria));
		}
		
		@PutMapping("/update")
		public ResponseEntity<CategoriaModel> put (@Valid @RequestBody CategoriaModel categoria) {
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));

		}
		
		@DeleteMapping("/delete/{id}")
		public void delete(@PathVariable(value = "id") Long id) {
			repository.deleteById(id);
		}
		
		
	   

}
