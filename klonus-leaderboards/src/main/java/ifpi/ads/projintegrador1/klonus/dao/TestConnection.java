package ifpi.ads.projintegrador1.klonus.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ifpi.ads.projintegrador1.klonus.model.Player;

public class TestConnection {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("klonusdb").createEntityManager();
		
		em.getTransaction().begin();
		em.persist(new Player(5L,"Otílio", 1500));
		em.getTransaction().commit();
	}
}
