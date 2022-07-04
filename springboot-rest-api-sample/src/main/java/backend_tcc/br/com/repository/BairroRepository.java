package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Bairro;



@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long>  {

	@Query (value = "select u from Bairro u where upper(trim(u.description)) like %?1%")
	List<Bairro> getBairro(String description );


}
