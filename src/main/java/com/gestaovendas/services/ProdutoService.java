package com.gestaovendas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaovendas.entities.Produto;
import com.gestaovendas.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;     
	@Autowired     
	public ProdutoService(ProdutoRepository produtoRepository) {     
		this.produtoRepository = produtoRepository;     
	}    
	public List<Produto> buscaTodosProdutos() {     
		return produtoRepository.findAll();    
	}    
	public Produto buscaProdutoId(Long id) {     
		Optional <Produto> produto = produtoRepository.findById(id);    
		return produto.orElse(null);    
	}    
	public List<Produto> buscarProdutosPorNome(String nome){
		return produtoRepository.findByNome(nome);
	}
	public List<Produto> buscarProdutosPorPreco(double preco){
		return produtoRepository.findByPreco(preco);
	}
	public Produto salvaProduto(Produto produto) {     
		return produtoRepository.save(produto);     
	}
	public Produto alterarProduto(Long id, Produto alterarProd) {     
		Optional <Produto> existeProduto = produtoRepository.findById(id);     
		if (existeProduto.isPresent()) {     
			alterarProd.setId(id);     
			return produtoRepository.save(alterarProd);     
		}    
		return null;     
	}    
	public boolean apagarProduto(Long id) {    
		Optional <Produto> existeProduto = produtoRepository.findById(id);     
		if (existeProduto.isPresent()) {     
			produtoRepository.deleteById(id);     
			return true;     
		}    
		return false;     
	}   
}

