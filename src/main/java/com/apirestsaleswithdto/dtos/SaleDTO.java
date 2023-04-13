package com.apirestsaleswithdto.dtos;

import com.apirestsaleswithdto.models.SaleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.Locale;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDTO {

    String customerName;
    String paymentMethod;
    String productPrice;
    String salesTax;
    String amountPaidInTaxes;
    String finalPrice;
    String amountPaid;
    String change;

    public SaleDTO(SaleModel model) {
        Locale.setDefault(Locale.US);
        this.customerName = model.getCustomerName();
        this.paymentMethod = model.getPaymentMethod();
        this.productPrice = "R$ " + new DecimalFormat("#,###.00").format(model.getProductPrice());
        this.salesTax = "R$ " + new DecimalFormat("#,###.00").format(model.getSalesTax());
        this.amountPaidInTaxes = "R$ " + new DecimalFormat("#,###.00").format(model.getAmountPaidInTaxes());
        this.finalPrice = "R$ " + new DecimalFormat("#,###.00").format(model.getFinalPrice());
        this.amountPaid = "R$ " + new DecimalFormat("#,###.00").format(model.getAmountPaid());
        this.change = "R$ " + new DecimalFormat("#,###.00").format(model.getChange());
    }

}
