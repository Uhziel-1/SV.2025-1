package com.example.mscompra.service.impl;

import com.example.mscompra.entity.Compra;
import com.example.mscompra.feign.ProductoFeign;
import com.example.mscompra.repository.CompraRepository;
import com.example.mscompra.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private ProductoFeign productoFeign;

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Compra> listar() {
        return compraRepository.findAll();
    }

    @Override
    public Compra guardar(Compra compra) {
        System.out.println("Service Impl" + compra);
        System.out.println("Repository" + compraRepository.save(compra));
        return compraRepository.save(compra);
    }

    @Override
    public Compra actualizar(Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public Optional<Compra> listarPorId(Integer id) {
        Compra compra = compraRepository.findById(id).get();
        compra.setProductoDto(productoFeign.buscarProducto(compra.getProductoId()).getBody());
        return compraRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        compraRepository.deleteById(id);
    }
}
