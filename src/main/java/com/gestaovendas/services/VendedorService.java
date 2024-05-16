package com.gestaovendas.services; 
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaovendas.entities.Vendedor;
import com.gestaovendas.repository.VendedorRepository; 
 
@Service 
public class VendedorService { 
	 
	private final VendedorRepository vendedorRepository;  
	@Autowired  
	public VendedorService(VendedorRepository vendedorRepository) {  
		this.vendedorRepository = vendedorRepository;  
	}  
	public List<Vendedor> buscaTodosVendedors() {  
		return vendedorRepository.findAll();  
	}  
	public Vendedor buscaVendedorId(Long id) {  
		Optional <Vendedor> vendedor = vendedorRepository.findById(id);  
		return vendedor.orElse(null);  
	}  
	public List<Vendedor> buscarVendedorsPorNome(String nome){ 
		return vendedorRepository.findByNome(nome); 
	} 
	public List<Vendedor> buscarVendedorsPorSetor(String setor){ 
		return vendedorRepository.findBySetor(setor); 
	} 
	public Vendedor salvaVendedor(Vendedor vendedor) {     
		return vendedorRepository.save(vendedor);     
	}
	public Vendedor alterarVendedor(Long id, Vendedor alterarVendedor) {  
		Optional <Vendedor> existeVendedor = vendedorRepository.findById(id);  
		if (existeVendedor.isPresent()) {  
			alterarVendedor.setId(id);  
			return vendedorRepository.save(alterarVendedor);  
		}  
		return null;  
	}  
	public boolean apagarVendedor(Long id) {  
		Optional <Vendedor> existeVendedor = vendedorRepository.findById(id);  
		if (existeVendedor.isPresent()) {  
			vendedorRepository.deleteById(id);  
			return true;  
		}  
		return false;  
	}  
} 