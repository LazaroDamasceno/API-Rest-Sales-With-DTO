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

    void setAmountPaidInTaxes(SaleModel model) {
        var price = model.getProductPrice();
        var finalPrice = model.getFinalPrice();
        var amountPaidInTaxes = finalPrice - price;
        model.setAmountPaidInTaxes(amountPaidInTaxes);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
