package com.apirestsaleswithdto.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SALE")
@Data
public class SaleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String customerName;
    String customerAddress;
    String customerEmail;
    String paymentMethod;
    double productPrice;
    double salesTax;
    double amountPaidInTaxes;
    double finalPrice;
    double amountPaid;
    double change;

}
