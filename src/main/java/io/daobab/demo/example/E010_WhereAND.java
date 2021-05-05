package io.daobab.demo.example;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Where AND
 * ---------------------------------------------------------
 * - How to use WhereAND clause
 * ---------------------------------------------------------
 * - Where clauses like and() or() not() prevents from committing
 * logical errors
 */
@Component
public class E010_WhereAND extends ServiceBase<Entities<Customer>> {

    @Override
    public Entities<Customer> call() {
        return way01();
    }

    public Entities<Customer> way01() {
        var t = tabCustomer;
        return db.select(t)
                .where(and()
                        .equal(t.colActive(), true)
                        .equal(t.colFirstName(), "SUSAN")
                        .equal(t.colLastName(), "WILSON")
                        .notNull(t.colAddressId())
                        .notEqual(t.colEmail(), "forbidden@email.com")
                        .greater(t.colCustomerId(), 0)
                        .between(t.colCreateDate(), toTimestamp("2005-01-01", "yyyy-MM-dd"), toTimestamp("2007-01-01", "yyyy-MM-dd"))
                )
                .findMany();
    }

    //Functional approach
    public Entities<Customer> way02() {
        var t = tabCustomer;
        return db.select(t)
                .whereAnd(w -> w
                        .equal(t.colActive(), true)
                        .equal(t.colFirstName(), "SUSAN")
                        .equal(t.colLastName(), "WILSON")
                        .notNull(t.colAddressId())
                        .notEqual(t.colEmail(), "forbidden@email.com")
                        .greater(t.colCustomerId(), 0)
                        .between(t.colCreateDate(), toTimestamp("2005-01-01", "yyyy-MM-dd"), toTimestamp("2007-01-01", "yyyy-MM-dd"))
                )
                .findMany();
    }


}
