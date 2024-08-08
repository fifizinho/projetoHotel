package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Reserva;
import com.projetojpa.repository.ReservaRepository;

@Service
public class ReservaService {
		private final ReservaRepository ReservaRepository;
	    @Autowired
	    public ReservaService(ReservaRepository ReservaRepository) {
	        this.ReservaRepository = ReservaRepository;
	    }

	    public List<Reserva> getAllReserva() {
	        return ReservaRepository.findAll();
	    }

	    public Reserva getReservaById(Long id) {
	        Optional<Reserva> Reserva = ReservaRepository.findById(id);
	        return Reserva.orElse(null);
	    }

	    public Reserva salvarReserva(Reserva Reserva) {
	        return ReservaRepository.save(Reserva);
	    }

	    public Reserva updateReserva(Long id, Reserva updatedReserva) {
	        Optional<Reserva> existingReserva = ReservaRepository.findById(id);
	        if (existingReserva.isPresent()) {
	            updatedReserva.setId(id);
	            return ReservaRepository.save(updatedReserva);
	        }
	        return null;
	    }
	    public boolean deleteReserva(Long id) {
	        Optional<Reserva> existingReserva = ReservaRepository.findById(id);
	        if (existingReserva.isPresent()) {
	        	ReservaRepository.deleteById(id);
	           return true;
	        }
	        return false;
	    }
	}


