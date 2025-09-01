package br.edu.infnet.matheustavaresapi.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.matheustavaresapi.model.domain.GameCopy;
import br.edu.infnet.matheustavaresapi.model.domain.Player;


public interface GameCopyRepository extends JpaRepository<GameCopy, Integer>{
    List<GameCopy> findByPlayer(Player player);
}
