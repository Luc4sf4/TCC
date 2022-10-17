package backend_tcc.br.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

    @Entity
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
    public class Usuario implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
		private Long id;
		
		private String name;
		
		private String emailDescription;
		
		private String passwordDescription;
		
		private Long admin;
		
		private String status;
		
	
		
		
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmailDescription() {
			return emailDescription;
		}

		public void setEmailDescription(String emailDescription) {
			this.emailDescription = emailDescription;
		}

		public String getPasswordDescription() {
			return passwordDescription;
		}

		public void setPasswordDescription(String passwordDescription) {
			this.passwordDescription = passwordDescription;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getAdmin() {
			return admin;
		}

		public void setAdmin(Long admin) {
			this.admin = admin;
		}
}
