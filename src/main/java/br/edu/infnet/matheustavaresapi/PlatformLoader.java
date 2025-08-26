package br.edu.infnet.matheustavaresapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.matheustavaresapi.model.domain.Platform;

@Component
public class PlatformLoader implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file  = new FileReader("platforms.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields = null;

        while (line!=null){
            fields = line.split(";");
            Platform platform = new Platform();
            platform.name = fields[0];
            platform.manufacturer = fields[1];
            platform.releaseDate = LocalDate.parse(fields[2]);
            platform.price = Double.parseDouble(fields[3]);
            platform.isHandheld = Boolean.parseBoolean(fields[4]);
            System.out.println(platform);
            line = reader.readLine();
        }

        reader.close();

    }
}
