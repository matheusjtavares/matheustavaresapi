package br.edu.infnet.matheustavaresapi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.matheustavaresapi.model.domain.GameTitle;
import br.edu.infnet.matheustavaresapi.model.service.GameTitleService;

@Component
@Order(3)
public class GameTitleLoader implements ApplicationRunner{

    private final GameTitleService gameTitleService;

    public GameTitleLoader(GameTitleService gameTitleService){
        this.gameTitleService = gameTitleService;
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
            gameTitle.setPublisher(fields[2]);
            gameTitle.setPlatform(fields[3]);
            gameTitle.setReleaseDate(LocalDate.parse(fields[3]));
            gameTitle.setVersion(Float.parseFloat(fields[4]));
            gameTitleService.include(gameTitle);
            line = reader.readLine();

        }

        reader.close();

    }
}
