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
    public ResponseEntity<Platform> include(@RequestBody Platform platform) {
        //TODO: process POST request
        Platform newPlatform = platformService.include(platform);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlatform);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Platform> alter(@PathVariable int id, @RequestBody Platform platform) {
        //TODO: process PUT request
        Platform alteredPlatform = platformService.alter(id,platform);
        return ResponseEntity.ok(alteredPlatform);
        
    }
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Platform> deactivate(@PathVariable int id) {
        //TODO: process PUT request
        Platform deactivatedPlatform = platformService.deactivate(id);
        return ResponseEntity.noContent().build();
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        platformService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<Platform>> getList() {
        List<Platform> listPlatforms = platformService.getList();
        if(listPlatforms.isEmpty()){
            return ResponseEntity.noContent().build();
            
        }
        return ResponseEntity.ok(listPlatforms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Platform> getPlatform(@PathVariable int id) {
        Platform platform  = platformService.getById(id);
        return ResponseEntity.ok(platform);
    }
}
