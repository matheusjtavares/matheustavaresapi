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

import br.edu.infnet.matheustavaresapi.model.domain.Platform;
import br.edu.infnet.matheustavaresapi.model.domain.Platform;
import br.edu.infnet.matheustavaresapi.model.service.PlatformService;


@RestController
@RequestMapping("/api/platforms")
public class PlatformController {

    private final PlatformService platformService;

    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }
    
    @PostMapping()
    public Platform include(@RequestBody Platform platform) {
        //TODO: process POST request
        return platformService.include(platform);
    }
    @PutMapping("/{id}")
    public Platform alter(@PathVariable int id, @RequestBody Platform platform) {
        //TODO: process PUT request
        return platformService.alter(id,platform);
        
    }
    @PatchMapping("/{id}/deactivate")
    public Platform deactivate(@PathVariable int id) {
        //TODO: process PUT request
        return platformService.deactivate(id);
        
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        platformService.delete(id);
    }
    @GetMapping("/all")
    public List<Platform> getList() {
        return platformService.getList();
    }

    @GetMapping("/{id}")
    public Platform getPlatform(@PathVariable int id) {
        return platformService.getById(id);
    }
}
