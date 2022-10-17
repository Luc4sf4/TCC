package backend_tcc.br.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_func", sequenceName = "seq_func", allocationSize = 1, initialValue = 1)

public class Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_func")
	private Long idFunc;
	
	private String email;
	
	private String password;

	public Long getIdFunc() {
		return idFunc;
	}

	public void setIdFunc(Long idFunc) {
		this.idFunc = idFunc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
