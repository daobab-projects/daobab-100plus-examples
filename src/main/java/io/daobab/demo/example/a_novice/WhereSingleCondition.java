package io.daobab.demo.example.a_novice;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.base.ServiceBase;
import org.springframework.stereotype.Component;


/**
 * ---------------------------------------------------------
 * - How to use where with a single condition
 * ---------------------------------------------------------
 */
@Component
public class WhereSingleCondition extends ServiceBase<Customer> {

    @Override
    public Customer call() {
        return db.select(tabCustomer)
                .whereEqual(tabCustomer.colEmail(), "BARBARA.JONES@sakilacustomer.org")
                .findOne();
    }

}
