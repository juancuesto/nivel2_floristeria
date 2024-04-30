package com.floristeria_sql.nivel_floristeria.service;
import com.floristeria_sql.nivel_floristeria.domain.Decoracion;


import java.util.List;
import java.util.Optional;

public interface DecoracionService {
    Decoracion crearDecoracion(Decoracion decoracion);
    Optional<Decoracion> buscarDecoracionById(Long id);
    List<Decoracion> listarDecoracions();
    Decoracion actualizarDecoracion(Decoracion decoracion, Long id);

    void deleteDecoracionById(Long id);
    void  deleteAllDecoraciones();
}
