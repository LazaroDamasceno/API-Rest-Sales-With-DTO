package com.apirestsaleswithdto.dtos;

import com.apirestsaleswithdto.models.SaleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDTO {

    String customerName;
    String paymentMethod;
    double productPrice;
    double salesTax;
    double amountPaidInTaxes;
    double finalPrice;
    double amountPaid;
    double change;

    public SaleDTO(SaleModel model) {
        this.customerName = model.getCustomerName();
        this.paymentMethod = model.getPaymentMethod();
        this.productPrice = model.getProductPrice();
        this.salesTax = model.getSalesTax();
        this.amountPaidInTaxes = model.getAmountPaidInTaxes();
        this.finalPrice = model.getFinalPrice();
        this.amountPaid = model.getAmountPaid();
        this.change = model.getChange();
    }

}
