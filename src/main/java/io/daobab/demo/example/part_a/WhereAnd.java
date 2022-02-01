package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Customer;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * - How to use WhereAND clause
 * ---------------------------------------------------------
 * - Where clauses like and() or() not() prevents from committing
 * logical errors
 */
@Component
public class WhereAnd extends ServiceBase<Entities<Customer>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, WhereAnd.class.getName());
    }

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
