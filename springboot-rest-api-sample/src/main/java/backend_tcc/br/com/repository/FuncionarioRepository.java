package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	
	@Query(value = "select u from Funcionario u where upper(trim(u.email)) like %?1%")
	List<Funcionario>getFuncionario(String email);
	
}
