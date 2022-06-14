package com.utn.Deportes.controller;

import com.utn.Deportes.model.Deportista;
import com.utn.Deportes.service.DeportistaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Post a athlete")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "CREATED"),
                @ApiResponse(code = 409, message = "CONFLICT")
        })
    @PostMapping("/")
    public ResponseEntity add(@RequestBody final Deportista deportista) {
        return deportistaService.add(deportista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deportista> findById(@PathVariable Integer id){
        return deportistaService.findById(id);
    }

    @GetMapping("/")
    public ResponseEntity<Deportista> findByNombreAndApellido(@RequestParam String nombre, String apellido){
        return deportistaService.findByNombreAndApellido(nombre, apellido);
    }
    @GetMapping("/goles")
    public ResponseEntity<Integer> getTotalGoles(@RequestParam String nombre, String apellido){
        return deportistaService.getTotalGoles(nombre, apellido);
    }
    @GetMapping("/puntos")
    public ResponseEntity<Integer> getTotalPuntos(@RequestParam String nombre, String apellido){
        return deportistaService.getTotalPuntos(nombre, apellido);
    }
    @PatchMapping("/sumaGoles")
    public ResponseEntity setGoles(@RequestParam String nombre, String apellido, Integer goles, String type){
        return deportistaService.sumarGoles(nombre, apellido, goles, type);
    }
    @PatchMapping("/sumaPuntos")
    public ResponseEntity setPuntos(@RequestParam String nombre, String apellido, Integer puntos){
        return deportistaService.sumarPuntos(nombre, apellido, puntos);
    }
}
