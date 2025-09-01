package br.edu.infnet.matheustavaresapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.matheustavaresapi.model.domain.Player;
import br.edu.infnet.matheustavaresapi.model.service.PlayerService;






@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @PostMapping()
    public ResponseEntity<Player> include(@RequestBody Player player) {
        //TODO: process POST request
        Player newPlayer = playerService.include(player);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Player> alter(@PathVariable int id, @RequestBody Player player) {
        //TODO: process PUT request
        Player playerAltered = playerService.alter(id,player);
        return ResponseEntity.ok(playerAltered);
        
    }
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Player> deactivate(@PathVariable int id) {
        //TODO: process PUT request
        Player player = playerService.deactivate(id);
        return ResponseEntity.noContent().build();
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        playerService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<Player>> getList() {
        List<Player> playersList = playerService.getList();
        if(playersList.isEmpty()){
            return ResponseEntity.noContent().build();
            
        }
        return ResponseEntity.ok(playersList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable int id) {
        Player player  = playerService.getById(id);
        return ResponseEntity.ok(player);
    }
    
    
}

