package daoGenerico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fabrica.Conexao;

public class DAOGenerico<T> {
	private EntityManager manager;
	private Class<T> tipoClasse;

	public DAOGenerico(Class<T> tipoClasse) {
		this.tipoClasse = tipoClasse;
	}

	public T salvar(T entidade) {
		manager = Conexao.get().createEntityManager();

		EntityTransaction t = manager.getTransaction();
		try {
			t.begin();
			manager.persist(entidade);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return entidade;
	}

	public T alterar(T entidade) {
		manager = Conexao.get().createEntityManager();
		EntityTransaction t = manager.getTransaction();

		try {
			t.begin();
			manager.merge(entidade);
			t.commit();
		}

		catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		}

		finally {
			manager.close();
		}
		return entidade;
	}

	public boolean excluir(long id) {
		manager = Conexao.get().createEntityManager();
		EntityTransaction t = manager.getTransaction();

		try {
			t.begin();
			T entidade = manager.find(tipoClasse, id);
			t.commit();

			if (entidade != null) {
				manager.remove(entidade);
			}
			t.commit();
			return true;
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return false;
		}

		finally {
			manager.close();
		}
	}

	public T consultar(long id) {
		manager = Conexao.get().createEntityManager();
		return manager.find(tipoClasse, id);
	}

	public List<T> buscarTodos() {
		manager = Conexao.get().createEntityManager();

		try {
			return manager.createQuery("from entidade").getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		finally {
			manager.close();
		}
	}

	public List<T> consultarCondicao(String consultarCondicao) {
		manager = Conexao.get().createEntityManager();

		Query query = null;
		try {
			query = manager.createQuery("from " + tipoClasse.getSimpleName() + " where " + consultarCondicao);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return query.getResultList();
	}
}
