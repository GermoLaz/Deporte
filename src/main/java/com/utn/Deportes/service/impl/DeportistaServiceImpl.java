package com.utn.Deportes.service.impl;

import com.utn.Deportes.model.Deportista;
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
}
