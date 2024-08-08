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

import com.projetojpa.entities.Reserva;
import com.projetojpa.services.ReservaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    
    private final ReservaService ReservaService;
    
    @Autowired
    public ReservaController(ReservaService ReservaService) {
        this.ReservaService = ReservaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getProductById(@PathVariable Long id) {
    	Reserva Reserva = ReservaService.getReservaById(id);
        if (Reserva != null) {
            return ResponseEntity.ok(Reserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Reserva>> getAllReservas() {
        List<Reserva> Reservas = ReservaService.getAllReserva();
        return ResponseEntity.ok(Reservas);
    }
    @PostMapping("/")
    public ResponseEntity<Reserva> criarReserva(@RequestBody @Valid Reserva Reserva) {
    	Reserva criarReserva = ReservaService.salvarReserva(Reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarReserva);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody @Valid Reserva Reserva) {
    	Reserva updatedReserva = ReservaService.updateReserva(id, Reserva);
        if (updatedReserva != null) {
            return ResponseEntity.ok(updatedReserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReserva(@PathVariable Long id) {
        boolean deleted = ReservaService.deleteReserva(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O Reserva foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}