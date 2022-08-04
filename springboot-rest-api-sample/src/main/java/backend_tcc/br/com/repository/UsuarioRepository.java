package backend_tcc.br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query (value = "select u from Usuario u where upper(trim(u.emailDescription)) like %?1%")
	List<Usuario> buscarPorNome(String nivelAcesso );

}
