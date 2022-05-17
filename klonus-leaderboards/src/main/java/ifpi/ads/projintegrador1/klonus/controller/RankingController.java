package ifpi.ads.projintegrador1.klonus.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ifpi.ads.projintegrador1.klonus.model.Player;
import ifpi.ads.projintegrador1.klonus.service.PlayerService;

@Controller
public class RankingController {
	
	private PlayerService playerService;
	
	public RankingController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@GetMapping(path = "i")
	public String index() {
		return "index.html";
	}
	
	@GetMapping(path = "ranking")
	public ModelAndView ranking() {
		ModelAndView modelAndView = new ModelAndView("index");
		List<Player> players = playerService.list();
		players.sort((p1, p2) -> p2.getScore().compareTo(p1.getScore()));
		modelAndView.addObject("players", players);
		return modelAndView;
	}
}
