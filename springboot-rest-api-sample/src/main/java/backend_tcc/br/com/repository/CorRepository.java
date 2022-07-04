package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Cor;

@Repository
public interface CorRepository extends JpaRepository<Cor, Long>  {

		@Query (value = "select u from Cor u where upper(trim(u.description)) like %?1%")
		List<Cor> getCor(String description );
	
}
