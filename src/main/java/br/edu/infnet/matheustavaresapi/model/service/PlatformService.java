package br.edu.infnet.matheustavaresapi.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.matheustavaresapi.model.domain.Platform;

@Service
public class PlatformService implements CrudService<Platform,Integer>{

    private final Map<Integer,Platform> map = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);
    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public Platform getById(Integer id) {
        // TODO Auto-generated method stub
        return map.get(id);
    }
    @Override
    public List<Platform> getList() {
        // TODO Auto-generated method stub
        return new ArrayList<>(map.values());

    }
    
    @Override
    public Platform alter(Integer id, Platform platform) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Platform include(Platform platform) {
        // TODO Auto-generated method stub
        platform.setId(nextId.getAndIncrement());
        map.put(platform.getId(),platform);
        return null;
    }
    

    

}
