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

import com.projetojpa.entities.Quarto;
import com.projetojpa.services.QuartoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/quartos")
public class QuartoController {
    
    private final QuartoService QuartoService;
    
    @Autowired
    public QuartoController(QuartoService QuartoService) {
        this.QuartoService = QuartoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quarto> getProductById(@PathVariable Long id) {
    	Quarto Quarto = QuartoService.getQuartoById(id);
        if (Quarto != null) {
            return ResponseEntity.ok(Quarto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Quarto>> getAllQuartos() {
        List<Quarto> Quartos = QuartoService.getAllQuarto();
        return ResponseEntity.ok(Quartos);
    }
    @PostMapping("/")
    public ResponseEntity<Quarto> criarQuarto(@RequestBody @Valid Quarto Quarto) {
    	Quarto criarQuarto = QuartoService.salvarQuarto(Quarto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarQuarto);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Quarto> updateQuarto(@PathVariable Long id, @RequestBody @Valid Quarto Quarto) {
    	Quarto updatedQuarto = QuartoService.updateQuarto(id, Quarto);
        if (updatedQuarto != null) {
            return ResponseEntity.ok(updatedQuarto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuarto(@PathVariable Long id) {
        boolean deleted = QuartoService.deleteQuarto(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O Quarto foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}