package com.utn.Deportes.service.impl;

import com.utn.Deportes.model.Basketbolista;
import com.utn.Deportes.model.Deportista;
import com.utn.Deportes.model.Futbolista;
import com.utn.Deportes.repository.DeportistaRepository;
import com.utn.Deportes.service.DeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static com.utn.Deportes.util.EntityURLBuilder.buildURL;

@Service
public class DeportistaServiceImpl implements DeportistaService {
    private final String PATH = "deportista";

    private DeportistaRepository deportistaRepository;

    @Autowired
    public DeportistaServiceImpl(DeportistaRepository deportistaRepository) {
        this.deportistaRepository = deportistaRepository;
    }

    @Override
    public ResponseEntity<Deportista> findById(Integer id) {
        Deportista deportista = deportistaRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT, "This athlete not exist"));
        return ResponseEntity.status(HttpStatus.OK)
                .body(deportista);
    }

    @Override
    public ResponseEntity add(Deportista deportista) throws HttpClientErrorException{
        if(findByNombreAndApellido(deportista.getNombre(), deportista.getApellido()).getBody() != null)
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Athlete Already Exist");

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL("PATH",deportistaRepository.save(deportista).getId().toString())).build(); //.header()
    }

    @Override
    public ResponseEntity<Deportista> findByNombreAndApellido(String nombre, String apellido){
        Deportista deportista = deportistaRepository.findByNombreAndApellido(nombre, apellido);
        return deportista == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(deportista);
    }

    @Override
    public ResponseEntity<Integer> getTotalGoles(String nombre, String apellido){
        return ResponseEntity.status(HttpStatus.OK).body(((Futbolista) findByNombreAndApellido(nombre, apellido).getBody()).getTotalGoles());
    }
    @Override
    public ResponseEntity<Integer> getTotalPuntos(String nombre, String apellido){
        return ResponseEntity.status(HttpStatus.OK).body(((Basketbolista) findByNombreAndApellido(nombre, apellido).getBody()).getPuntos());
    }

    @Override
    public ResponseEntity sumarGoles(String nombre, String apellido, Integer goles, String type){
        Futbolista futbolista = (Futbolista) findByNombreAndApellido(nombre, apellido).getBody();
        switch (type) {
            case "penal":
                futbolista.setPenal(futbolista.getPenal() + goles);
                break;
            case "cabeza":
                futbolista.setCabeza(futbolista.getCabeza() + goles);
                break;
            case "tiroLibre":
                futbolista.setTotalGoles(futbolista.getTiroLibre() + goles);
                break;
            default:
                futbolista.setTotalGoles(futbolista.getTotalGoles() + goles);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .location(buildURL("PATH",deportistaRepository.save(futbolista).getId().toString())).build();
    }
    @Override
    public ResponseEntity sumarPuntos(String nombre, String apellido, Integer puntos){
        Basketbolista basketbolista = (Basketbolista) findByNombreAndApellido(nombre, apellido).getBody();
        basketbolista.setPuntos(basketbolista.getPuntos() + puntos);
        return ResponseEntity.status(HttpStatus.OK)
                .location(buildURL("PATH",deportistaRepository.save(basketbolista).getId().toString())).build();
    }
}
