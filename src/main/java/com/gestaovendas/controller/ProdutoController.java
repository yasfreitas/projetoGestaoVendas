package com.gestaovendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaovendas.entities.Produto;
import com.gestaovendas.services.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
@Tag(name = "Produtos", description="API REST DE GERENCIAMENTO DE PRODUTOS")
public class ProdutoController {
	
	private final ProdutoService produtoService;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService) {  
		this.produtoService = produtoService;  
	}
	
	@GetMapping("/{id}")  
	@Operation(summary = "Busca um produto por id")
	public ResponseEntity<Produto> buscaProdutoControlId(@PathVariable Long id){  
		Produto produto = produtoService.buscaProdutoId(id);  
		if(produto != null) {  
			return ResponseEntity.ok(produto);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}
	@GetMapping("/nome/{nome}") 
	@Operation(summary = "Busca um produto por nome")
	public ResponseEntity<List<Produto>> buscarProdutoPorNome(@PathVariable String nome){ 
		List<Produto> produtos = produtoService.buscarProdutosPorNome(nome); 
		return ResponseEntity.ok(produtos); 
	} 
	@GetMapping("/preco/{preco}") 
	@Operation(summary = "Busca um produto por preco")
	public ResponseEntity<List<Produto>> buscarProdutoPorPreco(@PathVariable double preco){ 
		List<Produto> produtos = produtoService.buscarProdutosPorPreco(preco); 
		return ResponseEntity.ok(produtos);
	}

	@GetMapping 
	@Operation(summary = "Busca um produto")
	public ResponseEntity<List<Produto>> buscaTodosProdutosControl(){  
		List<Produto>Produto = produtoService.buscaTodosProdutos();
		return ResponseEntity.ok(Produto);  
	}  

	@PostMapping  
	@Operation(summary = "Cadastra um produto")
	public ResponseEntity<Produto> salvaProdutosControl(@RequestBody @Valid Produto produto){  
		Produto salvaProduto = produtoService.salvaProduto(produto);  
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);  

	}  

	@PutMapping("/{id}")  
	@Operation(summary = "Atualiza um produto")
	public ResponseEntity<Produto> alteraProdutoControl(@PathVariable Long id, @RequestBody @Valid Produto produto){  
		Produto alteraProduto = produtoService.alterarProduto(id, produto);  
		if(alteraProduto != null) {  
			return ResponseEntity.ok(produto);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	} 

	@DeleteMapping("/{id}") 
	@Operation(summary = "Exclui um produto")
	public ResponseEntity<Produto> apagaProdutoControl(@PathVariable Long id){  
		boolean apagar = produtoService.apagarProduto(id);  
		if (apagar) {  
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	} 
		 
		
}
