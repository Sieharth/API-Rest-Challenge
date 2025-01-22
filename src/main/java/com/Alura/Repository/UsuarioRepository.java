package com.Alura.Repository;

import com.forohub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos de consulta personalizados si es necesario
}