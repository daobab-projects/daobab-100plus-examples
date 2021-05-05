package io.daobab.demo.example;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Where NOT
 * ---------------------------------------------------------
 * - How to use WhereNOT clause
 * ---------------------------------------------------------
 * - Where clauses like and() or() not() prevents from committing
 * logical errors
 */
@Component
public class E012_WhereNOT extends ServiceBase<Entities<Customer>> {

    @Override
    public Entities<Customer> call() {
        var t = tabCustomer;
        return db.select(t)
                .where(not().equal(t.colActive(), true))
                .findMany();
    }

}
