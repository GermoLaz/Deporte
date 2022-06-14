package com.utn.Deportes.repository;

import com.utn.Deportes.model.Deportista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeportistaRepository extends JpaRepository<Deportista, Integer> {
    Deportista findByNombreAndApellido(String nombre, String apellido);
}
