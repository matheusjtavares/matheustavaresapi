package br.edu.infnet.matheustavaresapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PlayerController {
    @GetMapping("api/person/name")
    public String getName() {
        return "Matheus";
    }
    @GetMapping("api/person/age")
    public int getAge() {
        return 29;
    }
    @GetMapping("api/person/activity")
    public double getActivity() {
        return 2500.00;
    }
    @GetMapping("api/person/status")
    public boolean getStatus() {
        return false;
    }
    
}

