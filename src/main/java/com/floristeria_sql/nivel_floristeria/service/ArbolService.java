package com.floristeria_sql.nivel_floristeria.service;

import com.floristeria_sql.nivel_floristeria.domain.Arbol;

import java.util.List;
import java.util.Optional;

public interface ArbolService {
    Arbol crearArbol(Arbol arbol);
    Optional<Arbol> buscarArbolById(Long id);
    List<Arbol> listarArboles();
    Arbol actualizarArbol(Arbol arbol,Long id);

    void deleteArbolById(Long id);
    void  deleteAllArboles();
}
