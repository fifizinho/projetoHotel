package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.Reserva;
	
	public interface ReservaRepository extends JpaRepository<Reserva, Long>{ 

	}

