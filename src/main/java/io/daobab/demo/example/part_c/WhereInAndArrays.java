package io.daobab.demo.example.part_c;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Customer;
import io.daobab.target.buffer.single.Entities;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Operator IN and Arrays
 * ---------------------------------------------------------
 * - How to use IN and Arrays
 */
@Component
public class WhereInAndArrays extends ServiceBase<Entities<Customer>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, WhereInAndArrays.class.getName());
    }

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
