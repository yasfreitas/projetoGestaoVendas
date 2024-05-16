package com.gestaovendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaovendas.entities.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{
	List<Vendedor> findByNome (String nome);
	List<Vendedor> findBySetor (String setor);


}
