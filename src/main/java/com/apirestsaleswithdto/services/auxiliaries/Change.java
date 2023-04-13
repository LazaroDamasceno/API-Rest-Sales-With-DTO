package com.apirestsaleswithdto.services.auxiliaries;

import com.apirestsaleswithdto.models.SaleModel;

public class Change {

    public static void setChange(SaleModel model) {
        var change = 0.0;
        if (model.getAmountPaid() - model.getFinalPrice() > 0.0) {
            change = model.getAmountPaid() - model.getFinalPrice();
        }
        model.setChange(change);
    }

}
