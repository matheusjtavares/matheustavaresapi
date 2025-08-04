package br.edu.infnet.matheustavaresapi.model.domain;
import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PlayerLoader implements ApplicationRunner{
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file  = new FileReader("player.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields = null;

        while (line!=null){
            fields = line.split(";");
            Player player = new Player();
            player.name = fields[0];
            player.isActive = Boolean.parseBoolean(fields[1]);
            player.age = Integer.parseInt(fields[2]);
            player.activity = Double.parseDouble(fields[3]);
            System.out.println(player);
            line = reader.readLine();

        }

        reader.close();

    }
}
