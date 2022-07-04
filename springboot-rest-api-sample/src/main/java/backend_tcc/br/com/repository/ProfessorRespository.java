package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Professor;


@Repository
public interface ProfessorRespository extends JpaRepository<Professor, Long> {

	@Query(value = "select u from Professor u where upper (trim(u.contato)) like %?1%")
	List<Professor>getEveryProfessor(String contato);
	
}
