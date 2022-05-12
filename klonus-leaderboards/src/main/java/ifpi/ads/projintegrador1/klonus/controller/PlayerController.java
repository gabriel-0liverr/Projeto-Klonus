package ifpi.ads.projintegrador1.klonus.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifpi.ads.projintegrador1.klonus.model.Player;
import ifpi.ads.projintegrador1.klonus.request.PlayerPostResponseBody;
import ifpi.ads.projintegrador1.klonus.service.PlayerService;

@RestController
@RequestMapping(path = "klonus")
public class PlayerController {

	private PlayerService playerService;
	
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	@GetMapping(path = "list/{id}")
	public ResponseEntity<Player> findById(@PathVariable Long id){
		return new ResponseEntity<Player>(playerService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(path = "list")
	public ResponseEntity<List<Player>> list(){
		return new ResponseEntity<List<Player>>(playerService.list(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Player> save(@RequestBody PlayerPostResponseBody playerPostResponseBody){
		return new ResponseEntity<Player>(playerService.save(playerPostResponseBody), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "list/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		playerService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
}
