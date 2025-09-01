package br.edu.infnet.matheustavaresapi;
import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.matheustavaresapi.model.domain.Platform;
import br.edu.infnet.matheustavaresapi.model.domain.Player;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlatformNotFoundException;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlayerInvalidException;
import br.edu.infnet.matheustavaresapi.model.service.PlatformService;
import br.edu.infnet.matheustavaresapi.model.service.PlayerService;

@Component
@DependsOn("platformLoader")
@Order(2)
public class PlayerLoader implements ApplicationRunner{
    
    private final PlayerService playerService;
    private final PlatformService platformService;
    
    public PlayerLoader(PlayerService playerService,PlatformService platformService) {
        this.playerService = playerService;
        this.platformService = platformService;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file  = new FileReader("players.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields = null;

        while (line!=null){
            fields = line.split(";");
            Player player = new Player();
            player.setName(fields[1]);
            player.setAge(Integer.parseInt(fields[2]));
            player.setIsActive(Boolean.parseBoolean(fields[3]));
            player.setEmail(fields[4]);
            player.setCountry(fields[5]);
            String platformName = fields[6];
            // Platform platform = new Platform();
            // platform.setName(platformName);
            // player.setFavouritePlatform(platform);
            // platformService.include(platform);
            Platform platform = null;
            try {
                platform = platformService.getByName(platformName);  
            } catch (PlatformNotFoundException e) {
                System.err.println("Invalid Platform Name: " + e.getMessage());
                line = reader.readLine();
                continue;
            }
            player.setFavouritePlatform(platform);
            System.out.println(player);
            try {
                playerService.include(player); 
            } catch (PlayerInvalidException e) {
                System.err.println("Invalid Player Object: " + e.getMessage());
            } catch (Exception e){
                System.err.println("Failed to create entity player: " + e.getMessage());
            }
            line = reader.readLine();

        }
        reader.close();

    }
}
