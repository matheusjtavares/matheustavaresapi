package br.edu.infnet.matheustavaresapi.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.matheustavaresapi.model.domain.GameTitle;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.GameTitleInvalidException;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.GameTitleNotFoundException;
@Service
public class GameTitleService implements CrudService<GameTitle, Integer> {

    private final Map<Integer,GameTitle> map = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);
    
    private void validate(GameTitle gameTitle){
        if (gameTitle == null){
            throw new IllegalArgumentException("GameTitle cannot be null");
        }
        if (gameTitle.getName() == null || gameTitle.getName().trim().isEmpty()){
            throw new GameTitleInvalidException("GameTitle name is mandatory");
        }
    }
    private void validateId(Integer id){
        if (id==null || id==0){
            throw new IllegalArgumentException("The id cannot be null or 0");
        }
        if (!map.containsKey(id)){
            throw new GameTitleNotFoundException("The id " + id + "was not found");
        }
    }
    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        validateId(id);
        map.remove(id);
    }

    @Override
    public GameTitle getById(Integer id) {
        // TODO Auto-generated method stub
        GameTitle gameTitle = map.get(id);
        validate(gameTitle);
        return gameTitle;

    }

    @Override
    public GameTitle alter(Integer id, GameTitle gameTitle) {
        // TODO Auto-generated method stub
        validateId(id);
        validate(gameTitle);
        getById(id);
        gameTitle.setId(id);
        map.replace(id,gameTitle);
        return gameTitle;
    }

    @Override
    public List<GameTitle> getList() {
        // TODO Auto-generated method stub
        return new ArrayList<>(map.values());
        
    }

    @Override
    public GameTitle include(GameTitle gameTitle) {
        // TODO Auto-generated method stub
        validate(gameTitle);
        if (gameTitle.getId() != null && gameTitle.getId() != 0 ) {
            throw new IllegalArgumentException("The id cannot be provided");
        }
        gameTitle.setId(nextId.getAndIncrement());
        map.put(gameTitle.getId(),gameTitle);
        return gameTitle;
    }

    public GameTitle deactivate(Integer id){
        validateId(id);
        GameTitle gameTitle = map.get(id);
        gameTitle.setIsActive(false);
        map.put(gameTitle.getId(),gameTitle);
        return gameTitle;
    }
}
