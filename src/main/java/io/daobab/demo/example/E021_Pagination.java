package io.daobab.demo.example;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Pagination
 * ---------------------------------------------------------
 * - How to use pagination
 */
@Component
public class E021_Pagination extends ServiceBase<List<Customer>> {

    @Override
    public List<Customer> call() {
        var c = tabCustomer;
        return db.select(c)
                .whereGreater(c.colID(), 10)
                .page(2, 20)
                .findMany();
    }


}
