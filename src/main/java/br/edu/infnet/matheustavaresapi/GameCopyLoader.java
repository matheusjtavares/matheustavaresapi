package br.edu.infnet.matheustavaresapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.matheustavaresapi.model.domain.GameCopy;
import br.edu.infnet.matheustavaresapi.model.domain.GameTitle;
import br.edu.infnet.matheustavaresapi.model.domain.Player;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.GameTitleNotFoundException;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlayerNotFoundException;
import br.edu.infnet.matheustavaresapi.model.service.GameCopyService;
import br.edu.infnet.matheustavaresapi.model.service.GameTitleService;
import br.edu.infnet.matheustavaresapi.model.service.PlayerService;

@Component
@Order(4)
public class GameCopyLoader implements ApplicationRunner{
    private final GameCopyService gameCopyService;
    private final PlayerService playerService;
    private final GameTitleService gameTitleService;
    public GameCopyLoader(GameCopyService gameCopyService,PlayerService playerService,GameTitleService gameTitleService){
        this.gameCopyService = gameCopyService;
        this.playerService = playerService;
        this.gameTitleService = gameTitleService;
    }
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file  = new FileReader("game_copies.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields = null;

        while (line!=null){
            fields = line.split(";");
            GameCopy gameCopy = new GameCopy();
            Player player = null;
            GameTitle gameTitle = null;
            String playerName = fields[0];
            try {
                player = playerService.getByName(playerName);  
            } catch (PlayerNotFoundException e) {
                System.err.println("Invalid Player Name: " + e.getMessage());
                line = reader.readLine();
                continue;
            }
            gameCopy.setPlayer(player);
            String gameTitleName = fields[1];
            try {
                gameTitle = gameTitleService.getByName(gameTitleName);  
            } catch (GameTitleNotFoundException e) {
                System.err.println("Invalid Game Title Name: " + e.getMessage());
                line = reader.readLine();
                continue;
            }
            gameCopy.setGameTitle(gameTitle);
            gameCopy.setOwnedSinceDate(LocalDate.parse(fields[2]));
            
            gameCopyService.include(gameCopy);
            line = reader.readLine();

        }

        reader.close();
    }

}
