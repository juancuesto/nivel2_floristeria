package com.floristeria_sql.nivel_floristeria.service;

import com.floristeria_sql.nivel_floristeria.domain.Flor;

import java.util.List;
import java.util.Optional;

public interface FlorService {
    Flor crearFlor(Flor flor);
    Optional<Flor> buscarFlorById(Long id);
    List<Flor> listarFlores();
    Flor actualizarFlor(Flor flor,Long id);

    void deleteFlorById(Long id);
    void  deleteAllFlores();
}
