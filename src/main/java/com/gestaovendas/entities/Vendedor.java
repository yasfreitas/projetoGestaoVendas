package com.gestaovendas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vendedor")
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "meta", nullable = false, length = 255)
	private String meta;
	
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "salario", nullable = false)
	private double salario;
	
	@Column(name = "totalvendas", nullable = false)
	private double totalvendas;
	
	@Column(name = "setor", nullable = false, length = 255)
	private String setor;
	
	@ManyToOne
	@JoinColumn(name = "id_equipe", nullable = false)
	private Equipe equipe;

}
