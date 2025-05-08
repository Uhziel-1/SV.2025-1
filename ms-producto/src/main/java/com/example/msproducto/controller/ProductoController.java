package com.example.msproducto.controller;

import com.example.msproducto.entity.Producto;
import com.example.msproducto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> list() {
        System.out.println("Listando productos");
        return ResponseEntity.ok().body(productoService.listar());
    }
    @PostMapping()
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        System.out.println("Controller" + producto);
        return ResponseEntity.ok(productoService.guardar(producto));
    }
    @PutMapping()
    public ResponseEntity<Producto> update(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.actualizar(producto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Producto> listById(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(productoService.listarPorId(id).get());
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){
        productoService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }

}
