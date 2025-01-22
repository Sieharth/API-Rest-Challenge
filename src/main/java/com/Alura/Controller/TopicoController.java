package com.Alura.Controller;

import com.Alura.Model.Topico;
import com.Alura.Repository.Repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    // Crear un nuevo tópico
    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody Topico topico) {
        Topico nuevoTopico = topicoRepository.save(topico);
        return ResponseEntity.ok(nuevoTopico);
    }

    // Mostrar todos los tópicos
    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        List<Topico> topicos = topicoRepository.findAll();
        return ResponseEntity.ok(topicos);
    }

    // Mostrar un tópico específico
    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopico(@PathVariable Long id) {
        Optional<Topico> topicoOpt = topicoRepository.findById(id);
        return topicoOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un tópico
    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody Topico topicoActualizado) {
        return topicoRepository.findById(id).map(topico -> {
            topico.setTitulo(topicoActualizado.getTitulo());
            topico.setMensaje(topicoActualizado.getMensaje());
            topico.setAutor(topicoActualizado.getAutor());
            topicoRepository.save(topico);
            return ResponseEntity.ok(topico);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un tópico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}