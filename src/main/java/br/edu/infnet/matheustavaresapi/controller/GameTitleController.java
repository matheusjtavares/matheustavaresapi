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

import br.edu.infnet.matheustavaresapi.model.domain.GameTitle;
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
    public GameTitle include(@RequestBody GameTitle gameTitle) {
        //TODO: process POST request
        return gameTitleService.include(gameTitle);
    }
    @PutMapping("/{id}")
    public GameTitle alter(@PathVariable int id, @RequestBody GameTitle gameTitle) {
        //TODO: process PUT request
        return gameTitleService.alter(id,gameTitle);
        
    }
    
    @PatchMapping("/{id}/deactivate")
    public GameTitle deactivate(@PathVariable int id) {
        //TODO: process PUT request
        return gameTitleService.deactivate(id);
        
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        gameTitleService.delete(id);
    }
    @GetMapping("/all")
    public List<GameTitle> getList() {
        return gameTitleService.getList();
    }

    @GetMapping("/{id}")
    public GameTitle getGameTitle(@PathVariable int id) {
        return gameTitleService.getById(id);
    }
}
