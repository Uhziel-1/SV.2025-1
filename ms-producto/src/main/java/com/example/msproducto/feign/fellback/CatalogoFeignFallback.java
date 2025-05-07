package com.example.msproducto.feign.fellback;

import com.example.msproducto.dto.CategoriaDto;
import com.example.msproducto.feign.CatalogoFeign;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CatalogoFeignFallback implements CatalogoFeign {
    @Override
    public ResponseEntity<CategoriaDto> buscarCategoria(Integer id) {
        CategoriaDto categoriaFallback = new CategoriaDto();
        categoriaFallback.setId(9999);
        categoriaFallback.setNombre("Categoria no disponible (fallback)");
        return ResponseEntity.ok(categoriaFallback);
    }
}