package com.gestaovendas.services; 
 
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaovendas.entities.Venda;
import com.gestaovendas.repository.VendaRepository; 
 
@Service 
public class VendaService { 
	 
	private final VendaRepository vendaRepository;  
	@Autowired  
	public VendaService(VendaRepository vendaRepository) {  
		this.vendaRepository = vendaRepository;  
	}  
	public List<Venda> buscaTodosVendas() {  
		return vendaRepository.findAll();  
	}  
	public Venda buscaVendaId(Long id) {  
		Optional <Venda> venda = vendaRepository.findById(id);  
		return venda.orElse(null);  
	}  
	public List<Venda> buscarVendasPorData(Date data){ 
		return vendaRepository.findByData(data); 
	} 
	public Venda salvaVenda(Venda venda) {     
		return vendaRepository.save(venda);     
	}
	public Venda alterarVenda(Long id, Venda alterarVenda) {  
		Optional <Venda> existeVenda = vendaRepository.findById(id);  
		if (existeVenda.isPresent()) {  
			alterarVenda.setId(id);  
			return vendaRepository.save(alterarVenda);  
		}  
		return null;  
	}  
	public boolean apagarVenda(Long id) {  
		Optional <Venda> existeVenda = vendaRepository.findById(id);  
		if (existeVenda.isPresent()) {  
			vendaRepository.deleteById(id);  
			return true;  
		}  
		return false;  
	}  
} 