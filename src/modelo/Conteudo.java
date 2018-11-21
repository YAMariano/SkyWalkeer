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
public class Conteudo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private ClienteTitular clienteTitular;
	@ManyToOne
	private DependenteCliente Dependentecliente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idConteudo;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String genero;
	@Column(nullable = false)
	private String tipo;
	@Column(nullable = false)
	private int indicacao;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date anoLancamento;
	@Column(nullable = false)
	private double tempoDuracao;

	public Long getIdConteudo() {
		return idConteudo;
	}

	public void setIdConteudo(Long idConteudo) {
		this.idConteudo = idConteudo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(int indicacao) {
		this.indicacao = indicacao;
	}

	public Date getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Date anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public double getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(double tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}

}
