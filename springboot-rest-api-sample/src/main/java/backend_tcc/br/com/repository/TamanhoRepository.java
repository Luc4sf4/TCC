package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Tamanho;

@Repository
public interface TamanhoRepository extends JpaRepository<Tamanho, Long> {


	@Query (value = "select u from Tamanho u where upper(trim(u.description)) like %?1%")
	List<Tamanho> getEstado(String description);
	
	
	
}
