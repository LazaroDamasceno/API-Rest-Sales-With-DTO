package com.apirestsaleswithdto.services;

import com.apirestsaleswithdto.models.SaleModel;
import com.apirestsaleswithdto.repositories.SaleRepository;
import com.apirestsaleswithdto.services.auxiliaries.AmountPaidInTaxes;
import com.apirestsaleswithdto.services.auxiliaries.Change;
import com.apirestsaleswithdto.services.auxiliaries.FinalPrice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SaleServiceImp implements SaleService {

    final SaleRepository repository;

    @Override
    public List<SaleModel> getAll() {
        return repository.findAll();
    }

    @Override
    public SaleModel getById(int id) throws NoSuchElementException {
        return repository.findById(id).get();
    }

    @Override
    public SaleModel save(SaleModel model) throws IllegalAccessException {
        FinalPrice.setFinalPrice(model);
        Change.setChange(model);
        AmountPaidInTaxes.setAmountPaidInTaxes(model);
        return repository.saveAndFlush(model);
    }

    @Override
    public void deleteById(int id) throws NoSuchElementException {
        repository.deleteById(id);
    }
}
