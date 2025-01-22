package com.Alura.Repository;

import com.forohub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    // Métodos de consulta personalizados si es necesario
}