package br.edu.infnet.matheustavaresapi;
import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.matheustavaresapi.model.domain.Player;

@Component
public class PlayerLoader implements ApplicationRunner{
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file  = new FileReader("players.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields = null;

        while (line!=null){
            fields = line.split(";");
            Player player = new Player();
            player.userID = Integer.parseInt(fields[0]);
            player.name = fields[1];
            player.age = Integer.parseInt(fields[2]);
            player.isActive = Boolean.parseBoolean(fields[3]);
            player.email = fields[4];
            player.country = fields[5];
            System.out.println(player);
            line = reader.readLine();

        }

        reader.close();

    }
}
