package br.edu.infnet.matheustavaresapi.controller;

import java.util.List;

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
    public Player include(@RequestBody Player player) {
        //TODO: process POST request
        return playerService.include(player);
    }
    @PutMapping("/{id}")
    public Player alter(@PathVariable int id, @RequestBody Player player) {
        //TODO: process PUT request
        return playerService.alter(id,player);
        
    }
    @PatchMapping("/{id}/deactivate")
    public Player deactivate(@PathVariable int id) {
        //TODO: process PUT request
        return playerService.deactivate(id);
        
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        playerService.delete(id);
    }
    @GetMapping("/all")
    public List<Player> getList() {
        return playerService.getList();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable int id) {
        return playerService.getById(id);
    }
    
    
}

