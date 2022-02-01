package io.daobab.demo.example.part_a;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.dao.table.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ---------------------------------------------------------
 * - How to limit results
 * ---------------------------------------------------------
 */
@Component
public class Limit extends ServiceBase<List<Customer>> {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, Limit.class.getName());
    }

    @Override
    public List<Customer> call() {
        var c = tabCustomer;
        return db.select(c)
                .whereGreater(c.colID(), 10)
                .limitBy(5)
                .findMany();
    }


}
