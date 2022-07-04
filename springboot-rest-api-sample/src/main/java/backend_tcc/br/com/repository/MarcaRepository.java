package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Marca;



@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{
	
	@Query (value = "select u from Marca u where upper(trim(u.description)) like %?1%")
	List<Marca> getMarca(String marc);

}
