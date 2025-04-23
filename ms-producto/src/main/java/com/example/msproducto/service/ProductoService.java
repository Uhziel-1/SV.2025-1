package com.example.msproducto.service;

import com.example.msproducto.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Producto guardar(Producto producto);
    Producto actualizar(Producto producto);
    Optional<Producto> listarPorId(Integer id);
    void eliminarPorId(Integer id);
}
