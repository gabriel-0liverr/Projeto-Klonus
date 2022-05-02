package ads.projetointegrador.klonus.teste;

import javax.persistence.EntityManager;

import ads.projetointegrador.klonus.dao.JPAUTIL;
import ads.projetointegrador.klonus.dao.PlayerDao;
import ads.projetointegrador.klonus.modelo.Player;

public class TesteConexao {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUTIL().buildEntityManager();
		PlayerDao player = new PlayerDao(em);
		
		em.getTransaction().begin();
		
		player.insert(new Player("yedda", 150));
		
		em.getTransaction().commit();;
	}
}
