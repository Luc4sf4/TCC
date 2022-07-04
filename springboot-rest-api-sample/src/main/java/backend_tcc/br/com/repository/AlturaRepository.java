package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Altura;

@Repository
public interface AlturaRepository extends JpaRepository<Altura, Long> {
	
	@Query(value = "select u from Altura u where upper(trim(u.description )) like %?1%")
	List<Altura> getAltura (String description);

}
