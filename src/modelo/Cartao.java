
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
public class Cartao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private ClienteTitular clienteTitular;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCartao;
	@Column(nullable = false, unique = true)
	private int numCartao;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date validade;
	@Column(nullable = false)
	private int codSeguranca;

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clienteTitular == null) ? 0 : clienteTitular.hashCode());
		result = prime * result + codSeguranca;
		result = prime * result + ((idCartao == null) ? 0 : idCartao.hashCode());
		result = prime * result + numCartao;
		result = prime * result + ((validade == null) ? 0 : validade.hashCode());
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
		Cartao other = (Cartao) obj;
		if (clienteTitular == null) {
			if (other.clienteTitular != null)
				return false;
		} else if (!clienteTitular.equals(other.clienteTitular))
			return false;
		if (codSeguranca != other.codSeguranca)
			return false;
		if (idCartao == null) {
			if (other.idCartao != null)
				return false;
		} else if (!idCartao.equals(other.idCartao))
			return false;
		if (numCartao != other.numCartao)
			return false;
		if (validade == null) {
			if (other.validade != null)
				return false;
		} else if (!validade.equals(other.validade))
			return false;
		return true;
	}

	public Long getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Long idCartao) {
		this.idCartao = idCartao;
	}

	public int getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(int numCartao) {
		this.numCartao = numCartao;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public int getCodSeguranca() {
		return codSeguranca;
	}

	public void setCodSeguranca(int codSeguranca) {
		this.codSeguranca = codSeguranca;
	}

}
