package com.kristian.catalogoapi.business.converter;

import com.kristian.catalogoapi.business.request.CategoriaInDTO;
import com.kristian.catalogoapi.infrastructure.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoriaUpdateMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "produto", ignore = true)
    Categoria updateCategoria(CategoriaInDTO categoriaInDTO, @MappingTarget Categoria categoria);
}
