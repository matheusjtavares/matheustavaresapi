package br.edu.infnet.matheustavaresapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.matheustavaresapi.model.domain.Platform;
import br.edu.infnet.matheustavaresapi.model.service.PlatformService;


@RestController
@RequestMapping("/api/platforms")
public class PlatformController {

    private final PlatformService platformService;

    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @GetMapping("/all")
    public List<Platform> getGameTitles() {
        return platformService.getList();
    }

    @GetMapping("/{id}")
    public Platform getGameTitle(@PathVariable int id) {
        return platformService.getById(id);
    }
}
