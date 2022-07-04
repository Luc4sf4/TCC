package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Parametros;


@Repository
public interface ParametroRepository extends JpaRepository<Parametros, Long> {

	
	@Query (value = "select u from Parametros u where upper(trim(u.sitetitle)) like %?1%")
	List<Parametros>getEveryParametro(String sitetitle);
	
	
}
