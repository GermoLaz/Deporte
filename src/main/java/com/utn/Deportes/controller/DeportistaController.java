package com.utn.Deportes.controller;

import com.utn.Deportes.model.Deportista;
import com.utn.Deportes.service.DeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deportista")
public class DeportistaController {
    private DeportistaService deportistaService;

    @Autowired
    public DeportistaController (DeportistaService deportistaService){
        this.deportistaService = deportistaService;
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final Deportista deportista) {
        return deportistaService.add(deportista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deportista> findById(@PathVariable Integer id){
        return deportistaService.findById(id);
    }

    @GetMapping("/")
    public ResponseEntity<Deportista> findByDescription(@RequestParam String nombre, String apellido){
        return deportistaService.findByNombreAndApellido(nombre, apellido);
    }
}
