package com.apirestsaleswithdto.services.auxiliaries;

import com.apirestsaleswithdto.models.SaleModel;

public class AmountPaidInTaxes {

    public static void setAmountPaidInTaxes(SaleModel model) throws IllegalAccessException {
        var price = model.getProductPrice();
        var finalPrice = model.getFinalPrice();
        var amountPaidInTaxes = finalPrice - price;
        model.setAmountPaidInTaxes(amountPaidInTaxes);
    }

}
