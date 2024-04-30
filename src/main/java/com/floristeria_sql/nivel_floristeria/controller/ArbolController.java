package com.floristeria_sql.nivel_floristeria.controller;

import com.floristeria_sql.nivel_floristeria.domain.Arbol;


import com.floristeria_sql.nivel_floristeria.domain.Decoracion;
import com.floristeria_sql.nivel_floristeria.domain.Flor;
import com.floristeria_sql.nivel_floristeria.service.ArbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/floristeria")
public class ArbolController {
    @Autowired
    private ArbolService arbolService;

    @PostMapping("/crear_arbol")
    public ResponseEntity<?> crearArbol(@RequestBody Arbol arbol){
        return new ResponseEntity<>(arbolService.crearArbol(arbol),HttpStatus.CREATED);
    }
    @GetMapping("/buscar_arbol/{id}")
    public ResponseEntity<?> buscarArbolById(@PathVariable Long id){
        Optional<Arbol> arbolOptional=arbolService.buscarArbolById(id);
        if (arbolOptional.isEmpty()){
            return new ResponseEntity<>("Error al buscar el arbol",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(arbolOptional.get(),HttpStatus.FOUND);
    }
    @GetMapping("/listar_arboles")
    public ResponseEntity<?> listarArboles(){
        List<Arbol> listaArboles=arbolService.listarArboles();
        if (listaArboles.isEmpty()){
            return new ResponseEntity<>("No hay arboles que mostrar",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listaArboles,HttpStatus.FOUND);
    }
    @PutMapping("/actualizar_arbol/{id}")
    public ResponseEntity<?> actualuzarArbol(@RequestBody Arbol arbol,@PathVariable Long id){
        Optional<Arbol> arbolOptional=arbolService.buscarArbolById(id);
        if (arbolOptional.isEmpty()){
            return new ResponseEntity<>("No se ha encontrado el arbol a actualizar",HttpStatus.NOT_FOUND);
        }
        arbolOptional.get().setAltura(arbol.getAltura());
        arbolOptional.get().setPrecio(arbol.getPrecio());

        return new ResponseEntity<>(arbolService.crearArbol(arbolOptional.get()),HttpStatus.OK);
    }
    @DeleteMapping("/borrar_arbol/{id}")
    public ResponseEntity<?> borrarArbol(@PathVariable Long id){
        Optional<Arbol> arbolOptional=arbolService.buscarArbolById(id);
        if (arbolOptional.isEmpty()){
            return new ResponseEntity<>("No se ha encontrado el arbol a borrar",HttpStatus.NOT_FOUND);
        }
        arbolService.deleteArbolById(id);
        return new ResponseEntity<>("Arbol borrado correctamente",HttpStatus.OK);
    }
    @DeleteMapping("/borrar_arboles")
    public ResponseEntity<?> borrarTodosLosArboles(){
        arbolService.deleteAllArboles();
        return new ResponseEntity<>("Se han borradotodos kos arboles correctamente",HttpStatus.OK);
    }

}
