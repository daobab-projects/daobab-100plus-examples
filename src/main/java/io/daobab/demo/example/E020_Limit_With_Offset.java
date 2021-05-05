package io.daobab.demo.example;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * Limit results with Offset
 * ---------------------------------------------------------
 * - How to limit results with offset
 */
@Component
public class E020_Limit_With_Offset extends ServiceBase<List<Customer>> {

    @Override
    public List<Customer> call() {
        var c = tabCustomer;
        return db.select(c)
                .whereGreater(c.colID(), 10)
                .limitBy(5, 13)
                .findMany();
    }


}
