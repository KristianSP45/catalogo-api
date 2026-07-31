package com.kristian.catalogoapi.business;

import com.kristian.catalogoapi.business.converter.ProdutoConverterMapper;
import com.kristian.catalogoapi.business.converter.ProdutoUpdateMapper;
import com.kristian.catalogoapi.business.request.ProdutoInDTO;
import com.kristian.catalogoapi.business.response.ProdutoOutDTO;
import com.kristian.catalogoapi.infrastructure.entity.Categoria;
import com.kristian.catalogoapi.infrastructure.entity.Produto;
import com.kristian.catalogoapi.infrastructure.exceptions.ResourceNotFoundException;
import com.kristian.catalogoapi.infrastructure.repository.CategoriaRepository;
import com.kristian.catalogoapi.infrastructure.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoConverterMapper mapper;
    private final ProdutoUpdateMapper updateMapper;

    public ProdutoOutDTO salvarProduto(ProdutoInDTO produtoInDTO) {
        Categoria categoria = categoriaRepository.findById(
                produtoInDTO.getCategoriaId()).orElseThrow(
                        () -> new ResourceNotFoundException("Categoria não encontrada!"));
        if (repository.existsByNomeIgnoreCase(produtoInDTO.getNome())) {
            throw new ResourceNotFoundException("Produto já cadastrado!");
        }
        Produto entity = mapper.paraEntity(produtoInDTO);
        entity.setCategoria(categoria);
        return mapper.paraDTO(repository.save(entity));
    }

    public ProdutoOutDTO buscarProdutoPorId(Long id) {
        Produto entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado!"));
        return mapper.paraDTO(entity);
    }

    @Transactional//Descobri depois de varios projetos que essa anotação não é no repository
    public ProdutoOutDTO atualizarProduto(Long id, ProdutoInDTO produtoInDTO) {
        Categoria categoria = categoriaRepository.findById(
                produtoInDTO.getCategoriaId()).orElseThrow(
                () -> new ResourceNotFoundException("Categoria não encontrada!"));
        Produto entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado!"));
        updateMapper.updateProduto(produtoInDTO, entity);
        entity.setCategoria(categoria);
        return mapper.paraDTO(entity);
    }

    @Transactional
    public void deletarProdutoPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Id não encontrado!");
        }
        repository.deleteById(id);
    }
}
