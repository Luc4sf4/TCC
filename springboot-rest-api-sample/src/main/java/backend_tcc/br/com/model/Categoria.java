package backend_tcc.br.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_Categoria", sequenceName = "seq_Categoria", allocationSize = 1, initialValue = 1)
public class Categoria implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Categoria")
		private Long idCategoria;
		
		private String description;
		

		public Long getIdCategoria() {
			return idCategoria;
		}
		public void setIdCategoria(Long idCategoria) {
			this.idCategoria = idCategoria;
		}
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		

	}

