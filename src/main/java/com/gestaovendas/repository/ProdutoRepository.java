package com.gestaovendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaovendas.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	List<Produto> findByNome (String nome);
	List<Produto> findByPreco (double preco);


}
