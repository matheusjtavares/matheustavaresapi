package br.edu.infnet.matheustavaresapi.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.matheustavaresapi.model.domain.GameCopy;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.GameCopyNotFoundException;
import br.edu.infnet.matheustavaresapi.model.repository.GameCopyRepository;
@Service
public class GameCopyService implements CrudService<GameCopy, Integer>{

    private final GameCopyRepository gameCopyRepository;
    public GameCopyService(GameCopyRepository gameCopyRepository){
        this.gameCopyRepository = gameCopyRepository;
    }
    private void validate(GameCopy gameCopy){
        if (gameCopy == null){
            throw new IllegalArgumentException("Game Copy cannot be null");
        }
    }
    @Override
    public GameCopy include(GameCopy gameCopy) {
        validate(gameCopy);
        if (gameCopy.getId() != null){
            throw new IllegalArgumentException("Game Copy ID cannot be provided");
        }
        return gameCopyRepository.save(gameCopy);
    }

    @Override
    public GameCopy alter(Integer id, GameCopy gameCopy) {
        validate(gameCopy);
        getById(id);
        return gameCopyRepository.save(gameCopy);
    }

    @Override
    public GameCopy getById(Integer id) {
        if (id==null || id<=0){
            throw new IllegalArgumentException("The id cannot be null or 0");
        }
        return gameCopyRepository.findById(id).orElseThrow(() -> new GameCopyNotFoundException("The id " + id + " was not found"));
    }

    @Override
    public void delete(Integer id) {
        getById(id);
        gameCopyRepository.deleteById(id);
    }

    @Override
    public List<GameCopy> getList() {
        return gameCopyRepository.findAll();
    }


}
