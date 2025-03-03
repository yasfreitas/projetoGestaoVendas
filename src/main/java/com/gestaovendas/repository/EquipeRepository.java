package com.gestaovendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaovendas.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long>{
	List<Equipe> findByNome (String nome);
	List<Equipe> findByCidade (String cidade);


}

