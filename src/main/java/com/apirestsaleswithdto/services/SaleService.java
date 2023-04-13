package com.apirestsaleswithdto.services;

import com.apirestsaleswithdto.models.SaleModel;

import java.util.List;
import java.util.NoSuchElementException;

public interface SaleService {

    List<SaleModel> getAll();
    SaleModel getById(int id) throws NoSuchElementException;
    SaleModel save(SaleModel model) throws IllegalAccessException;
    void deleteById(int id) throws NoSuchElementException;

}
