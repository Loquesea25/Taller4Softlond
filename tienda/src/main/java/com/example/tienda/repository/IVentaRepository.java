package com.example.tienda.repository;

import com.example.tienda.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {



}
