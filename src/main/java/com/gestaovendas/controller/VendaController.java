package com.gestaovendas.controller; 
 
import java.sql.Date;
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

import com.gestaovendas.entities.Venda;
import com.gestaovendas.services.VendaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid; 
 
@RestController 
@RequestMapping("/venda") 
@Tag(name = "Vendas", description="API REST DE GERENCIAMENTO DE PRODUTOS") 
public class VendaController { 
	 
	private final VendaService vendaService; 
	 
	@Autowired 
	public VendaController(VendaService vendaService) {  
		this.vendaService = vendaService;  
	} 
	 
	@GetMapping("/{id}")  
	@Operation(summary = "Busca um venda por id") 
	public ResponseEntity<Venda> buscaVendaControlId(@PathVariable Long id){  
		Venda venda = vendaService.buscaVendaId(id);  
		if(venda != null) {  
			return ResponseEntity.ok(venda);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	} 
	@GetMapping("/data/{data}")  
	@Operation(summary = "Busca um venda por nome") 
	public ResponseEntity<List<Venda>> buscarVendaPorData(@PathVariable Date data){  
		List<Venda> vendas = vendaService.buscarVendasPorData(data);  
		return ResponseEntity.ok(vendas);  
	}  
 
	@GetMapping  
	@Operation(summary = "Busca um venda") 
	public ResponseEntity<List<Venda>> buscaTodosVendasControl(){  
		List<Venda>Venda = vendaService.buscaTodosVendas(); 
		return ResponseEntity.ok(Venda);  
	}  
 
	@PostMapping  
	@Operation(summary = "Cadastra um venda") 
	public ResponseEntity<Venda> salvaVendasControl(@RequestBody @Valid Venda venda){  
		Venda salvaVenda = vendaService.salvaVenda(venda);  
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaVenda);  
 
	}  
 
	@PutMapping("/{id}")  
	@Operation(summary = "Atualiza um venda") 
	public ResponseEntity<Venda> alteraVendaControl(@PathVariable Long id, @RequestBody @Valid Venda venda){  
		Venda alteraVenda = vendaService.alterarVenda(id, venda);  
		if(alteraVenda != null) {  
			return ResponseEntity.ok(venda);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
 
	@DeleteMapping("/{id}")  
	@Operation(summary = "Exclui um venda") 
	public ResponseEntity<Venda> apagaVendaControl(@PathVariable Long id){  
		boolean apagar = vendaService.apagarVenda(id);  
		if (apagar) {  
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
		  
		 
} 