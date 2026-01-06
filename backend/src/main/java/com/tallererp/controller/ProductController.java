package com.tallererp.controller;

import com.tallererp.entity.Product;
import com.tallererp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Endpoint para listar todos los productos
     * @return Lista de todos los productos
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * Endpoint para obtener productos con más de 60 días en estantería
     * @return Lista de productos con más de 60 días
     */
    @GetMapping("/old-stock")
    public ResponseEntity<List<Product>> getProductsWithMoreThan60Days() {
        List<Product> products = productService.getProductsWithMoreThan60Days();
        return ResponseEntity.ok(products);
    }

    /**
     * Endpoint para obtener un producto por ID
     * @param id ID del producto
     * @return Producto encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    /**
     * Endpoint para crear un nuevo producto
     * @param product Producto a crear
     * @return Producto creado
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    /**
     * Endpoint para actualizar un producto existente
     * @param id ID del producto
     * @param product Producto con los datos actualizados
     * @return Producto actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * Endpoint para eliminar un producto
     * @param id ID del producto a eliminar
     * @return Respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

