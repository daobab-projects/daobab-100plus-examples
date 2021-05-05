package io.daobab.demo.example;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Operator EQ
 * ---------------------------------------------------------
 * - How to use the most popular Operator.EQ ( = )
 * ---------------------------------------------------------
 * - This operator is default one, so every where statement without operator,
 *  is considered as EQ.
 */
@Component
public class E013_Operator_EQ extends ServiceBase<Customer> {

    @Override
    public Customer call() {
        var t = tabCustomer;
        return db.select(t)
                .whereEqual(t.colEmail(), "BARBARA.JONES@sakilacustomer.org")
                .findOne();
    }


}
