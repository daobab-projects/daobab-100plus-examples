package io.daobab.demo.example.a_novice;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * How to use Order
 * ---------------------------------------------------------
 * - order clause
 * - order by many columns
 * - order asc and desc
 */
@Component
public class Order extends ServiceBase<Entities<Customer>> {

    @Override
    public Entities<Customer> call() {
        return way01();
    }

    //default order (asc)
    public Entities<Customer> way01() {
        var t = tabCustomer;
        return db.select(t)
                .whereLike(t.colFirstName(), "%S%")
                .orderBy(t.colLastName())
                .findMany();
    }

    //order asc
    public Entities<Customer> way02() {
        var t = tabCustomer;
        return db.select(t)
                .whereLike(t.colFirstName(), "%S%")
                .orderBy(asc(t.colLastName()))
                .findMany();
    }

    //order by many tables
    public Entities<Customer> way03() {
        var t = tabCustomer;
        return db.select(t)
                .whereLike(t.colFirstName(), "%S%")
                .orderBy(asc(t.colLastName()).desc(t.colLastName()).asc(t.colEmail()))
                .findMany();
    }


}
