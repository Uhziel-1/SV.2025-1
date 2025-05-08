package com.example.mscompra.service;

import com.example.mscompra.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface CompraService {
    List<Compra> listar();
    Compra guardar(Compra compra);
    Compra actualizar(Compra compra);
    Optional<Compra> listarPorId(Integer id);
    void eliminarPorId(Integer id);
}
