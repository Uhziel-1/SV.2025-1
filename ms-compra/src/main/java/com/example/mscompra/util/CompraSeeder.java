package com.example.mscompra.util;

import com.example.mscompra.entity.Compra;
import com.example.mscompra.repository.CompraRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CompraSeeder implements CommandLineRunner {

    private final CompraRepository compraRepository;

    public CompraSeeder(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public void run(String... args) {
        if (compraRepository.count() == 0) {
                Compra compra1 = new Compra(null, "Compra de Smartphone", 1, null); // Asumiendo que el prod1 tiene ID 1
                Compra compra2 = new Compra(null, "Compra de Laptop", 2, null);    // Asumiendo que el prod2 tiene ID 2
                Compra compra3 = new Compra(null, "Compra de Camiseta", 4, null); // Asumiendo que el prod4 tiene ID 4

                compraRepository.save(compra1);
                compraRepository.save(compra2);
                compraRepository.save(compra3);

            System.out.println("Datos de productos insertados correctamente.");
        } else {
            System.out.println("Las compras ya existen, no se insertaron datos.");
        }
    }
}