package io.daobab.demo.example;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Remote Security - Forbidden Columns
 * ---------------------------------------------------------
 * - How to prevent from select some columns
 */
@Component
public class E083_Remote_Security_Forbidden_Columns extends ServiceBase<List<Customer>> {


    @Override
    public List<Customer> call() {
        var t = tabCustomer;
        return remote.select(t)
                .whereLess(t.colAddressId(), 10)
                .findMany();
    }


}
