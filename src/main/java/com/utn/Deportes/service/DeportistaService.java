package com.utn.Deportes.service;

import com.utn.Deportes.model.Deportista;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

public interface DeportistaService {
    ResponseEntity add(Deportista deportista) throws HttpClientErrorException;
    ResponseEntity<Deportista> findById(Integer id);
    ResponseEntity<Deportista> findByNombreAndApellido(String nombre, String apellido);
}
