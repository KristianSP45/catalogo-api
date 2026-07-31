package com.kristian.catalogoapi.controller;

import com.kristian.catalogoapi.business.CategoriaService;
import com.kristian.catalogoapi.business.request.CategoriaInDTO;
import com.kristian.catalogoapi.business.response.CategoriaOutDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
@Tag(name = "Categoria", description = "Responsável por categoria")
public class CategoriaController {

    private final CategoriaService service;

    @PostMapping
    public ResponseEntity<CategoriaOutDTO> salvarCategoria(@Valid @RequestBody CategoriaInDTO categoriaInDTO) {
        return  ResponseEntity.ok().body(service.salvarCategoria(categoriaInDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaOutDTO> buscarCategoriaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.buscarCategoriaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaOutDTO> atualizarCategoria(@PathVariable("id") Long id, @Valid @RequestBody CategoriaInDTO categoriaInDTO) {
        return ResponseEntity.ok().body(service.atualizarCategoria(id, categoriaInDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoriaPorId(@PathVariable("id") Long id) {
        service.deletarCategoriaPorId(id);
        return ResponseEntity.noContent().build();
    }
}
