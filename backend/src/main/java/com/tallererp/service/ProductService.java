package com.tallererp.service;

import com.tallererp.entity.Product;
import com.tallererp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Obtiene todos los productos
     * @return Lista de todos los productos
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Obtiene productos que llevan más de 60 días en estantería
     * @return Lista de productos con más de 60 días desde su fecha de ingreso
     */
    public List<Product> getProductsWithMoreThan60Days() {
        LocalDate fechaLimite = LocalDate.now().minusDays(60);
        return productRepository.findProductsWithMoreThanDays(fechaLimite);
    }

    /**
     * Obtiene un producto por su ID
     * @param id ID del producto
     * @return Producto encontrado
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    /**
     * Guarda un nuevo producto
     * @param product Producto a guardar
     * @return Producto guardado
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Actualiza un producto existente
     * @param id ID del producto
     * @param product Producto con los datos actualizados
     * @return Producto actualizado
     */
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);
        existingProduct.setNombre(product.getNombre());
        existingProduct.setCantidad(product.getCantidad());
        existingProduct.setStockMinimo(product.getStockMinimo());
        existingProduct.setPrecioCompra(product.getPrecioCompra());
        existingProduct.setPrecioVenta(product.getPrecioVenta());
        existingProduct.setFechaIngreso(product.getFechaIngreso());
        return productRepository.save(existingProduct);
    }

    /**
     * Elimina un producto por su ID
     * @param id ID del producto a eliminar
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

