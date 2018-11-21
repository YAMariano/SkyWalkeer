package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import daoGenerico.DAOGenerico;
import modelo.ClienteTitular;

@ManagedBean
@ViewScoped
public class ClienteTitularMB {
	
	private ClienteTitular titular = new ClienteTitular();
	private List<ClienteTitular> titulares = new ArrayList<>();
	private DAOGenerico<ClienteTitular> dao = new DAOGenerico<>(ClienteTitular.class);

	public ClienteTitularMB() {
		titulares = dao.buscarTodos();
	}

	public void inserir() {
		if (titular.getIdCliente() == null) {
			dao.salvar(titular);
		} else {
			dao.alterar(titular);
		}
		titular = new ClienteTitular();
		titulares = dao.buscarTodos();
	}

	public void excluir(Long id) {
		dao.excluir(id);
		titulares = dao.buscarTodos();
	}

	public ClienteTitular getClienteTitular() {
		return titular;
	}

	public void setClienteTitular(ClienteTitular titular) {
		this.titular = titular;
	}

	public List<ClienteTitular> getClientesTitulares() {
		return titulares;
	}

	public void setClientesTitulares(List<ClienteTitular> titulares) {
		this.titulares = titulares;
	}

}
