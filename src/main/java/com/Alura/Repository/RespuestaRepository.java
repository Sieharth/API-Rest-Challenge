package com.Alura.Repository;

import com.forohub.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    // Métodos de consulta personalizados si es necesario
}