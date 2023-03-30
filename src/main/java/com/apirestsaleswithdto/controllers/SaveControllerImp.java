package com.apirestsaleswithdto.controllers;

import com.apirestsaleswithdto.dtos.DtoMapper;
import com.apirestsaleswithdto.dtos.SaleDTO;
import com.apirestsaleswithdto.models.SaleModel;
import com.apirestsaleswithdto.services.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("/sales")
public class SaveControllerImp implements SaveController {

    final SaleService service;

    @Override
    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAll() {
        return new ResponseEntity<>(DtoMapper.convertAll(service.getAll()), OK);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<SaleDTO> getById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(new SaleDTO(service.getById(id)), OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<SaleModel> add(@RequestBody SaleModel model) {
        return new ResponseEntity<>(service.save(model), OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<SaleModel> update(@RequestBody SaleModel model) {
        return new ResponseEntity<>(service.save(model), OK);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") int id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
