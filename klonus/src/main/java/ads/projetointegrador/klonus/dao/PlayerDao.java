package ads.projetointegrador.klonus.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import ads.projetointegrador.klonus.modelo.Player;

public class PlayerDao {
	
	EntityManager em;
	
	public PlayerDao(EntityManager em) {
		this.em = em;
	}
	
	public void insert(Player player) {
		em.persist(player);
	}
	
	public List<Player> playerList(){
		List<Player> players = em.createQuery(
				"SELECT p FROM Player p ORDER BY p.score DESC", Player.class).getResultList();
		
		return Collections.unmodifiableList(players);
	}

	public void update(Player player) {
		player = em.merge(player);
		
		if(!em.contains(player)) {
			insert(player);
		}
		
	}
}
