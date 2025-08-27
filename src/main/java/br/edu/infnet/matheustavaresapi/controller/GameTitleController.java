package br.edu.infnet.matheustavaresapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.matheustavaresapi.model.domain.GameTitle;
import br.edu.infnet.matheustavaresapi.model.service.GameTitleService;

@RestController
@RequestMapping("/api/gameTitles")
public class GameTitleController {

    private final GameTitleService gameTitleService;

    public GameTitleController(GameTitleService gameTitleService) {
        this.gameTitleService = gameTitleService;
    }
    @GetMapping("/all")
    public List<GameTitle> getGameTitles() {
        return gameTitleService.getList();
    }

    @GetMapping("/{id}")
    public GameTitle getGameTitle(@PathVariable int id) {
        return gameTitleService.get(id);
    }
}
