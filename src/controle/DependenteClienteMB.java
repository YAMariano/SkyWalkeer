package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import daoGenerico.DAOGenerico;
import modelo.DependenteCliente;

@ManagedBean
@ViewScoped
public class DependenteClienteMB {
	private DependenteCliente dependente = new DependenteCliente();
	private List<DependenteCliente> dependentes = new ArrayList<>();
	private DAOGenerico<DependenteCliente> dao = new DAOGenerico<>(DependenteCliente.class);

	public DependenteClienteMB() {
		dependentes = dao.buscarTodos();
	}

	public void inserir() {
		if (dependente.getIdDependente() == null) {
			dao.salvar(dependente);
		} else {
			dao.alterar(dependente);
		}
		dependente = new DependenteCliente();
		dependentes = dao.buscarTodos();
	}

	public void excluir(Long id) {
		dao.excluir(id);
		dependentes = dao.buscarTodos();
	}

	public DependenteCliente getDependente() {
		return dependente;
	}

	public void setDependente(DependenteCliente dependente) {
		this.dependente = dependente;
	}

	public List<DependenteCliente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<DependenteCliente> dependentes) {
		this.dependentes = dependentes;
	}

}
