package br.edu.infnet.matheustavaresapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.matheustavaresapi.model.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    
}
