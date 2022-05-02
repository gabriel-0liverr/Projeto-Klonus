package ads.projetointegrador.klonus.action;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.projetointegrador.klonus.dao.JPAUTIL;
import ads.projetointegrador.klonus.dao.PlayerDao;
import ads.projetointegrador.klonus.modelo.Player;

public class Ranking implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManager em = new JPAUTIL().buildEntityManager();
		PlayerDao player = new PlayerDao(em);
		
		List<Player> players = player.playerList();
		req.setAttribute("players", players);
			
		em.close();
		
		return "forward:ranking.jsp";
		
	}
	
}
