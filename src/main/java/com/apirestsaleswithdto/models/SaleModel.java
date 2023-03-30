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
    String customerAdress;
    String customerEmail;
    String paymentMethod;
    double productPrice;
    double salesTax;
    double amountPaid;
    double change;

}
