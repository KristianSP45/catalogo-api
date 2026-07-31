package com.kristian.catalogoapi.controller;

import com.kristian.catalogoapi.business.ProdutoService;
import com.kristian.catalogoapi.business.request.ProdutoInDTO;
import com.kristian.catalogoapi.business.response.ProdutoOutDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto")
@Tag(name = "Produtos", description = "Responsável por produto")
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoOutDTO> addProduto(@Valid @RequestBody ProdutoInDTO produtoInDTO) {
        return ResponseEntity.ok(service.salvarProduto(produtoInDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoOutDTO> buscarProdutoPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.buscarProdutoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoOutDTO> atualizarProduto(@PathVariable("id")Long id, @Valid @RequestBody ProdutoInDTO produtoInDTO) {
        return ResponseEntity.ok(service.atualizarProduto(id, produtoInDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProdutoPorId(@PathVariable("id") Long id) {
        service.deletarProdutoPorId(id);
        return ResponseEntity.noContent().build();
        // HTTP 204: operação realizada com sucesso sem retornar dados
    }
}
