package backend_tcc.br.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name= "seq_header", sequenceName = "seq_header", allocationSize = 1, initialValue = 1)
public class EstiloHeader implements Serializable  {

	
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_header")
	private Long id;
	
	private String propiedade;
	
	private String valor;
	
	private Long idAluno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPropiedade() {
		return propiedade;
	}

	public void setPropiedade(String propiedade) {
		this.propiedade = propiedade;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}
	
	
	
	
}
