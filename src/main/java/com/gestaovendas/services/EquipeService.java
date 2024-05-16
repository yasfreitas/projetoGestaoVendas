package com.gestaovendas.services; 
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaovendas.entities.Equipe;
import com.gestaovendas.repository.EquipeRepository; 
 
@Service 
public class EquipeService { 
	 
	private final EquipeRepository equipeRepository;  
	@Autowired  
	public EquipeService(EquipeRepository equipeRepository) {  
		this.equipeRepository = equipeRepository;  
	}  
	public List<Equipe> buscaTodosEquipes(){  

		return equipeRepository.findAll();  
	}  
	public Equipe buscaEquipeId(Long id) {  
		Optional <Equipe> equipe = equipeRepository.findById(id);  
		return equipe.orElse(null);  
	}  
	public List<Equipe> buscarEquipesPorNome(String nome){ 
		return equipeRepository.findByNome(nome); 
	} 
	public List<Equipe> buscarEquipesPorCidade(String cidade){ 
		return equipeRepository.findByCidade(cidade); 
	} 
	public Equipe salvaEquipe(Equipe equipe) {     
		return equipeRepository.save(equipe);     
	}
	public Equipe alterarEquipe(Long id, Equipe alterarEquipe) {  
		Optional <Equipe> existeEquipe = equipeRepository.findById(id);  
		if (existeEquipe.isPresent()) {  
			alterarEquipe.setId(id);  
			return equipeRepository.save(alterarEquipe);  
		}  
		return null;  
	}  
	public boolean apagarEquipe(Long id) {  
		Optional <Equipe> existeEquipe = equipeRepository.findById(id);  
		if (existeEquipe.isPresent()) {  
			equipeRepository.deleteById(id);  
			return true;  
		}  
		return false;  
	}  
} 