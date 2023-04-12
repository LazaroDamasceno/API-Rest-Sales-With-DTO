package com.apirestsaleswithdto.services.auxiliaries;

import com.apirestsaleswithdto.models.SaleModel;

public class FinalPrice {

    public static void setFinalPrice(SaleModel model) {
        var price = model.getProductPrice();
        var salesTax = model.getSalesTax();
        var finalPrice = price * (1 + (salesTax / 100.0));
        model.setFinalPrice(finalPrice);
    }

}
