package com.kristian.catalogoapi.business.converter;

import com.kristian.catalogoapi.business.request.ProdutoInDTO;
import com.kristian.catalogoapi.infrastructure.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProdutoUpdateMapper {

    @Mapping(target = "id", ignore = true)
    Produto updateProduto(ProdutoInDTO produtoInDTO, @MappingTarget Produto produto);
}
