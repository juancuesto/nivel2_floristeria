package com.floristeria_sql.nivel_floristeria.service;

import com.floristeria_sql.nivel_floristeria.Exception.BadRequest;
import com.floristeria_sql.nivel_floristeria.Exception.NotFoundException;
import com.floristeria_sql.nivel_floristeria.domain.Floristeria;
import com.floristeria_sql.nivel_floristeria.repositori.FloristeriaRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloristeriaServiceImpl implements FloristeriaService{
    @Autowired
    private FloristeriaRepositori floristeriaRepositori;
    @Override
    public Floristeria crearFloristeria(Floristeria floristeria) {
        if (floristeria.getNombre()==null){
            throw new BadRequest("p-505", HttpStatus.BAD_REQUEST,"Falta introducir el nombre de la Floristeria");
        }
        return floristeriaRepositori.save(floristeria);
    }

    @Override
    public Optional<Floristeria> buscarFloristeriaById(Long id) {
        Optional<Floristeria> floristeriaOptional=floristeriaRepositori.findById(id);
        if (floristeriaOptional.isEmpty()){
            throw new NotFoundException("p-404",HttpStatus.NOT_FOUND,"No se ha encontrado la floristeria");
        }
        return floristeriaOptional;
    }

    @Override
    public List<Floristeria> listarFloriterias() {
        List<Floristeria> listaFloristeria=floristeriaRepositori.findAll();
        if (listaFloristeria.isEmpty()){
            throw new NotFoundException("p-404",HttpStatus.NOT_FOUND,"No hay floristerias que mostrar");
        }
        return listaFloristeria;
    }

    @Override
    public Floristeria actualizarFloristeria(Floristeria floristeria, Long id) {
        Optional<Floristeria> floristeriaOptional=floristeriaRepositori.findById(id);
        if (floristeriaOptional.isEmpty()){
            throw new NotFoundException("p-404",HttpStatus.NOT_FOUND,"No se ha encontrado la floristeria a actualizar");
        }
        floristeriaOptional.get().setNombre(floristeria.getNombre());
        floristeriaOptional.get().setHistoricoVentas(floristeria.getHistoricoVentas());
        floristeriaOptional.get().setStockTienda(floristeria.getStockTienda());
        return floristeriaRepositori.save(floristeriaOptional.get());
    }

    @Override
    public void borrarFloristeriaById(Long id) {
        Optional<Floristeria> floristeriaOptional=floristeriaRepositori.findById(id);
        if (floristeriaOptional.isEmpty()){
            throw new NotFoundException("p-404",HttpStatus.NOT_FOUND,"No se ha encontrado la floristeria a borrar");
        }
        floristeriaRepositori.deleteById(id);
    }
}
