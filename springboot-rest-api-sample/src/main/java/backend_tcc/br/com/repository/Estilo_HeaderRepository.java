package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.EstiloHeader;


@Repository
public interface Estilo_HeaderRepository  extends JpaRepository<EstiloHeader, Long> {
	
	
	@Query(value = "select u from EstiloHeader u where upper(trim(u.propiedade)) like %?1%")
	List<EstiloHeader>getEstiloHeader (String propiedade);
	
	
	
}

