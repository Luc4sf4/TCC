package backend_tcc.br.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_turmaProf", sequenceName = "seq_turmaProf", allocationSize = 1, initialValue = 1)
public class TurmaProfessor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "seq_turmaProf")
	private Long idTurmaProf;
	
	private Long idProf;
	
	private long idTurma;

	public Long getIdTurmaProf() {
		return idTurmaProf;
	}

	public void setIdTurmaProf(Long idTurmaProf) {
		this.idTurmaProf = idTurmaProf;
	}

	public Long getIdProf() {
		return idProf;
	}

	public void setIdProf(Long idProf) {
		this.idProf = idProf;
	}

	public long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(long idTurma) {
		this.idTurma = idTurma;
	}
	
}
