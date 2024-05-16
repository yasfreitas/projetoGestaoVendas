package com.gestaovendas.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaovendas.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
	List<Venda> findByData (Date data);
	
}