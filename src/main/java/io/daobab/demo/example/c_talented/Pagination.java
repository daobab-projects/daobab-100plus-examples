package io.daobab.demo.example.c_talented;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Pagination
 * ---------------------------------------------------------
 */
@Component
public class Pagination extends ServiceBase<List<Customer>> {

    @Override
    public List<Customer> call() {
        var c = tabCustomer;
        return db.select(c)
                .whereGreater(c.colID(), 10)
                .page(2, 20)
                .findMany();
    }


}
