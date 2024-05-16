package com.gestaovendas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "descricao", nullable = false, length = 255)
	private String descricao;
	
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "preco", nullable = false)
	private double preco;
	
	@Column(name = "qntde", nullable = false, length = 255)
	private String qntde;
	
	
	
	

}
