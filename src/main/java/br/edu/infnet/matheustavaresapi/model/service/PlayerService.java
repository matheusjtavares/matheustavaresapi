package br.edu.infnet.matheustavaresapi.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.matheustavaresapi.model.domain.Player;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlayerInvalidException;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlayerNotFoundException;
import br.edu.infnet.matheustavaresapi.model.repository.PlayerRepository;

@Service
public class PlayerService implements CrudService<Player, Integer> {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

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
        Player player = getById(id);
        playerRepository.deleteById(id);
    }

    @Override
    public Player getById(Integer id) {
        // TODO Auto-generated method stub
        if (id==null || id<=0){
            throw new IllegalArgumentException("The id cannot be null or 0");
        }
        return playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException("The id " + id + " was not found"));

    }

    @Override
    public Player alter(Integer id, Player player) {

        validate(player);
        getById(id);
        return playerRepository.save(player);
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


        return playerRepository.save(player);
    }

    @Override
    public List<Player> getList() {
        // TODO Auto-generated method stub
        return playerRepository.findAll();
    }
    public Player deactivate(Integer id){

        Player player = getById(id);
        player.setIsActive(false);
        return playerRepository.save(player);
    }

}
