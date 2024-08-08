package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Quarto;
import com.projetojpa.repository.QuartoRepository;

@Service
public class QuartoService {
		private final QuartoRepository QuartoRepository;
	    @Autowired
	    public QuartoService(QuartoRepository QuartoRepository) {
	        this.QuartoRepository = QuartoRepository;
	    }

	    public List<Quarto> getAllQuarto() {
	        return QuartoRepository.findAll();
	    }

	    public Quarto getQuartoById(Long id) {
	        Optional<Quarto> Quarto = QuartoRepository.findById(id);
	        return Quarto.orElse(null);
	    }

	    public Quarto salvarQuarto(Quarto Quarto) {
	        return QuartoRepository.save(Quarto);
	    }

	    public Quarto updateQuarto(Long id, Quarto updatedQuarto) {
	        Optional<Quarto> existingQuarto = QuartoRepository.findById(id);
	        if (existingQuarto.isPresent()) {
	            updatedQuarto.setId(id);
	            return QuartoRepository.save(updatedQuarto);
	        }
	        return null;
	    }
	    public boolean deleteQuarto(Long id) {
	        Optional<Quarto> existingQuarto = QuartoRepository.findById(id);
	        if (existingQuarto.isPresent()) {
	        	QuartoRepository.deleteById(id);
	           return true;
	        }
	        return false;
	    }
	}


