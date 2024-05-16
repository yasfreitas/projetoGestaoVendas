package com.gestaovendas.entities;

import java.sql.Date;

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
@Table(name = "venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "data", nullable = false, length = 255)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "id_produto", nullable = false)
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "id_vendedor", nullable = false)
	private Vendedor vendedor;

}
