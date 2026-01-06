package com.tallererp.repository;

import com.tallererp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Busca productos que llevan más de X días en estantería
     * @param fechaLimite Fecha límite (hoy - X días)
     * @return Lista de productos que cumplen la condición
     */
    @Query("SELECT p FROM Product p WHERE p.fechaIngreso <= :fechaLimite")
    List<Product> findProductsWithMoreThanDays(@Param("fechaLimite") LocalDate fechaLimite);
}

