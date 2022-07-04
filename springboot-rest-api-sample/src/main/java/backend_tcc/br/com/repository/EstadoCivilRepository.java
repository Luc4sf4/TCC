package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.EstadoCivil;



@Repository
public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long> {
	
	@Query (value = "select u from EstadoCivil u where upper(trim(u.description)) like %?1%")
	List<EstadoCivil> getEstado(String description );

}
