package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Categoria;



@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	@Query (value = "select u from Categoria u where upper(trim(u.description)) like %?1%")
	List<Categoria> getCategoria(String description );
}
