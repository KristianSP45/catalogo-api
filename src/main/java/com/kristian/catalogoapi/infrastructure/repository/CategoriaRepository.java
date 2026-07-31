package com.kristian.catalogoapi.infrastructure.repository;

import com.kristian.catalogoapi.infrastructure.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    Categoria save(Categoria categoria);

    Optional<Categoria> findById(Long id);

    boolean existsById(Long id);

    boolean existsByNomeIgnoreCase(String nome);

    void deleteById(Long id);
}
