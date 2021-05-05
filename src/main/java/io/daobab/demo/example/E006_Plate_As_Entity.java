package io.daobab.demo.example;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.example.base.ServiceBase;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select Plate One Table One Row As Entity
 * ---------------------------------------------------------
 * - How to get just specific columns only from single row of particular table wrapped in single Entity
 */
@Component
public class E006_Plate_As_Entity extends ServiceBase<Customer> {

    @Override
    public Customer call() {
        var t = tabCustomer;
        return db.select(t.colFirstName(), t.colLastName())
                .where(and()
                        .equal(t.colActive(), true)
                        .equal(t.colFirstName(), "SUSAN")
                        .equal(t.colLastName(), "WILSON"))
                .findOneAs(t.getClass());
    }


}
