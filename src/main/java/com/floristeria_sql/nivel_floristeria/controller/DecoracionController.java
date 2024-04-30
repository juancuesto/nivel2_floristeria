package com.floristeria_sql.nivel_floristeria.controller;

import com.floristeria_sql.nivel_floristeria.Exception.BadRequest;
import com.floristeria_sql.nivel_floristeria.Exception.NotFoundException;
import com.floristeria_sql.nivel_floristeria.domain.Decoracion;
import com.floristeria_sql.nivel_floristeria.service.DecoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Optional;

@RestController
@RequestMapping("/floristeria")
public class DecoracionController {
    @Autowired
    private DecoracionService decoracionService;

    @PostMapping("/crear_decoracion")
    public ResponseEntity<?> crearDecoracion(@RequestBody Decoracion decoracion){
        return new ResponseEntity<>(decoracionService.crearDecoracion(decoracion), HttpStatus.CREATED);
    }
    @GetMapping("/buscar_decoracion/{id}")
    public ResponseEntity<?> buscarDecoracionById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(decoracionService.buscarDecoracionById(id),HttpStatus.FOUND);
        }catch (NotFoundException e){
            return new ResponseEntity<>("No se ha encontrado la decoracion",HttpStatus.NOT_FOUND);
        }catch (BadRequest e){
            return new ResponseEntity<>("Falta introducir el id",HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/actualizar_decoracion/{id}")
    private ResponseEntity<?> actualizarDecoracion(@RequestBody Decoracion decoracion,@PathVariable Long id){
        Optional<Decoracion> decoracionOptional=decoracionService.buscarDecoracionById(id);
        if (decoracionOptional.isEmpty()){
            return new ResponseEntity<>("No se ha encontrado la decoracion a actualizar",HttpStatus.NOT_FOUND);
        }
        decoracionOptional.get().setMaterial(decoracion.getMaterial());
        decoracionOptional.get().setPrecio(decoracion.getPrecio());

        return new ResponseEntity<>(decoracionService.crearDecoracion(decoracion),HttpStatus.OK);
    }
    @GetMapping("/listar_decoraciones")
    public ResponseEntity<?> listarDecoraciones(){
        return new ResponseEntity<>(decoracionService.listarDecoracions(),HttpStatus.OK);
    }
    @DeleteMapping("/borrar_decoracion/{id}")
    public ResponseEntity<?> borrarDecoracion(@PathVariable Long id){
        decoracionService.deleteDecoracionById(id);
        return new ResponseEntity<>("Decoracion borrada correctamente",HttpStatus.OK);
    }
    @DeleteMapping("/borrar_decoraciones")
    public ResponseEntity<?> borrarAllDEcoraciones(){
        decoracionService.deleteAllDecoraciones();
        return new ResponseEntity<>("Todas las decoraciones borradas correctamente",HttpStatus.OK);
    }

}
