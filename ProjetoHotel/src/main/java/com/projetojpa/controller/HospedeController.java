package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Hospede;
import com.projetojpa.services.HospedeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {
    
    private final HospedeService HospedeService;
    
    @Autowired
    public HospedeController(HospedeService HospedeService) {
        this.HospedeService = HospedeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> getProductById(@PathVariable Long id) {
    	Hospede Hospede = HospedeService.getHospedeById(id);
        if (Hospede != null) {
            return ResponseEntity.ok(Hospede);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Hospede>> getAllHospedes() {
        List<Hospede> Hospedes = HospedeService.getAllHospede();
        return ResponseEntity.ok(Hospedes);
    }
    @PostMapping("/")
    public ResponseEntity<Hospede> criarHospede(@RequestBody @Valid Hospede Hospede) {
    	Hospede criarHospede = HospedeService.salvarHospede(Hospede);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarHospede);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Hospede> updateHospede(@PathVariable Long id, @RequestBody @Valid Hospede Hospede) {
    	Hospede updatedHospede = HospedeService.updateHospede(id, Hospede);
        if (updatedHospede != null) {
            return ResponseEntity.ok(updatedHospede);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHospede(@PathVariable Long id) {
        boolean deleted = HospedeService.deleteHospede(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O Hospede foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}