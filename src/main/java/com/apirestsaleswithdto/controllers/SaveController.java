package com.apirestsaleswithdto.controllers;

import com.apirestsaleswithdto.dtos.SaleDTO;
import com.apirestsaleswithdto.models.SaleModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SaveController {

    ResponseEntity<List<SaleDTO>> getAll();
    ResponseEntity<SaleDTO> getById(int id);
    ResponseEntity<SaleModel> add(SaleModel model);
    ResponseEntity<SaleModel> update(SaleModel model);
    ResponseEntity<Void> deleteById(int id);

}
