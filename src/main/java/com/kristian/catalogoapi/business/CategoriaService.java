package com.kristian.catalogoapi.business;

import com.kristian.catalogoapi.business.converter.CategoriaConverterMapper;
import com.kristian.catalogoapi.business.converter.CategoriaUpdateMapper;
import com.kristian.catalogoapi.business.request.CategoriaInDTO;
import com.kristian.catalogoapi.business.response.CategoriaOutDTO;
import com.kristian.catalogoapi.infrastructure.entity.Categoria;
import com.kristian.catalogoapi.infrastructure.exceptions.ResourceNotFoundException;
import com.kristian.catalogoapi.infrastructure.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaConverterMapper mapper;
    private final CategoriaUpdateMapper updateMapper;

    public CategoriaOutDTO salvarCategoria(CategoriaInDTO categoriaInDTO) {
        if (repository.existsByNomeIgnoreCase(categoriaInDTO.getNome())) {
            throw new ResourceNotFoundException("Categoria já cadastrada!");
        }
        Categoria entity = mapper.paraEntity(categoriaInDTO);
        return mapper.paraDTO(repository.save(entity));
    }

    public CategoriaOutDTO buscarCategoriaPorId(Long id) {
        Categoria entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado!"));
        return mapper.paraDTO(entity);
    }

    @Transactional
    public CategoriaOutDTO atualizarCategoria(Long id, CategoriaInDTO categoriaInDTO) {
        Categoria entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado!"));
        updateMapper.updateCategoria(categoriaInDTO,entity);
        return mapper.paraDTO(repository.save(entity));
    }

    @Transactional
    public void deletarCategoriaPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Id não encontrado!");
        }
            repository.deleteById(id);
    }
}
