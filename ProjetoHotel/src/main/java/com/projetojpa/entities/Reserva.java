package com.projetojpa.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reserva")
public class Reserva {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@NotBlank
	@Column (name = "horario", nullable = false,  length = 255)
	private String horario;
	
	@NotNull
	@Column (name = "valor", nullable = false,  length = 255)
	private int valor;

	@ManyToOne
	@JoinColumn(name = "id_quarto", nullable = false)
	private Quarto quarto;
	
	@ManyToOne 
	@JoinColumn(name = "id_hospede", nullable = false)
	private Hospede hospede;
}
