package fabrica;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	private static EntityManagerFactory factory;

	public static EntityManagerFactory get() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("SkyWalker");
		}
		return factory;
	}
}
