package com.ourtbitch.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ourtbitch.apirest.apirest.Entiries.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
