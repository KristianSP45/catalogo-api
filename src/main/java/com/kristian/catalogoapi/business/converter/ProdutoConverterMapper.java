package com.kristian.catalogoapi.business.converter;

import com.kristian.catalogoapi.business.request.CategoriaInDTO;
import com.kristian.catalogoapi.business.request.ProdutoInDTO;
import com.kristian.catalogoapi.business.response.ProdutoOutDTO;
import com.kristian.catalogoapi.infrastructure.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProdutoConverterMapper {

    @Mapping(target = "id", ignore = true)
    Produto paraEntity(ProdutoInDTO produtoInDTO);

    @Mapping(target = "categoria", source = "categoria.nome")
    ProdutoOutDTO paraDTO(Produto produto);
}
