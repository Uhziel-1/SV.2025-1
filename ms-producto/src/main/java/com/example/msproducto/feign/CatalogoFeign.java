package com.example.msproducto.feign;

import com.example.msproducto.dto.CategoriaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-catalogo-service", path = "/categoria")
public interface CatalogoFeign {
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> buscarCategoria(@PathVariable Integer id);
}