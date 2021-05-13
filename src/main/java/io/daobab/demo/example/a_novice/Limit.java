package io.daobab.demo.example.a_novice;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to limit results
 * ---------------------------------------------------------
 */
@Component
public class Limit extends ServiceBase<List<Customer>> {

    @Override
    public List<Customer> call() {
        var c = tabCustomer;
        return db.select(c)
                .whereGreater(c.colID(), 10)
                .limitBy(5)
                .findMany();
    }


}
