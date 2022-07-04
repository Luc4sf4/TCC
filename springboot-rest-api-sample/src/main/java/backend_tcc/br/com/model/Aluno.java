package backend_tcc.br.com.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name= "seq_aluno", sequenceName="seq_aluno", allocationSize = 1, initialValue = 1 )
public class Aluno  implements Serializable{

	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "seq_aluno")
	private Long idAluno;

	private String ra;
	
	private Date dataNasc;
	
	private Long idPessoa;
	
	private Long idEstadoCivil;

	
	
	
	public Long getIdEstadoCivil() {
		return idEstadoCivil;
	}

	public void setIdEstadoCivil(Long idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	
}
