package io.daobab.demo.example.model;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.dao.table.Payment;

public class PaymentLazyLoading extends Payment {

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
