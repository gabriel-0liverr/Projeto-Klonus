package ifpi.ads.projintegrador1.klonus.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUTIL {
	
	/**
	 * Deprecated
	 * @author Pedro Henrique
	 * 
	 */
	
	private static final EntityManagerFactory FACTORY = 
			Persistence.createEntityManagerFactory("klonusdb");
	
	public static EntityManager buildEntityManager() {
		return FACTORY.createEntityManager();
	}
}
