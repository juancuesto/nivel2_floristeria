package com.floristeria_sql.nivel_floristeria.controller;

import com.floristeria_sql.nivel_floristeria.Exception.NotFoundException;
import com.floristeria_sql.nivel_floristeria.domain.Arbol;
import com.floristeria_sql.nivel_floristeria.domain.Flor;
import com.floristeria_sql.nivel_floristeria.service.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/floristeria")
public class FlorController {

    @Autowired
    private FlorService florService;

    @PostMapping("/crear_flor")
    public ResponseEntity<?> crearFlor(@RequestBody Flor flor){
        return new ResponseEntity<>(florService.crearFlor(flor), HttpStatus.CREATED);
    }
    @GetMapping("/buscar_flor/{id}")
    public ResponseEntity<?> buscarFlorById(@PathVariable Long id){
        Optional<Flor> florOptional=florService.buscarFlorById(id);
        if (florOptional.isEmpty()){
            return new ResponseEntity<>("Error al buscar la flor",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(florOptional.get(),HttpStatus.FOUND);
    }
    @GetMapping("/listar_flores")
    public ResponseEntity<?> listarArboles(){
        try{
            List<Flor> listaFlores=florService.listarFlores();
            if (listaFlores.isEmpty()){
                return new ResponseEntity<>("No hay flores que mostrar",HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(listaFlores,HttpStatus.FOUND);
        }catch (NotFoundException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("No hay flores en base de datos",HttpStatus.NOT_FOUND);
        }


    }
    @PutMapping("/actualizar_flor/{id}")
    public ResponseEntity<?> actualuzarArbol(@RequestBody Flor flor,@PathVariable Long id){
        Optional<Flor> florOptional=florService.buscarFlorById(id);
        if (florOptional.isEmpty()){
            return new ResponseEntity<>("No se ha encontrado la flor a actualizar",HttpStatus.NOT_FOUND);
        }
        florOptional.get().setColor(flor.getColor());
        florOptional.get().setPrecio(flor.getPrecio());

        return new ResponseEntity<>(florService.crearFlor(florOptional.get()),HttpStatus.OK);
    }
    @DeleteMapping("/borrar_flor/{id}")
    public ResponseEntity<?> borrarArbol(@PathVariable Long id){
            Optional<Flor> florOptional=florService.buscarFlorById(id);
            if (florOptional.isEmpty()){
                return new ResponseEntity<>("No se ha encontrado la flor a borrar",HttpStatus.NOT_FOUND);
            }
            florService.deleteFlorById(id);
            return new ResponseEntity<>("Flor borrado correctamente",HttpStatus.OK);


    }
    @DeleteMapping("/borrar_flores")
    public ResponseEntity<?> borrarTodosLosFlores(){
        florService.deleteAllFlores();
        return new ResponseEntity<>("Se han borrado todas las flores correctamente",HttpStatus.OK);
    }

}
