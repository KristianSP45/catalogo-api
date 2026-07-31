package com.kristian.catalogoapi.business.converter;

import com.kristian.catalogoapi.business.request.CategoriaInDTO;
import com.kristian.catalogoapi.business.response.CategoriaOutDTO;
import com.kristian.catalogoapi.infrastructure.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CategoriaConverterMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "produto", ignore = true)
    Categoria paraEntity(CategoriaInDTO categoriaInDTO);

    CategoriaOutDTO paraDTO(Categoria categoria);
}
