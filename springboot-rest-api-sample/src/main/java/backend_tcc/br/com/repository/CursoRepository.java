package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Curso;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	@Query(value = "select u from Curso u where upper(trim(u.nome)) like %?1%")
	List<Curso>getEveryCurso(String nome);
	

}
