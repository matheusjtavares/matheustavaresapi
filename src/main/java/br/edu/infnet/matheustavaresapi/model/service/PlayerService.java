package br.edu.infnet.matheustavaresapi.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.matheustavaresapi.model.domain.Player;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlayerInvalidException;

@Service
public class PlayerService implements CrudService<Player, Integer> {

    private final Map<Integer,Player> map = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        Player player = map.get(id);
        if (player.getName() == null){
            throw new PlayerInvalidException("The selected player is not valid");
        }
        map.remove(id);
    }

    @Override
    public Player getById(Integer id) {
        // TODO Auto-generated method stub
        Player player = map.get(id);
        if (player.getName() == null){
            throw new IllegalArgumentException("Cannot find a Player with the given id;");
        }
        return player;
    }

    @Override
    public List<Player> getList() {
        // TODO Auto-generated method stub
        return new ArrayList<>(map.values());
    }

    @Override
    public Player save(Player player) {
        // TODO Auto-generated method stub
        if (player.getName() == null){
            throw new PlayerInvalidException("The selected player is not valid");
        }
        player.setId(nextId.getAndIncrement());
        map.put(player.getId(),player);

        return null;
    }

}
