package ifpi.ads.projintegrador1.klonus.dao;

import java.util.List;

import javax.persistence.EntityManager;

//import org.springframework.stereotype.Component;

import ifpi.ads.projintegrador1.klonus.model.Player;
import ifpi.ads.projintegrador1.klonus.util.JPAUTIL;



//@Component
public class PlayerDao {
	
	/**
	 * Deprecated
	 * @author Pedro Henrique
	 * 
	 */
	
	private EntityManager em;
	
	public PlayerDao(EntityManager em) {
		this.em = JPAUTIL.buildEntityManager();
	}

	public List<Player> listFromPlayers() {
		return em.createQuery("SELECT p FROM Player p", Player.class).getResultList();
	}
	
}
