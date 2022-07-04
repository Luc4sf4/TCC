package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Sexo;


@Repository
public interface SexoRepository extends JpaRepository<Sexo, Long> {
	
	@Query (value = "select u from Sexo u where upper(trim(u.description)) like %?1%")
	List<Sexo> buscarPorNome(String description8 );
	
		
	
}
