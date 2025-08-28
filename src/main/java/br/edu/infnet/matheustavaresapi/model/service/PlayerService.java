package br.edu.infnet.matheustavaresapi.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.matheustavaresapi.model.domain.Player;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlayerInvalidException;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlayerNotFoundException;

@Service
public class PlayerService implements CrudService<Player, Integer> {

    private final Map<Integer,Player> map = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    private void validate(Player player){
        if (player==null){
            throw new IllegalArgumentException("Player cannot be null");
        }
        if (player.getName() == null || player.getName().trim().isEmpty()){
            throw new PlayerInvalidException("Player name is mandatory");
        }
    }
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
    public Player alter(Integer id, Player player) {
        // TODO Auto-generated method stub
        if (id==null || id==0){
            throw new IllegalArgumentException("The id cannot be null or 0");
        }
        if (!map.containsKey(id)){
            throw new PlayerNotFoundException("The id " + id + "was not found");
        }
        validate(player);
        getById(id);
        player.setId(id);
        map.replace(id,player);
        return player;
    }

    @Override
    public Player include(Player player) {
        // TODO Auto-generated method stub
        // Validação geral include alter
        validate(player);
        if (player.getId() != null && player.getId() != 0 ) {
            throw new IllegalArgumentException("The id cannot be provided");
        }
        // Validação específica include. Não deve ter ID
        player.setId(nextId.getAndIncrement());
        map.put(player.getId(),player);

        return player;
    }

    @Override
    public List<Player> getList() {
        // TODO Auto-generated method stub
        return new ArrayList<>(map.values());
    }
    public Player deactivate(Integer id){
        if (id==null || id==0){
            throw new IllegalArgumentException("The id cannot be null or 0");
        }
        
        if (!map.containsKey(id)){
            throw new PlayerNotFoundException("The id " + id + "was not found");
        }
        Player player = map.get(id);
        player.setIsActive(false);
        map.put(player.getId(),player);
        return player;
    }

}
