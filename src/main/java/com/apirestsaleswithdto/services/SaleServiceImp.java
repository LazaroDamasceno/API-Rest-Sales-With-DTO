package com.apirestsaleswithdto.services;

import com.apirestsaleswithdto.models.SaleModel;
import com.apirestsaleswithdto.repositories.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleServiceImp implements SaleService {

    final SaleRepository repository;

    @Override
    public List<SaleModel> getAll() {
        return repository.findAll();
    }

    @Override
    public SaleModel getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public SaleModel save(SaleModel model) {
        return repository.saveAndFlush(model);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
