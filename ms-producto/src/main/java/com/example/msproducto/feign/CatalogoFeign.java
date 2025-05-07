package com.example.msproducto.feign;

import com.example.msproducto.dto.CategoriaDto;
import com.example.msproducto.feign.fellback.CatalogoFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-catalogo-service", path = "/categoria", fallback = CatalogoFeignFallback.class)
public interface CatalogoFeign {
    @GetMapping("/{id}")
    ResponseEntity<CategoriaDto> buscarCategoria(@PathVariable Integer id);
}