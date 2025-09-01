package br.edu.infnet.matheustavaresapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.matheustavaresapi.model.domain.GameTitle;

public interface GameTitleRepository extends JpaRepository<GameTitle, Integer>{

}
