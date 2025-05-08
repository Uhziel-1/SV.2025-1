package com.example.mscompra.controller;

import com.example.mscompra.entity.Compra;
import com.example.mscompra.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @GetMapping
    public ResponseEntity<List<Compra>> list() {
        System.out.println("Listando compras");
        return ResponseEntity.ok().body(compraService.listar());
    }
    @PostMapping()
    public ResponseEntity<Compra> save(@RequestBody Compra compra){
        System.out.println("Controller" + compra);
        return ResponseEntity.ok(compraService.guardar(compra));
    }
    @PutMapping()
    public ResponseEntity<Compra> update(@RequestBody Compra compra){
        return ResponseEntity.ok(compraService.actualizar(compra));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Compra> listById(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(compraService.listarPorId(id).get());
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){
        compraService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }

}
