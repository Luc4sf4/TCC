package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Matricula;


@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
	
	
	@Query(value ="select u from Matricula u where upper(trim(u.numeroMatricula)) like %?1%")
	List<Matricula>getEveryMatricula(String numeroMatricula);
	

}
