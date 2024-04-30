package com.floristeria_sql.nivel_floristeria.service;

import com.floristeria_sql.nivel_floristeria.Exception.BadRequest;
import com.floristeria_sql.nivel_floristeria.Exception.NotFoundException;
import com.floristeria_sql.nivel_floristeria.domain.Arbol;
import com.floristeria_sql.nivel_floristeria.domain.Decoracion;
import com.floristeria_sql.nivel_floristeria.domain.Flor;
import com.floristeria_sql.nivel_floristeria.repositori.ArbolRepositori;
import com.floristeria_sql.nivel_floristeria.repositori.DecoracionRepositori;
import com.floristeria_sql.nivel_floristeria.repositori.FlorRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArbolService, FlorService, DecoracionService {

    @Autowired
    private ArbolRepositori arbolRepositori;
    @Autowired
    private FlorRepositori florRepositori;
    @Autowired
    private DecoracionRepositori decoracionRepositori;


    @Override
    public Flor crearFlor(Flor flor) {
        if(flor.getColor()==null){
            throw  new BadRequest("p-505",HttpStatus.BAD_REQUEST,"Falta introducir el color");
        } else if (flor.getPrecio()==null){
            throw  new BadRequest("p-505",HttpStatus.BAD_REQUEST,"Falta introducir el precio");
        }
        return florRepositori.save(flor);
    }

    @Override
    public Optional<Flor> buscarFlorById(Long id) {
        Optional<Flor> florOptional=florRepositori.findById(id);
        if (florOptional.isEmpty()) {
            throw new NotFoundException("p-401" , HttpStatus.NOT_FOUND, "La flor no existe en base de datos");
        }
        return florOptional;
    }

    @Override
    public List<Flor> listarFlores() {
        List<Flor> listaFlores=florRepositori.findAll();
        if (listaFlores.isEmpty()){
            throw new NotFoundException("p-401" , HttpStatus.NOT_FOUND, "no existe ninguna flor en base de datos");
        }
        return listaFlores;
    }

    @Override
    public Flor actualizarFlor(Flor flor, Long id) {
        Optional<Flor> florOptional=florRepositori.findById(id);
        if (florOptional.isEmpty()){
            throw new NotFoundException("p-401" , HttpStatus.NOT_FOUND, "no existe esta flor en base de datos");
        }
        florOptional.get().setColor(flor.getColor());
        florOptional.get().setPrecio(flor.getPrecio());
        return florRepositori.save(florOptional.get());
    }

    @Override
    public void deleteFlorById(Long id) {
        Optional<Flor> florOptional=florRepositori.findById(id);
        if (florOptional.isEmpty()) {
            throw new NotFoundException("p-401" , HttpStatus.BAD_REQUEST, "El articulo no existe en base de datos");
        }
        florRepositori.deleteById(id);
    }

    @Override
    public void deleteAllFlores() {
        florRepositori.deleteAll();
    }

    @Override
    public Decoracion crearDecoracion(Decoracion decoracion) {
        if(decoracion.getMaterial()==null){
            throw  new BadRequest("p-505",HttpStatus.BAD_REQUEST,"Falta introducir el maretial");
        }
        if (decoracion.getPrecio()==null){
            throw  new BadRequest("p-505",HttpStatus.BAD_REQUEST,"Falta introducir el precio");

        }
        return decoracionRepositori.save(decoracion);
    }

    @Override
    public Optional<Decoracion> buscarDecoracionById(Long id) {
        Optional<Decoracion> decoracionOptional=decoracionRepositori.findById(id);
        if (decoracionOptional.isEmpty()) {
            throw new NotFoundException("p-401" , HttpStatus.NOT_FOUND, "La decoracion no existe en base de datos");
        }
        if (id==null){
            throw new BadRequest("p-505",HttpStatus.BAD_REQUEST,"falta introducir el Id");
        }
        return decoracionOptional;
    }

    @Override
    public List<Decoracion> listarDecoracions() {
        List<Decoracion> listaDecoraciones=decoracionRepositori.findAll();
        if (listaDecoraciones.isEmpty()){
            throw new NotFoundException("p-401" , HttpStatus.NOT_FOUND, "no existe ninguna decoracion en base de datos");
        }
        return listaDecoraciones;
    }

    @Override
    public Decoracion actualizarDecoracion(Decoracion decoracion, Long id) {
        Optional<Decoracion> decoracionOptional=decoracionRepositori.findById(id);
        if (decoracionOptional.isEmpty()){
            throw new NotFoundException("p-401" , HttpStatus.NOT_FOUND, "no existe esta flor en base de datos");
        }
        decoracionOptional.get().setMaterial(decoracion.getMaterial());
        decoracionOptional.get().setPrecio(decoracion.getPrecio());
        return decoracionRepositori.save(decoracionOptional.get());
    }

    @Override
    public void deleteDecoracionById(Long id) {
        Optional<Decoracion> decoracionOptional=decoracionRepositori.findById(id);
        if (decoracionOptional.isEmpty()) {
            throw new NotFoundException("p-401" , HttpStatus.BAD_REQUEST, "La decoracion no existe en base de datos");
        }
        decoracionRepositori.deleteById(id);
    }

    @Override
    public void deleteAllDecoraciones() {
        decoracionRepositori.deleteAll();
    }

    @Override
    public Arbol crearArbol(Arbol arbol) {
        if(arbol.getAltura()==null){
            throw  new BadRequest("p-505",HttpStatus.BAD_REQUEST,"Falta introducir la altura");
        }
        if (arbol.getPrecio()==null){
            throw  new BadRequest("p-505",HttpStatus.BAD_REQUEST,"Falta introducir el precio");

        }
        return arbolRepositori.save(arbol);
    }

    @Override
    public Optional<Arbol> buscarArbolById(Long id) {
        Optional<Arbol> arbolOptional = arbolRepositori.findById(id);
        if (arbolOptional.isEmpty()) {
            throw new NotFoundException("p-401", HttpStatus.NOT_FOUND, "El arbol no existe en base de datos");
        }
        return arbolOptional;
    }

    @Override
    public List<Arbol> listarArboles() {
        List<Arbol> listaArboles=arbolRepositori.findAll();
        if (listaArboles.isEmpty()){
            throw new NotFoundException("p-401" , HttpStatus.NOT_FOUND, "no existe ningun arbol en base de datos");
        }
        return listaArboles;
    }

    @Override
    public Arbol actualizarArbol(Arbol arbol, Long id) {
        Optional<Arbol> arbolOptional=arbolRepositori.findById(id);
        if (arbolOptional.isEmpty()){
            throw new NotFoundException("p-401" , HttpStatus.NOT_FOUND, "no existe esta flor en base de datos");
        }
        arbolOptional.get().setAltura(arbol.getAltura());
        arbolOptional.get().setPrecio(arbol.getPrecio());
        return arbolRepositori.save(arbolOptional.get());
    }

    @Override
    public void deleteArbolById(Long id) {
        Optional<Arbol> arbolOptional=arbolRepositori.findById(id);
        if (arbolOptional.isEmpty()) {
            throw new NotFoundException("p-401" , HttpStatus.BAD_REQUEST, "El arbol no existe en base de datos");
        }
        arbolRepositori.deleteById(id);
    }

    @Override
    public void deleteAllArboles() {
        arbolRepositori.deleteAll();
    }


//    @Override
//    public Optional<IArticulo> buscarArticuloById(Long id) {
//        Optional<IArticulo> articuloOptional=articuloRepositori.findById(id);
//        if (articuloOptional.isEmpty()) {
//            throw new NotFoundException("p-401" , HttpStatus.NOT_FOUND, "El articulo no existe en base de datos");
//        }
//        return articuloOptional;
//    }
//
//    @Override
//    public List<IArticulo> listarArticulos() {
//        List<IArticulo> listaArticulos=articuloRepositori.findAll();
//        if (listaArticulos.isEmpty()){
//            throw new NotFoundException("p-401" , HttpStatus.NOT_FOUND, "no existe ningun articulo en base de datos");
//        }
//        return listaArticulos;
//    }
//
//    @Override
//    public IArticulo actualizarArticulo(IArticulo articulo, Long id) {
//        Optional<IArticulo> articuloOptional=articuloRepositori.findById(id);
//        IArticulo articulo1=articuloOptional.get();
//        if (articuloOptional.isEmpty()) {
//            throw new NotFoundException("p-401" , HttpStatus.NOT_FOUND, "El articulo no existe en base de datos");
//        }
////        articulo1.setTipo(articulo.getTipo());
////        articulo1.setPrecio(articulo.getPrecio());
//        if (articulo instanceof  Arbol){
//            if(((Arbol) articulo).getAltura()==null){
//                throw new NotFoundException("p-404",HttpStatus.BAD_REQUEST,"Falta inroducir la altura del arbol");
//            } else if (articulo.getPrecio()==null) {
//                throw new NotFoundException("p404",HttpStatus.BAD_REQUEST,"Falta introducir el precio del arbol");
//            }
//
//            Arbol aux= (Arbol) articuloOptional.get();
//            aux.setAltura(((Arbol) articulo).getAltura());
//            aux.setPrecio(articulo.getPrecio());
//           articulo1=articuloRepositori.save(aux);
//        }
//        if (articulo instanceof Flor){
//            if(((Flor) articulo).getColor()==null){
//                throw new NotFoundException("p-404",HttpStatus.BAD_REQUEST,"Falta inroducir el color de la flor");
//            } else if (articulo.getPrecio()==null) {
//                throw new NotFoundException("p404",HttpStatus.BAD_REQUEST,"Falta introducir el precio de la flor");
//            }
//
//            Flor aux= (Flor) articuloOptional.get();
//            aux.setColor(((Flor) articulo).getColor());
//            aux.setPrecio(articulo.getPrecio());
//            articulo1=articuloRepositori.save(aux);
//        }
//        if (articulo instanceof Decoracion){
//            if(((Decoracion) articulo).getMaterial()==null){
//                throw new NotFoundException("p-404",HttpStatus.BAD_REQUEST,"Falta inroducir el material de la decoacionl");
//            } else if (articulo.getPrecio()==null) {
//                throw new NotFoundException("p404",HttpStatus.BAD_REQUEST,"Falta introducir el precio de la decoracion");
//            }
//
//            Decoracion aux= (Decoracion) articuloOptional.get();
//            aux.setMaterial(((Decoracion) articulo).getMaterial());
//            aux.setPrecio(articulo.getPrecio());
//            articulo1=articuloRepositori.save(aux);
//        }
//       // return articuloRepositori.save(articulo1);
//        return articulo1;
//    }
//
//    @Override
//    public void deleteArticuloById(Long id) {
//        Optional<IArticulo> articuloOptional=articuloRepositori.findById(id);
//        if (articuloOptional.isEmpty()) {
//            throw new NotFoundException("p-401" , HttpStatus.BAD_REQUEST, "El articulo no existe en base de datos");
//        }
//        articuloRepositori.deleteById(id);
//    }
//
//    @Override
//    public void deleteAllArticulos() {
//        articuloRepositori.deleteAll();
//    }
}
