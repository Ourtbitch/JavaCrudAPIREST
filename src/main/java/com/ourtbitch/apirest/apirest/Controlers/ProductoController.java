package com.ourtbitch.apirest.apirest.Controlers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ourtbitch.apirest.apirest.Entiries.Producto;
import com.ourtbitch.apirest.apirest.Repositories.ProductoRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProducts() {
        return productoRepository.findAll();
    }

    @PostMapping
    public Producto createProduc(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @GetMapping("/{id}")
    public Producto getProductById(@PathVariable Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el id " + id));
    }

    @PutMapping("/{id}")
    public Producto updateProduc(@PathVariable Long id, @RequestBody Producto detallesProducto) {
        
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto con el id "+id));
        producto.setNombre(detallesProducto.getNombre());
        producto.setPrecio(detallesProducto.getPrecio());

        return productoRepository.save(producto);
    }
        
    

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto con el id "+id));
        productoRepository.delete(producto);
        return "El producto con el id: "+id+" fue eliminado correctamente";
    }
}

