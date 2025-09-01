package br.edu.infnet.matheustavaresapi.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.matheustavaresapi.model.domain.GameTitle;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.GameTitleInvalidException;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlayerNotFoundException;
import br.edu.infnet.matheustavaresapi.model.repository.GameTitleRepository;
@Service
public class GameTitleService implements CrudService<GameTitle, Integer> {

    private final GameTitleRepository gameTitleRepository;

    public GameTitleService(GameTitleRepository gameTitleRepository){
        this.gameTitleRepository = gameTitleRepository;
    }
    
    private void validate(GameTitle gameTitle){
        if (gameTitle == null){
            throw new IllegalArgumentException("GameTitle cannot be null");
        }
        if (gameTitle.getName() == null || gameTitle.getName().trim().isEmpty()){
            throw new GameTitleInvalidException("GameTitle name is mandatory");
        }
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        getById(id);
        gameTitleRepository.deleteById(id);
    }

    @Override
    public GameTitle getById(Integer id) {
        if (id==null || id<=0){
            throw new IllegalArgumentException("The id cannot be null or 0");
        }
        return gameTitleRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException("The id " + id + "was not found"));
    }

    @Override
    public GameTitle alter(Integer id, GameTitle gameTitle) {
        // TODO Auto-generated method stub
        validate(gameTitle);
        getById(id);
        return gameTitleRepository.save(gameTitle);
    }

    @Override
    public List<GameTitle> getList() {
        // TODO Auto-generated method stub
        return gameTitleRepository.findAll();
        
    }

    @Override
    public GameTitle include(GameTitle gameTitle) {
        // TODO Auto-generated method stub
        validate(gameTitle);
        if (gameTitle.getId() != null && gameTitle.getId() != 0 ) {
            throw new IllegalArgumentException("The id cannot be provided");
        }
        return gameTitleRepository.save(gameTitle);
    }

    public GameTitle deactivate(Integer id){
        GameTitle gameTitle = getById(id);
        gameTitle.setIsActive(false);
        return gameTitleRepository.save(gameTitle);
    }
}
