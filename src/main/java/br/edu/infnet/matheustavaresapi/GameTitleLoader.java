package br.edu.infnet.matheustavaresapi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.matheustavaresapi.model.domain.GameTitle;

@Component
public class GameTitleLoader implements ApplicationRunner{
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file  = new FileReader("game_titles.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields = null;

        while (line!=null){
            fields = line.split(";");
            GameTitle gameTitle = new GameTitle();
            gameTitle.name = fields[0];
            gameTitle.publisher = fields[1];
            gameTitle.platform = fields[2];
            gameTitle.releaseDate = LocalDate.parse(fields[3]);
            gameTitle.version = Float.parseFloat(fields[4]);
            System.out.println(gameTitle);
            line = reader.readLine();

        }

        reader.close();

    }
}
