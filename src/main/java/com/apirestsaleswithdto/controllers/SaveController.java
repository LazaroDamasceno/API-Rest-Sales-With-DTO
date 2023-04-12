package com.apirestsaleswithdto.controllers;

import com.apirestsaleswithdto.dtos.DtoMapper;
import com.apirestsaleswithdto.dtos.SaleDTO;
import com.apirestsaleswithdto.models.SaleModel;
import com.apirestsaleswithdto.services.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sales")
public class SaveController {

    final SaleService service;

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAll() {
        return ResponseEntity.ok(DtoMapper.convertAll(service.getAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<SaleDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(new SaleDTO(service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<SaleModel> add(@RequestBody SaleModel model) throws IllegalAccessException {
        return ResponseEntity.ok(service.save(model));
    }

    @PutMapping
    public ResponseEntity<SaleModel> update(@RequestBody SaleModel model) throws IllegalAccessException {
        return ResponseEntity.ok(service.save(model));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") int id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
