package br.edu.infnet.matheustavaresapi.model.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.matheustavaresapi.model.domain.Platform;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlatformInvalidException;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlatformNotFoundException;
import br.edu.infnet.matheustavaresapi.model.repository.PlatformRepository;

@Service
public class PlatformService implements CrudService<Platform,Integer>{

    private final PlatformRepository platformRepository;
    public PlatformService(PlatformRepository platformRepository){
        this.platformRepository = platformRepository;
    }
    
    private final Map<Integer,Platform> map = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);
    
    private void validate(Platform platform){
        if (platform == null){
            throw new IllegalArgumentException("Platform cannot be null");
        }
        if (platform.getName() == null || platform.getName().trim().isEmpty()){
            throw new PlatformInvalidException("Platform name is mandatory");
        }
    }
    private void validateId(Integer id){
        if (id==null || id==0){
            throw new IllegalArgumentException("The id cannot be null or 0");
        }
        if (!map.containsKey(id)){
            throw new PlatformNotFoundException("The id " + id + " was not found");
        }
    }
    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        validateId(id);
        map.remove(id);
    }
    @Override
    public Platform getById(Integer id) {
        // TODO Auto-generated method stub
        if (id==null || id<=0){
            throw new IllegalArgumentException("The id cannot be null or 0");
        }
        return platformRepository.findById(id).orElseThrow(() -> new PlatformNotFoundException("The id " + id + " was not found"));
    }
    @Override
    public List<Platform> getList() {
        // TODO Auto-generated method stub
        return platformRepository.findAll();

    }
    
    @Override
    public Platform alter(Integer id, Platform platform) {
        // TODO Auto-generated method stub
        getById(id);
        validate(platform);
        return platformRepository.save(platform);
    }
    @Override
    public Platform include(Platform platform) {
        // TODO Auto-generated method stub
        validate(platform);
        if (platform.getId() != null && platform.getId() != 0 ) {
            throw new IllegalArgumentException("The id cannot be provided");
        }

        return platformRepository.save(platform);
    }
    public Platform deactivate(Integer id){
        Platform platform = getById(id);
        platform.setIsActive(false);
        return platformRepository.save(platform);
    }
    public Platform getByName(String name){
        List<Platform> plaformList = getList();
        for (int i = 0; i < plaformList.size(); i++) {
            if ( plaformList.get(i).getName().equals(name) ){
                return plaformList.get(i);
            }
        }
        throw new PlatformNotFoundException("The name provided does not correspond to any platform within the database");
    }
}
