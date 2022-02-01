package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Customer;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
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

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, WhereNot.class.getName());
    }

    @Override
    public Entities<Customer> call() {
        var t = tabCustomer;
        return db.select(t)
                .where(not().equal(t.colActive(), true))
                .limitBy(5)
                .findMany();
    }

}
