package io.daobab.demo.example.part_b;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------
 * Select As Entity
 * ---------------------------------------------------------
 * - How to get just specific columns only from single row of particular table wrapped in single Entity
 */
@Component
public class PlateAsEntity extends ServiceBase<Customer> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, PlateAsEntity.class.getName());
    }

    @Override
    public Customer call() {
        var customer = tabCustomer;
        return db.select(customer.colFirstName(), customer.colLastName())
                .where(and()
                        .equal(customer.colActive(), true)
                        .equal(customer.colFirstName(), "SUSAN")
                        .equal(customer.colLastName(), "WILSON"))
                .findOneAs(customer.getClass());
    }


}
