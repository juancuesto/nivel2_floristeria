package com.floristeria_sql.nivel_floristeria.service;

import com.floristeria_sql.nivel_floristeria.domain.Floristeria;

import java.util.List;
import java.util.Optional;

public interface FloristeriaService {
    Floristeria crearFloristeria(Floristeria floristeria);
    Optional<Floristeria> buscarFloristeriaById(Long id);
    List<Floristeria> listarFloriterias();
    Floristeria actualizarFloristeria(Floristeria floristeria,Long id);
    void borrarFloristeriaById(Long id);
}
