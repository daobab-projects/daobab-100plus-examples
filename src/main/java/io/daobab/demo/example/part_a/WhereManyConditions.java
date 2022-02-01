package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * - How to use where clause with many conditions
 * ---------------------------------------------------------
 */
@Component
public class WhereManyConditions extends ServiceBase<Customer> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, WhereManyConditions.class.getName());
    }

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
