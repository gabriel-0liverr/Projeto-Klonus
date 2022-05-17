package ifpi.ads.projintegrador1.klonus.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ifpi.ads.projintegrador1.klonus.model.Player;
import ifpi.ads.projintegrador1.klonus.repository.PlayerRepository;
import ifpi.ads.projintegrador1.klonus.request.PlayerPostResponseBody;
import ifpi.ads.projintegrador1.klonus.request.PlayerPutResponseBody;

@Service
public class PlayerService {

	private PlayerRepository playerRepository;
	
	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	public Player findById(Long id) {
		return playerRepository.findById(id).orElseThrow( () ->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Player not Founded"));
	}
	
	public List<Player> list() {
		return playerRepository.findAll();
	}

	public Player save(PlayerPostResponseBody playerPostResponseBody) {
		Player player = new Player(playerPostResponseBody.getUsername(), playerPostResponseBody.getScore());
		return playerRepository.save(player);
	}

	public void delete(Long id) {
		playerRepository.delete(findById(id));
	}
	
	public void update(PlayerPutResponseBody playerPutResponseBody) {
		Player playerFounded = findById(playerPutResponseBody.getId());
		Player player = 
				new Player(
					playerFounded.getId(), 
					playerPutResponseBody.getUsername(), 
					playerPutResponseBody.getScore()
				);
		
		playerRepository.save(player);
	}

}
