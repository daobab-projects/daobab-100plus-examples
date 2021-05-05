package io.daobab.demo.example;

import io.daobab.demo.dao.table.Customer;
import io.daobab.demo.example.base.ServiceBase;
import io.daobab.result.Entities;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Operator IN and Arrays
 * ---------------------------------------------------------
 * - How to use IN and Arrays
 */
@Component
public class E096_Operator_IN_And_Arrays extends ServiceBase<Entities<Customer>> {


    @Override
    public Entities<Customer> call() {
        var p = tabCustomer;

        return db.select(p)
                .whereIn(p.colFirstName(),
                        "BARBARA", "HELEN", "NANCY", "SUSAN", "MARGARET", "MARY")
                .limitBy(5)
                .findMany();
    }


}
