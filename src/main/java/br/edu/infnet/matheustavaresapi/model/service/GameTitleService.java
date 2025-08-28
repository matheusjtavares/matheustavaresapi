package br.edu.infnet.matheustavaresapi.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.matheustavaresapi.model.domain.GameTitle;
@Service
public class GameTitleService implements CrudService<GameTitle, Integer> {

    private final Map<Integer,GameTitle> map = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);
    
    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public GameTitle getById(Integer id) {
        // TODO Auto-generated method stub
        return map.get(id);

    }

    @Override
    public GameTitle alter(Integer id, GameTitle gameTitle) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<GameTitle> getList() {
        // TODO Auto-generated method stub
        return new ArrayList<>(map.values());
        
    }

    @Override
    public GameTitle include(GameTitle gameTitle) {
        // TODO Auto-generated method stub
        gameTitle.setId(nextId.getAndIncrement());
        map.put(gameTitle.getId(),gameTitle);
        return null;
    }

}
