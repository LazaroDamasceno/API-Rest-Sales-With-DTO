package com.apirestsaleswithdto.repositories;

import com.apirestsaleswithdto.models.SaleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaleRepository extends JpaRepository<SaleModel, Integer> {
    Optional<SaleModel> findById(int id);
    void deleteById(int id);
}
