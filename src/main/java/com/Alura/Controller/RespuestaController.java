package com.Alura.Controller;

import com.Alura.Model.Respuesta;
import com.Alura.Repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    // Crear una nueva respuesta
    @PostMapping
    public ResponseEntity<Respuesta> crearRespuesta(@RequestBody Respuesta respuesta) {
        Respuesta nuevaRespuesta = respuestaRepository.save(respuesta);
        return ResponseEntity.ok(nuevaRespuesta);
    }

    // Listar todas las respuestas
    @GetMapping
    public ResponseEntity<List<Respuesta>> listarRespuestas() {
        List<Respuesta> respuestas = respuestaRepository.findAll();
        return ResponseEntity.ok(respuestas);
    }

    // Mostrar una respuesta específica
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerRespuesta(@PathVariable Long id) {
        Optional<Respuesta> respuestaOpt = respuestaRepository.findById(id);
        return respuestaOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}