package br.edu.infnet.matheustavaresapi.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.matheustavaresapi.model.domain.Player;

@Service
public class PlayerService implements CrudService<Player, Integer> {

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Player get() {
        // TODO Auto-generated method stub
        Player player = new Player();
        player.setAge(20);
        player.setName("Matheus");
        player.setCountry("Brazil");
        player.setIsActive(true);
        player.setEmail("teste@gmail.com");

        return player;
    }

    @Override
    public List<Player> getList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Player save(Player entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
