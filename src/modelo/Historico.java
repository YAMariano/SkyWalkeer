package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Historico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private ClienteTitular clienteTitular;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idHistorico;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAcesso;

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clienteTitular == null) ? 0 : clienteTitular.hashCode());
		result = prime * result + ((dataAcesso == null) ? 0 : dataAcesso.hashCode());
		result = prime * result + ((idHistorico == null) ? 0 : idHistorico.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historico other = (Historico) obj;
		if (clienteTitular == null) {
			if (other.clienteTitular != null)
				return false;
		} else if (!clienteTitular.equals(other.clienteTitular))
			return false;
		if (dataAcesso == null) {
			if (other.dataAcesso != null)
				return false;
		} else if (!dataAcesso.equals(other.dataAcesso))
			return false;
		if (idHistorico == null) {
			if (other.idHistorico != null)
				return false;
		} else if (!idHistorico.equals(other.idHistorico))
			return false;
		return true;
	}

	public Long getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(Long idHistorico) {
		this.idHistorico = idHistorico;
	}

	public Date getDataAcesso() {
		return dataAcesso;
	}

	public void setDataAcesso(Date dataAcesso) {
		this.dataAcesso = dataAcesso;
	}

}
