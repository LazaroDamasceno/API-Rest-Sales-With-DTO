package com.apirestsaleswithdto.services;

import com.apirestsaleswithdto.models.SaleModel;
import com.apirestsaleswithdto.repositories.SaleRepository;
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
        setFinalPrice(model);
        setChange(model);
        setAmountPaidInTaxes(model);
        return repository.saveAndFlush(model);
    }

    void setFinalPrice(SaleModel model) {
        var price = model.getProductPrice();
        var salesTax = model.getSalesTax();
        var finalPrice = price * (1 + (salesTax / 100.0));
        model.setFinalPrice(finalPrice); 
    }

    void setChange(SaleModel model) {
        var change = 0.0;
        if (model.getAmountPaid() - model.getFinalPrice() > 0.0) {
            change = model.getAmountPaid() - model.getFinalPrice();
        }
        model.setChange(change);
    }

    void setAmountPaidInTaxes(SaleModel model) throws IllegalAccessException {
        var price = model.getProductPrice();
        var finalPrice = model.getFinalPrice();
        var amountPaidInTaxes = finalPrice - price;
        model.setAmountPaidInTaxes(amountPaidInTaxes);
    }

    @Override
    public void deleteById(int id) throws NoSuchElementException {
        repository.deleteById(id);
    }
}
