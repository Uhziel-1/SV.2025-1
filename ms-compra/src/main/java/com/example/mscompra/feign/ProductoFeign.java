package com.example.mscompra.feign;

import com.example.mscompra.dto.ProductoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-producto-service", path = "/producto")
public interface ProductoFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "productoListarPorIdCB", fallbackMethod = "fallbackProductoById")
    ResponseEntity<ProductoDto> buscarProducto(@PathVariable Integer id);

    default ResponseEntity<ProductoDto> fallbackProductoById(Integer id, Exception e) {
        ProductoDto productoDto = new ProductoDto();
        productoDto.setNombre("Servicio no disponible de catálogo");
        return ResponseEntity.ok(productoDto);
    }
}