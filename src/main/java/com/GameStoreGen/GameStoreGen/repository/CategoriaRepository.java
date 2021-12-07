package com.GameStoreGen.GameStoreGen.repository;


	import java.util.List;
	import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;
    import com.GameStoreGen.GameStoreGen.models.CategoriaModel;
    
	@Repository
	public interface CategoriaRepository extends JpaRepository <CategoriaModel, Long>{
		 public List<CategoriaModel> findAllByDescricaoContainingIgnoreCase(String algoacolocar);

	}

