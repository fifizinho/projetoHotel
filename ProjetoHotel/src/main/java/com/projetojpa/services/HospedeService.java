package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Hospede;
import com.projetojpa.repository.HospedeRepository;

@Service
public class HospedeService {
		private final HospedeRepository HospedeRepository;
	    @Autowired
	    public HospedeService(HospedeRepository HospedeRepository) {
	        this.HospedeRepository = HospedeRepository;
	    }

	    public List<Hospede> getAllHospede() {
	        return HospedeRepository.findAll();
	    }

	    public Hospede getHospedeById(Long id) {
	        Optional<Hospede> Hospede = HospedeRepository.findById(id);
	        return Hospede.orElse(null);
	    }

	    public Hospede salvarHospede(Hospede Hospede) {
	        return HospedeRepository.save(Hospede);
	    }

	    public Hospede updateHospede(Long id, Hospede updatedHospede) {
	        Optional<Hospede> existingHospede = HospedeRepository.findById(id);
	        if (existingHospede.isPresent()) {
	            updatedHospede.setId(id);
	            return HospedeRepository.save(updatedHospede);
	        }
	        return null;
	    }
	    public boolean deleteHospede(Long id) {
	        Optional<Hospede> existingHospede = HospedeRepository.findById(id);
	        if (existingHospede.isPresent()) {
	        	HospedeRepository.deleteById(id);
	           return true;
	        }
	        return false;
	    }
	}


