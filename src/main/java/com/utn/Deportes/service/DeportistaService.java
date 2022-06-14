package com.utn.Deportes.service;

import com.utn.Deportes.model.Deportista;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

public interface DeportistaService {
    /**
     * Add a athlete
     *
     * @param deportista
     * @return A ResponseEntity with the url
     */
    ResponseEntity add(Deportista deportista) throws HttpClientErrorException;

    /**
     * Find athletes by id
     *
     * @param id filters the athletes by id
     * @return An athlete
     */
    ResponseEntity<Deportista> findById(Integer id);
    /**
     * Find athletes by name and lastname
     *
     * @param nombre filters the athletes by name
     * @param apellido filters the athletes by lastname
     * @return An athlete
     */
    ResponseEntity<Deportista> findByNombreAndApellido(String nombre, String apellido);

    /**
     * Get goles by name and lastname
     *
     * @param nombre filters the athletes by name
     * @param apellido filters the athletes by lastname
     * @return An Integer
     */
    ResponseEntity<Integer> getTotalGoles(String nombre, String apellido);
    /**
     * Get puntos by name and lastname
     *
     * @param nombre filters the athletes by name
     * @param apellido filters the athletes by lastname
     * @return An Integer
     */
    ResponseEntity<Integer> getTotalPuntos(String nombre, String apellido);
    /**
     * Set puntos by name and lastname
     *
     * @param nombre filters the athletes by name
     * @param apellido filters the athletes by lastname
     * @param puntos puntos to add
     * @return A ResponseEntity with the url
     */
    ResponseEntity sumarPuntos(String nombre, String apellido, Integer puntos);
    /**
     * Set puntos by name and lastname
     *
     * @param nombre filters the athletes by name
     * @param apellido filters the athletes by lastname
     * @param goles goles to add
     * @param type type of goal
     * @return A ResponseEntity with the url
     */
    ResponseEntity sumarGoles(String nombre, String apellido, Integer goles, String type);
}
