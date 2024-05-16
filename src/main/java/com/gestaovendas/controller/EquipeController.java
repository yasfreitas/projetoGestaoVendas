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
 
import com.gestaovendas.entities.Equipe; 
import com.gestaovendas.services.EquipeService; 

import io.swagger.v3.oas.annotations.Operation; 
import io.swagger.v3.oas.annotations.tags.Tag; 
import jakarta.validation.Valid; 

 

@RestController 
@RequestMapping("/equipe") 
@Tag(name = "Equipes", description="API REST DE GERENCIAMENTO DE PRODUTOS") 
public class EquipeController { 

	private final EquipeService equipeService; 
	@Autowired 
	public EquipeController(EquipeService equipeService) {  
		this.equipeService = equipeService;  
	} 
	@GetMapping("/{id}")  
	@Operation(summary = "Busca um equipe por id") 
	public ResponseEntity<Equipe> buscaEquipeControlId(@PathVariable Long id){  
		Equipe equipe = equipeService.buscaEquipeId(id);  
		if(equipe != null) {  
			return ResponseEntity.ok(equipe);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	} 
	@GetMapping("/nome/{nome}")  
	@Operation(summary = "Busca um equipe por nome") 
	public ResponseEntity<List<Equipe>> buscarEquipePorNome(@PathVariable String nome){  
		List<Equipe> equipes = equipeService.buscarEquipesPorNome(nome);  
		return ResponseEntity.ok(equipes);  
	}  
	@GetMapping("/cidade/{cidade}")  
	@Operation(summary = "Busca um equipe por cidade") 
	public ResponseEntity<List<Equipe>> buscarEquipePorCidade(@PathVariable String cidade){  
		List<Equipe> equipes = equipeService.buscarEquipesPorCidade(cidade);  
		return ResponseEntity.ok(equipes); 
	} 
	@GetMapping  
	@Operation(summary = "Busca um equipe") 
	public ResponseEntity<List<Equipe>> buscaTodosEquipesControl(){  
		List<Equipe>Equipe = equipeService.buscaTodosEquipes(); 
		return ResponseEntity.ok(Equipe);  
	}  
	@PostMapping  
	@Operation(summary = "Cadastra um equipe") 
	public ResponseEntity<Equipe> salvaEquipesControl(@RequestBody @Valid Equipe equipe){  
		Equipe salvaEquipe = equipeService.salvaEquipe(equipe);  
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaEquipe);  
	}  
	@PutMapping("/{id}")  
	@Operation(summary = "Atualiza um equipe") 
	public ResponseEntity<Equipe> alteraEquipeControl(@PathVariable Long id, @RequestBody @Valid Equipe equipe){  
		Equipe alteraEquipe = equipeService.alterarEquipe(id, equipe);  
		if(alteraEquipe != null) {  
			return ResponseEntity.ok(equipe);  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
	@DeleteMapping("/{id}")  
	@Operation(summary = "Exclui um equipe") 
	public ResponseEntity<Equipe> apagaEquipeControl(@PathVariable Long id){  
		boolean apagar = equipeService.apagarEquipe(id);  
		if (apagar) {  
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
		}  
		else {  
			return ResponseEntity.notFound().build();  
		}  
	}  
		 
} 
 