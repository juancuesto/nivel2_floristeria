package com.floristeria_sql.nivel_floristeria.controller;

import com.floristeria_sql.nivel_floristeria.domain.Floristeria;
import com.floristeria_sql.nivel_floristeria.service.FloristeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FloristeriaController {
    @Autowired
    private FloristeriaService floristeriaService;

    @PostMapping("/crear_floristeria")
    public ResponseEntity<?> crearFloristeria(@RequestBody Floristeria floristeria){
        return new ResponseEntity<>(floristeriaService.crearFloristeria(floristeria), HttpStatus.CREATED);
    }
    @GetMapping("/buscar_floristeria/{id}")
    public ResponseEntity<?> buscarFloristeriaById(@PathVariable Long id){
        Optional<Floristeria> floristeriaOptional=floristeriaService.buscarFloristeriaById(id);
        if (floristeriaOptional.isEmpty()){
            return new ResponseEntity<>("No se ha encontardo la floristeria",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(floristeriaOptional,HttpStatus.FOUND);
    }
    @GetMapping("/listar_floristerias")
    public ResponseEntity<?> listarFloristerias(){
        List<Floristeria> listadoFloristerias=floristeriaService.listarFloriterias();
        if (listadoFloristerias.isEmpty()){
            return new ResponseEntity<>("No hay ninguna floristeria que mostrar",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listadoFloristerias,HttpStatus.OK);
    }

    @DeleteMapping("/borrar_floristeria/{id}")
    public ResponseEntity<?> borrarFloristeria(@PathVariable Long id){
        Optional<Floristeria> floristeriaOptional=floristeriaService.buscarFloristeriaById(id);
        if (floristeriaOptional.isEmpty()){
            return new ResponseEntity<>("No se ha encontardo la floristeria a borrar",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Floristeria borrada correctamente",HttpStatus.OK);
    }
}
