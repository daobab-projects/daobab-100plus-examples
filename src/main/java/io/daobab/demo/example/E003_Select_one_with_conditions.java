package io.daobab.demo.example;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * Get Entity by where
 * ---------------------------------------------------------
 * - How to use where clause
 */
@Component
public class E003_Select_one_with_conditions extends ServiceBase<Customer> {

    @Override
    public Customer call() {
        return way01();
    }

    //Classic usage
    public Customer way01() {
        return db.select(tabCustomer)
                .where(and()
                        .equal(tabCustomer.colActive(), true)
                        .equal(tabCustomer.colFirstName(), "SUSAN")
                        .equal(tabCustomer.colLastName(), "WILSON"))
                .findOne();
    }

    //exposing reference
    public Customer way02() {
        var t = tabCustomer;
        return db.select(t)
                .where(and()
                        .equal(t.colActive(), true)
                        .equal(t.colFirstName(), "SUSAN")
                        .equal(t.colLastName(), "WILSON"))
                .findOne();
    }

    //functional
    public Customer way03() {
        var t = tabCustomer;
        return db.select(t)
                .whereAnd(a -> a
                        .equal(t.colActive(), true)
                        .equal(t.colFirstName(), "SUSAN")
                        .equal(t.colLastName(), "WILSON"))
                .findOne();
    }
}
