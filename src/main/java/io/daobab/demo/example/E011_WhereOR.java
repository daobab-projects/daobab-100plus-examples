package io.daobab.demo.example;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Where OR
 * ---------------------------------------------------------
 * - How to use WhereOR clause
 * ---------------------------------------------------------
 * - Where clauses like and() or() not() prevents from committing
 * logical errors
 */
@Component
public class E011_WhereOR extends ServiceBase<Entities<Customer>> {

    @Override
    public Entities<Customer> call() {
        return way01();
    }

    public Entities<Customer> way01() {
        var t = tabCustomer;
        return db.select(t)
                .where(or()
                        .equal(t.colFirstName(), "SUSAN")
                        .equal(t.colLastName(), "ANDERSON")
                )
                .findMany();
    }

    public Entities<Customer> way02() {
        var t = tabCustomer;
        return db.select(t)
                .whereOr(w -> w
                        .equal(t.colFirstName(), "SUSAN")
                        .equal(t.colLastName(), "ANDERSON")
                )
                .findMany();
    }

}
