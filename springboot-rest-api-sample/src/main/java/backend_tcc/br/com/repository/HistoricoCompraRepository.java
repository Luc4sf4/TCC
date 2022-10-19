package backend_tcc.br.com.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend_tcc.br.com.model.HistoricoCompras;

@Repository
public interface HistoricoCompraRepository extends JpaRepository<HistoricoCompras, Long>{

	
	@Query(value = "SELECT u FROM HistoricoCompras u ")
	List<HistoricoCompras>getEveryHistoricoCompras(Date DataPagamento);
	
	
}
