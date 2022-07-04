package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Pessoas;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoas, Long> {

	@Query(value = "select u from Pessoas u where upper(trim(u.nome))like %?1%")
	List<Pessoas> getPessoa(String nome);
	
}
