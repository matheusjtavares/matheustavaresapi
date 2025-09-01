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

import br.edu.infnet.matheustavaresapi.model.domain.GameTitle;
import br.edu.infnet.matheustavaresapi.model.service.GameTitleService;

@RestController
@RequestMapping("/api/gametitles")
public class GameTitleController {

    private final GameTitleService gameTitleService;

    public GameTitleController(GameTitleService gameTitleService) {
        this.gameTitleService = gameTitleService;
    }
    @PostMapping()
    public ResponseEntity<GameTitle> include(@RequestBody GameTitle gameTitle) {
        //TODO: process POST request
        GameTitle newGameTitle = gameTitleService.include(gameTitle);
        return ResponseEntity.status(HttpStatus.CREATED).body(newGameTitle);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GameTitle> alter(@PathVariable int id, @RequestBody GameTitle gameTitle) {
        //TODO: process PUT request
        GameTitle alteredGameTitle = gameTitleService.alter(id,gameTitle);
        return ResponseEntity.ok(alteredGameTitle);
        
    }
    
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<GameTitle> deactivate(@PathVariable int id) {
        //TODO: process PUT request
        GameTitle deactivatedGameTitle = gameTitleService.deactivate(id);
        return ResponseEntity.noContent().build();
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        gameTitleService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<GameTitle>> getList() {
        List<GameTitle> gameTitlesList = gameTitleService.getList();
        if(gameTitlesList.isEmpty()){
            return ResponseEntity.noContent().build();
            
        }
        return ResponseEntity.ok(gameTitlesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameTitle> getGameTitle(@PathVariable int id) {
        GameTitle gameTitle = gameTitleService.getById(id);
        return ResponseEntity.ok(gameTitle);
    }
}
