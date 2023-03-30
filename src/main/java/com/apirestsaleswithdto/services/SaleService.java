package com.apirestsaleswithdto.services;

import com.apirestsaleswithdto.models.SaleModel;

import java.util.List;

public interface SaleService {

    List<SaleModel> getAll();
    SaleModel getById(int id);
    SaleModel save(SaleModel model);
    void deleteById(int id);

}
