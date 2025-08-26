package br.edu.infnet.matheustavaresapi.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.matheustavaresapi.model.domain.Player;

@Service
public class PlayerService implements CrudService<Player, Integer> {

    private final Map<Integer,Player> map = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
    }

    @Override
    public Player get(Integer Id) {
        // TODO Auto-generated method stub
        return map.get(Id);
    }

    @Override
    public List<Player> getList() {
        // TODO Auto-generated method stub
        return new ArrayList<>(map.values());
    }

    @Override
    public Player save(Player player) {
        // TODO Auto-generated method stub
        player.setId(nextId.getAndIncrement());
        map.put(player.getId(),player);

        return null;
    }

}
