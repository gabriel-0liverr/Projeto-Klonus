package ads.projetointegrador.klonus.action;

import java.io.BufferedReader;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ads.projetointegrador.klonus.dao.JPAUTIL;
import ads.projetointegrador.klonus.dao.PlayerDao;
import ads.projetointegrador.klonus.modelo.Player;

public class UpdateRanking implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		try {
			if(req.getHeader("Content-type").equals("application/json")){
				BufferedReader reader = req.getReader();
				String json = reader.readLine();
			
				EntityManager em = new JPAUTIL().buildEntityManager();
				
				em.getTransaction().begin();
				Player player = new ObjectMapper().readValue(json, Player.class);
				
				PlayerDao playerDao = new PlayerDao(em);
				playerDao.update(player);
				
				System.out.println(player.getUsername());
				
				em.getTransaction().commit();
				
			}			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		return "redirect:Ranking";
	
	}

}
