package com.kristian.catalogoapi.infrastructure.repository;

import com.kristian.catalogoapi.infrastructure.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto save(Produto produto);

    Optional<Produto> findById(Long id);

    boolean existsById(Long id);

    boolean existsByNomeIgnoreCase(String nome);

    void deleteById(Long id);
}
