package ads.projetointegrador.klonus.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUTIL {
	
	private EntityManagerFactory emFactory = 
			Persistence.createEntityManagerFactory("klonusdb");
	
	public EntityManager buildEntityManager() {
		return emFactory.createEntityManager();
	}
}
