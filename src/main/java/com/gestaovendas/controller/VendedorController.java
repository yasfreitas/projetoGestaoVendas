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
 
import com.gestaovendas.entities.Vendedor; 
import com.gestaovendas.services.VendedorService; 
 
import io.swagger.v3.oas.annotations.Operation; 
import io.swagger.v3.oas.annotations.tags.Tag; 
import jakarta.validation.Valid; 
 
@RestController 
@RequestMapping("/vendedor") 
@Tag(name = "Vendedors", description="API REST DE GERENCIAMENTO DE PRODUTOS") 
public class VendedorController { 
	 
	private final VendedorService vendedorService; 
	 
	@Autowired 
	public VendedorController(VendedorService vendedorService) {  
		this.vendedorService = vendedorService;  
	} 
	 
	@GetMapping("/{id}")  
	@Operation(summary = "Busca um vendedor por id") 
	public ResponseEntity<Vendedor> buscaVendedorControlId(@PathVariable Long id){  
		Vendedor vendedor = vendedorService.buscaVendedorId(id);  
		if(vendedor != null) {  
			return ResponseEntity.ok(vendedor);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	} 
	@GetMapping("/nome/{nome}")  
	@Operation(summary = "Busca um vendedor por nome") 
	public ResponseEntity<List<Vendedor>> buscarVendedorPorNome(@PathVariable String nome){  
		List<Vendedor> vendedors = vendedorService.buscarVendedorsPorNome(nome);  
		return ResponseEntity.ok(vendedors);  
	}  
	@GetMapping("/setor/{setor}")  
	@Operation(summary = "Busca um vendedor por setor") 
	public ResponseEntity<List<Vendedor>> buscarVendedorPorSetor(@PathVariable String setor){  
		List<Vendedor> vendedors = vendedorService.buscarVendedorsPorSetor(setor);  
		return ResponseEntity.ok(vendedors); 
	} 
 
	@GetMapping  
	@Operation(summary = "Busca um vendedor") 
	public ResponseEntity<List<Vendedor>> buscaTodosVendedorsControl(){  
		List<Vendedor>Vendedor = vendedorService.buscaTodosVendedors(); 
		return ResponseEntity.ok(Vendedor);  
	}  
 
	@PostMapping  
	@Operation(summary = "Cadastra um vendedor") 
	public ResponseEntity<Vendedor> salvaVendedorsControl(@RequestBody @Valid Vendedor vendedor){  
		Vendedor salvaVendedor = vendedorService.salvaVendedor(vendedor);  
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaVendedor);  
 
	}  
 
	@PutMapping("/{id}")  
	@Operation(summary = "Atualiza um vendedor") 
	public ResponseEntity<Vendedor> alteraVendedorControl(@PathVariable Long id, @RequestBody @Valid Vendedor vendedor){  
		Vendedor alteraVendedor = vendedorService.alterarVendedor(id, vendedor); 
		if(alteraVendedor != null) {  
			return ResponseEntity.ok(vendedor);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
 
	@DeleteMapping("/{id}")  
	@Operation(summary = "Exclui um vendedor") 
	public ResponseEntity<Vendedor> apagaVendedorControl(@PathVariable Long id){  
		boolean apagar = vendedorService.apagarVendedor(id);  
		if (apagar) {  
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  

} 

 