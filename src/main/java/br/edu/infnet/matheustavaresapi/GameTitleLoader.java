package br.edu.infnet.matheustavaresapi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.matheustavaresapi.model.domain.GameTitle;
import br.edu.infnet.matheustavaresapi.model.domain.Platform;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlatformNotFoundException;
import br.edu.infnet.matheustavaresapi.model.service.GameTitleService;
import br.edu.infnet.matheustavaresapi.model.service.PlatformService;

@Component
@Order(3)
public class GameTitleLoader implements ApplicationRunner{

    private final GameTitleService gameTitleService;
    private final PlatformService platformService;

    public GameTitleLoader(GameTitleService gameTitleService,PlatformService platformService){
        this.gameTitleService = gameTitleService;
        this.platformService = platformService;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file  = new FileReader("game_titles.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields = null;

        while (line!=null){
            fields = line.split(";");
            GameTitle gameTitle = new GameTitle();
            gameTitle.setName(fields[0]);
            gameTitle.setPublisher(fields[1]);
            String platformName = fields[2];
            Platform platform = null;
            try {
                platform = platformService.getByName(platformName);  
            } catch (PlatformNotFoundException e) {
                System.err.println("Invalid Platform Name: " + e.getMessage());
                line = reader.readLine();
                continue;
            }
            gameTitle.setPlatform(platform);
            gameTitle.setReleaseDate(LocalDate.parse(fields[3]));
            gameTitle.setVersion(Float.parseFloat(fields[4]));
            gameTitle.setIsActive(true);
            gameTitleService.include(gameTitle);
            line = reader.readLine();

        }

        reader.close();

    }
}
