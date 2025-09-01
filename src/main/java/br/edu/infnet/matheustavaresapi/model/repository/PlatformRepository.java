package br.edu.infnet.matheustavaresapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.matheustavaresapi.model.domain.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Integer> {

}