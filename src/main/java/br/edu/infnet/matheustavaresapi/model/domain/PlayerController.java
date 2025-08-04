package br.edu.infnet.matheustavaresapi.model.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PlayerController {
    @GetMapping("api/player/name")
    public String getName() {
        return "Matheus";
    }
    @GetMapping("api/player/age")
    public int getAge() {
        return 29;
    }
    @GetMapping("api/player/activity")
    public double getActivity() {
        return 2500.00;
    }
    @GetMapping("api/player/status")
    public boolean getStatus() {
        return false;
    }
    
}

