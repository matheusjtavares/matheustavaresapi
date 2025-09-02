package br.edu.infnet.matheustavaresapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.matheustavaresapi.model.domain.GameCopy;
import br.edu.infnet.matheustavaresapi.model.service.GameCopyService;

@RestController
@RequestMapping("/api/gamecopies")
public class GameCopyController {

    private final GameCopyService gameCopyService;

    public GameCopyController(GameCopyService gameCopyService) {
        this.gameCopyService = gameCopyService;
    }
    @PostMapping()
    public ResponseEntity<GameCopy> include(@RequestBody GameCopy gameCopy) {
        //TODO: process POST request
        GameCopy newGameCopy = gameCopyService.include(gameCopy);
        return ResponseEntity.status(HttpStatus.CREATED).body(newGameCopy);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GameCopy> alter(@PathVariable int id, @RequestBody GameCopy gameCopy) {
        //TODO: process PUT request
        GameCopy alteredGameCopy = gameCopyService.alter(id,gameCopy);
        return ResponseEntity.ok(alteredGameCopy);
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        gameCopyService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<GameCopy>> getList() {
        List<GameCopy> gameCopysList = gameCopyService.getList();
        if(gameCopysList.isEmpty()){
            return ResponseEntity.noContent().build();
            
        }
        return ResponseEntity.ok(gameCopysList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameCopy> getGameCopy(@PathVariable int id) {
        GameCopy gameCopy = gameCopyService.getById(id);
        return ResponseEntity.ok(gameCopy);
    }
}
