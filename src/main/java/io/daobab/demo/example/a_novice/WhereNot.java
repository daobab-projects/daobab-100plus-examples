package io.daobab.demo.example.a_novice;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to use WhereNOT clause
 * ---------------------------------------------------------
 * - Where clauses like and() or() not() prevents from committing
 * logical errors
 */
@Component
public class WhereNot extends ServiceBase<Entities<Customer>> {

    @Override
    public Entities<Customer> call() {
        var t = tabCustomer;
        return db.select(t)
                .where(not().equal(t.colActive(), true))
                .findMany();
    }

}
