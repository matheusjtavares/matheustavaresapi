package br.edu.infnet.matheustavaresapi.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.matheustavaresapi.model.domain.Platform;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlatformInvalidException;
import br.edu.infnet.matheustavaresapi.model.domain.exceptions.PlatformNotFoundException;

@Service
public class PlatformService implements CrudService<Platform,Integer>{

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
            throw new PlatformNotFoundException("The id " + id + "was not found");
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
        Platform platform = map.get(id);
        validate(platform);
        return platform;
    }
    @Override
    public List<Platform> getList() {
        // TODO Auto-generated method stub
        return new ArrayList<>(map.values());

    }
    
    @Override
    public Platform alter(Integer id, Platform platform) {
        // TODO Auto-generated method stub
        validateId(id);
        validate(platform);
        getById(id);
        platform.setId(id);
        map.replace(id,platform);
        return platform;
    }
    @Override
    public Platform include(Platform platform) {
        // TODO Auto-generated method stub
        validate(platform);
        if (platform.getId() != null && platform.getId() != 0 ) {
            throw new IllegalArgumentException("The id cannot be provided");
        }
        // Validação específica include. Não deve ter ID
        platform.setId(nextId.getAndIncrement());
        map.put(platform.getId(),platform);

        return platform;
    }
    public Platform deactivate(Integer id){
        validateId(id);
        Platform platform = map.get(id);
        platform.setIsActive(false);
        map.put(platform.getId(),platform);
        return platform;
    }
}
