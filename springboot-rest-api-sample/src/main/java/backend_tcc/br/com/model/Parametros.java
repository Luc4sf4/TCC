package backend_tcc.br.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator (name= "seq_paramet", sequenceName = "seq_paramet", allocationSize = 1,initialValue = 1)
public class Parametros implements Serializable {
	
	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue (strategy =  GenerationType.SEQUENCE, generator = "seq_paramet")
	private Long id;

	private String sitetitle;
	
	private String subtitle1;
	
	private String status;

	private String txt1;
	
	private String title_album;
	
	private String title_video;
	
	private String footer;

	private String parametro789;
	
	private String parametro988;
	
	private String parametro765;
	
	private String parametro899;
	
	private String descontos;
	
	private String novidades;

	private String titutlo1;
	
	private String tituloHome;
	
	private String colecoes;
/*---------------------------------------------------------------------------------------------------------------*/	
	
	public String getColecoes() {
		return colecoes;
	}
	
	public void setColecoes(String colecoes) {
		this.colecoes = colecoes;
	}
	
	public String getDescontos() {
		return descontos;
	}
	
	public void setDescontos(String descontos) {
		this.descontos = descontos;
	}
	
	public String getNovidades() {
		return novidades;
	}
	
	public void setNovidades(String novidades) {
		this.novidades = novidades;
	}

	public String getParametro789() {
		return parametro789;
	}

	public void setParametro789(String parametro789) {
		this.parametro789 = parametro789;
	}

	public String getParametro988() {
		return parametro988;
	}

	public void setParametro988(String parametro988) {
		this.parametro988 = parametro988;
	}

	public String getParametro765() {
		return parametro765;
	}

	public void setParametro765(String parametro765) {
		this.parametro765 = parametro765;
	}

	public String getParametro899() {
		return parametro899;
	}
	
	public void setParametro899(String parametro899) {
		this.parametro899 = parametro899;
	}


	public String getTitle_video() {
		return title_video;
	}

	public void setTitle_video(String title_video) {
		this.title_video = title_video;
	}

	public String getTitle_album() {
		return title_album;
	}

	public void setTitle_album(String title_album) {
		this.title_album = title_album;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSitetitle() {
		return sitetitle;
	}

	public void setSitetitle(String sitetitle) {
		this.sitetitle = sitetitle;
	}


	public String getSubtitle1() {
		return subtitle1;
	}

	public void setSubtitle1(String subtitle1) {
		this.subtitle1 = subtitle1;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitutlo1() {
		return titutlo1;
	}

	public void setTitutlo1(String titutlo1) {
		this.titutlo1 = titutlo1;
	}

	public String getTituloHome() {
		return tituloHome;
	}

	public void setTituloHome(String tituloHome) {
		this.tituloHome = tituloHome;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}	
		
}
