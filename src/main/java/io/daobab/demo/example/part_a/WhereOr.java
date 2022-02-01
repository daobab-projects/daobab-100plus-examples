package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Customer;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to use WhereOR clause
 * ---------------------------------------------------------
 * - Where clauses like and() or() not() prevents from committing
 * logical errors
 */
@Component
public class WhereOr extends ServiceBase<Entities<Customer>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, WhereOr.class.getName());
    }

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
