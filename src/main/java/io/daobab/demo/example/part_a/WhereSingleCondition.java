package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * - How to use where with a single condition
 * ---------------------------------------------------------
 */
@Component
public class WhereSingleCondition extends ServiceBase<Customer> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, WhereSingleCondition.class.getName());
    }

    @Override
    public Customer call() {
        return db.select(tabCustomer)
                .whereEqual(tabCustomer.colEmail(), "BARBARA.JONES@sakilacustomer.org")
                .findOne();
    }

}
